package businesslogic.inventorybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.orderbl.OrderTrans;
import businesslogic.organizationbl.transferbl.TransferInfo;
import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.inventorydataservice.InventoryDataService;
import po.CommodityPO;
import po.InventoryPO;
import po.TransferPO;
import state.ReceiptType;
import state.ResultMessage;
import util.ExportExcel;
import vo.CommodityVO;
import vo.InventoryCheckVO;
import vo.InventoryPositionVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:19
 */
public class Inventory {
	private InventoryDataService inventoryData;
	private ReceiptInfo_Inventory receiptInfo;
	private TransferInfo transferInfo;

	public Inventory() throws MalformedURLException, RemoteException, NotBoundException {
		receiptInfo = new ReceiptInfo();
		transferInfo = new TransferInfo();
		inventoryData = getData();
	}

	public InventoryDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (InventoryDataService) Naming.lookup(RMIConfig.PREFIX + InventoryDataService.NAME);
	}

	/**
	 * 根据中转中心的编号获得中转中心的仓库
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @return InventoryVO型，仓库
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryVO getInventory(String transferID) throws RemoteException {
		InventoryPO inventoryPO = this.findInventoryByTransferID(transferID);
		InventoryVO inventoryVO = InventoryTrans.convertPOtoVO(inventoryPO);
		return inventoryVO;
	}

	public String getImportID() throws RemoteException {
		String ID = receiptInfo.getImportID();
		return ID;
	}

	public String getExportID() throws RemoteException {
		String ID = receiptInfo.getExportID();
		return ID;
	}

	public String getAdjustID() throws RemoteException {
		String ID = receiptInfo.getImportID();
		return ID;
	}

	/**
	 * 生成入库单
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param commodity
	 *            CommodityVO型，货物
	 * @param area
	 *            int型， 区号
	 * @param row
	 *            int型，排号
	 * @param frame
	 *            int型，架号
	 * @param position
	 *            int型，位号
	 * @return InventoryImportReceiptVO型，仓库入库单
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryImportReceiptVO addCommodities(String transferID, CommodityVO commodity, int area, int row,
			int frame, int position) throws RemoteException {
//		inventoryImport(transferID, commodity, area, row, frame, position);
		// 添加入库单
		return receiptInfo.addImportReceipt(commodity, area, row, frame, position,transferID);
	}

	

	/**
	 * 生成仓库出库单
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param area
	 *            int型， 区号
	 * @param row
	 *            int型，排号
	 * @param frame
	 *            int型，架号
	 * @param position
	 *            int型，位号
	 * @return InventoryExportReceiptVO型，仓库出库单
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryExportReceiptVO minusCommodities(String transferID, int area, int row, int frame, int position)
			throws RemoteException {
		// 通过中转中心的id获取inventoryPO
		InventoryPO inventoryPO = this.findInventoryByTransferID(transferID);
		// 获得商品
		CommodityPO[][][][] commos = inventoryPO.getCommos();
		CommodityPO commodityPO = commos[area][row][frame][position];
		// 添加出库单
		String id = receiptInfo.getExportID();
		InventoryExportReceiptVO vo = new InventoryExportReceiptVO(id, ReceiptType.OUTSTOCK, transferID,
				OrderTrans.convertPOtoVO(commodityPO), area, row, frame, position);
		receiptInfo.add(vo);
		return vo;
	}

	

	/**
	 * 生成库存调整单（保存到出数据中）
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param exArea
	 *            int型，调整前区
	 * @param exRow
	 *            int型，调整前排
	 * @param exFrame
	 *            int型，调整前架
	 * @param exPosition
	 *            int型，调整前位
	 * @param afArea
	 *            int型，调整后区
	 * @param afRow
	 *            int型，调整后排
	 * @param afFrame
	 *            int型，调整后架
	 * @param afPosition
	 *            int型，调整后位
	 * @return ResultMessage型，调整是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage adjust(String transferID, int exArea, int exRow, int exFrame, int exPosition, int afArea,
			int afRow, int afFrame, int afPosition) throws RemoteException {
		this.inventoryAdjust(transferID, exArea, exRow, exFrame, exPosition, afArea, afRow, afFrame, afPosition);
		// 生成库存调整单
		String adjustID = receiptInfo.getAdjustID();
		AdjustReceiptVO vo = new AdjustReceiptVO(adjustID, ReceiptType.TAKINGSTOCK, exArea, exRow, exFrame, exPosition,
				afArea, afRow, afFrame, afPosition);
		return receiptInfo.add(vo);
	
	}

	private void inventoryAdjust(String transferID, int exArea, int exRow, int exFrame, int exPosition, int afArea,
			int afRow, int afFrame, int afPosition) throws RemoteException {
		// 修改库存
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		CommodityPO[][][][] commos = inventory.getCommos();
		CommodityPO adjustCommodity = commos[exArea][exRow][exFrame][exPosition];
		commos[afArea][afRow][afFrame][afPosition] = adjustCommodity;
		commos[exArea][exRow][exFrame][exPosition] = null;
		inventory.setCommos(commos);
		inventoryData.modify(inventory);
		updateTransferInventory(transferID, inventory);
	}

	/**
	 * 生成库存查看单 （查看开始日期到结束日期的出库入库数量和现在的库存）
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param beginDate
	 *            String型，开始日期
	 * @param endDate
	 *            String型，结束日期
	 * @return InventoryViewVO型，库存查看单
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryViewVO viewInventory(String transferID, String beginDate, String endDate) throws RemoteException {
		InventoryPO inventoryPO = this.findInventoryByTransferID(transferID);
		InventoryVO inventoryVO = InventoryTrans.convertPOtoVO(inventoryPO);
		// 通过receiptInfo得到一段时间内入库单和出库单
		ArrayList<InventoryImportReceiptVO> importReceipts = receiptInfo.showInDateByType(beginDate, endDate,
				ReceiptType.INSTOCK);
		ArrayList<InventoryExportReceiptVO> exportReceipts = receiptInfo.showInDateByType(beginDate, endDate,
				ReceiptType.OUTSTOCK);
		// 获得仓库中商品位置
		ArrayList<InventoryPositionVO> commoditiesInInventory = this.getCommoditiesInInventory(transferID);
		// 新建库存查看VO
		InventoryViewVO viewVO = new InventoryViewVO(exportReceipts, importReceipts, commoditiesInInventory,
				inventoryVO);
		return viewVO;
	}

	/**
	 * 生成库存盘点单
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param date
	 *            String型，盘点日期
	 * @return InventoryCheckVO型，库存盘点单
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryCheckVO checkRecord(String transferID, String date) throws RemoteException {
		ArrayList<InventoryPositionVO> commosInInventory = this.getCommoditiesInInventory(transferID);
		if (receiptInfo.hasChecked())
			return null;
		String lotNum = inventoryData.getLotID();
		InventoryCheckVO checkVO = new InventoryCheckVO(commosInInventory, lotNum, transferID);
		return checkVO;
	}



	/**
	 * 获得仓库中的所有商品
	 * 
	 * @param transferID
	 *            中转中心编号
	 * @return ArrayList<InventoryPositionVO>型，所有商品列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<InventoryPositionVO> getCommoditiesInInventory(String transferID) throws RemoteException {
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		if (inventory == null) {
			return new ArrayList<>();
		}
		CommodityPO[][][][] commos = inventory.getCommos();
		ArrayList<InventoryPositionVO> commosInInventory = new ArrayList<>();
		// 总区数
		int inventoryArea = commos.length;
		// 总排数
		int inventoryRow = commos[0].length;
		// 总架数
		int inventoryFrame = commos[0][0].length;
		// 总位数
		int inventoryPosition = commos[0][0][0].length;
		for (int area = 0; area < inventoryArea; area++) {
			for (int row = 0; row < inventoryRow; row++) {
				for (int frame = 0; frame < inventoryFrame; frame++) {
					for (int position = 0; position < inventoryPosition; position++) {
						// 获得商品值对象（Value Object）
						CommodityVO commodity = OrderTrans.convertPOtoVO(commos[area][row][frame][position]);
						// 如果在该位置有商品，则添加到结果列表中
						if (commodity != null) {
							InventoryPositionVO commodityPosition = new InventoryPositionVO(area, row, frame, position,
									commodity);
							commosInInventory.add(commodityPosition);
						}
					}
				}
			}
		}
		return commosInInventory;
	}

	/**
	 * 获得所有位置
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @return CommodityPO[][][][]型，仓库中的所有商品四维数组
	 * @throws RemoteException
	 *             远程异常
	 */
	public CommodityPO[][][][] getPositionsInArray(String transferID) throws RemoteException {
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		CommodityPO[][][][] commos = inventory.getCommos();
		return commos;
	}

	/**
	 * 获得仓库中的所有空位置
	 * 
	 * @param transferID
	 *            中转中心编号
	 * @return ArrayList<InventoryPositionVO>型，所有空位置列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<InventoryPositionVO> getEmptyPositionsInList(String transferID) throws RemoteException {
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		// 如果中转中心没有仓库，返回空列表
		if (inventory == null) {
			return new ArrayList<>();
		}
		CommodityPO[][][][] commos = inventory.getCommos();
		ArrayList<InventoryPositionVO> commosInInventory = new ArrayList<>();
		// 总区数
		int inventoryArea = commos.length;
		// 总排数
		int inventoryRow = commos[0].length;
		// 总架数
		int inventoryFrame = commos[0][0].length;
		// 总位数
		int inventoryPosition = commos[0][0][0].length;
		for (int area = 0; area < inventoryArea; area++) {
			for (int row = 0; row < inventoryRow; row++) {
				for (int frame = 0; frame < inventoryFrame; frame++) {
					for (int position = 0; position < inventoryPosition; position++) {
						// 获得商品值对象（Value Object）
						CommodityVO commodity = OrderTrans.convertPOtoVO(commos[area][row][frame][position]);
						// 如果在该位置没有商品，则添加到结果列表中
						if (commodity == null) {
							InventoryPositionVO commodityPosition = new InventoryPositionVO(area, row, frame, position,
									commodity);
							commosInInventory.add(commodityPosition);
						}
					}
				}
			}
		}
		System.out.println(commosInInventory.size());
		return commosInInventory;
	}

	/**
	 * 获取仓库使用率
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @return double型，仓库使用率
	 * @throws RemoteException
	 *             远程异常
	 */
	public double inventoryUseRate(String transferID) throws RemoteException {
		// 正在使用的仓库位置个数
		double positionUsed = 0;
		// 不在使用的仓库位置个数
		double positionNotUsed = 0;
		// 仓库使用率
		double useRate = 0;
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		CommodityPO[][][][] commos = inventory.getCommos();
		for (CommodityPO[][][] areas : commos) {
			for (CommodityPO[][] rows : areas) {
				for (CommodityPO[] frames : rows) {
					for (CommodityPO commoInPosition : frames) {
						if (commoInPosition == null)
							positionNotUsed += 1;
						else
							positionUsed += 1;
					}
				}
			}
		}
		useRate = positionUsed / (positionUsed + positionNotUsed);
		return useRate;
	}

	/**
	 * 将仓库盘点结果输出到excel文件
	 * 
	 * @param vo
	 *            库存盘点值对象（Value Object）
	 */
	public void exportToExcel(InventoryCheckVO vo) {
		String fileName = "output/" + "库存盘点" + vo.lotNum + ".xls";
		String head = vo.transferID + "中转中心库存" + vo.date + "盘点记录";
		String[] title = { "区号", "排号", "架号", "位号", "商品信息" };
		List<Object> list = new ArrayList<>();
		for (InventoryPositionVO position : vo.commos) {
			list.add(position);
		}
		ExportExcel.exportExcel(fileName, head, title, list);
	}

	/**
	 * 通过中转中心的ID编号查找相应的仓库
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @return InventoryPO型，仓库持久化对象
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryPO findInventoryByTransferID(String transferID) throws RemoteException {
		TransferPO transferPO = transferInfo.getTransfer(transferID);
		System.out.println(transferPO);
		if (transferPO == null) {
			return null;
		}
		System.out.println(transferPO.getInventories().size());
		return transferPO.getInventories().get(0);
	}
	
	private void updateTransferInventory(String transferID, InventoryPO inventoryPO) throws RemoteException {
		TransferPO transferPO = transferInfo.getTransfer(transferID);
		ArrayList<InventoryPO> inventories = new ArrayList<>();
		inventories.add(inventoryPO);
		transferPO.setInventories(inventories);
		transferInfo.modify(transferPO);
	}
}
