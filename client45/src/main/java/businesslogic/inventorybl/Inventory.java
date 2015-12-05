package businesslogic.inventorybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.orderbl.OrderTrans;
import businesslogic.receiptbl.ReceiptInfo;
import businesslogic.transferbl.TransferInfo;
import config.RMIConfig;
import dataservice.inventorydataservice.InventoryDataService;
import po.CommodityPO;
import po.InventoryPO;
import po.TransferPO;
import state.ReceiptState;
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
	private TransferInfo_Inventory transferInfo;
	public Inventory() {
		receiptInfo = new ReceiptInfo();
		transferInfo = new TransferInfo();
		inventoryData = getData();
	}
	public InventoryDataService getData(){
		try {
			return (InventoryDataService) Naming.lookup(RMIConfig.PREFIX + InventoryDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}


	public InventoryViewVO viewInventory(String transferID,String beginDate, String endDate) throws RemoteException {
		InventoryPO inventoryPO = this.findInventoryByTransferID(transferID);
		InventoryVO inventoryVO = InventoryTrans.convertPOtoVO(inventoryPO);
		//通过receiptInfo得到一段时间内入库单和出库单
		ArrayList<InventoryImportReceiptVO> importReceipts = receiptInfo.showInDateByType(beginDate, endDate, ReceiptType.INSTOCK);
		ArrayList<InventoryExportReceiptVO> exportReceipts = receiptInfo.showInDateByType(beginDate, endDate, ReceiptType.OUTSTOCK);
		//获得仓库中商品位置
		ArrayList<InventoryPositionVO> commoditiesInInventory = this.getCommoditiesInInventory(transferID);
		//新建库存查看VO
		InventoryViewVO viewVO = new InventoryViewVO(exportReceipts, importReceipts, commoditiesInInventory, inventoryVO);
		return viewVO;
	}
	
	public InventoryCheckVO checkRecord(String transferID,String enddate) throws RemoteException {
		ArrayList<InventoryPositionVO> commosInInventory = this.getCommoditiesInInventory(transferID);
		if(receiptInfo.hasChecked())
			return null;
		String lotNum = inventoryData.getLotID();
		InventoryCheckVO checkVO = new InventoryCheckVO(commosInInventory, lotNum,transferID);
		return checkVO;
	}

	public String getImportID() throws RemoteException {
		String ID = receiptInfo.getImportID();
		return ID;
	}
	
	//生成入库单
	public InventoryImportReceiptVO addCommodities(String transferID,CommodityVO commodity, int area ,int row,int frame,int position) throws RemoteException {
		//修改仓库信息
		CommodityPO commodityPO = OrderTrans.convertVOtoPO(commodity);
		//通过中转中心的id获取inventoryPO
		InventoryPO inventoryPO = this.findInventoryByTransferID(transferID);
		//修改库存
		CommodityPO[][][][] commos = inventoryPO.getCommos();
		commos[area][row][frame][position]=commodityPO;
		inventoryPO.setCommos(commos);
		inventoryData.modify(inventoryPO);
		//添加入库单
		return receiptInfo.addImportReceipt(commodity, area, row, frame, position);
	}
	/**
	 * 通过中转中心的ID编号查找相应的仓库
	 * @param transferID
	 * @return
	 * @throws RemoteException
	 */
    private InventoryPO findInventoryByTransferID(String transferID) throws RemoteException {
    	TransferPO transferPO = transferInfo.getTransfer(transferID);
    	if(transferPO==null){
    		return null;
    	}
    	return transferPO.getInventories().get(0);
	}
	public ResultMessage saveImport(InventoryImportReceiptVO importReceipt) throws RemoteException{
		importReceipt.receiptState=ReceiptState.DRAFT;
		return receiptInfo.add(importReceipt);
    }
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) throws RemoteException {
		importReceipt.receiptState=ReceiptState.APPROVALING;
		return receiptInfo.modify(importReceipt);
	}
    
	public String getExportID() throws RemoteException {
		String ID = receiptInfo.getExportID();
		return ID;
	}
	//生成出库单
	public InventoryExportReceiptVO minusCommodities(String transferID, int area,int row,int frame,int position) throws RemoteException {
		//通过中转中心的id获取inventoryPO
		InventoryPO inventoryPO = this.findInventoryByTransferID(transferID);
		//修改库存
		CommodityPO[][][][] commos = inventoryPO.getCommos();
		CommodityPO commodityPO=commos[area][row][frame][position];
		commos[area][row][frame][position]=null;
		inventoryPO.setCommos(commos);
		inventoryData.modify(inventoryPO);
		//添加出库单
		String id = receiptInfo.getExportID();
		InventoryExportReceiptVO vo = new InventoryExportReceiptVO(id, ReceiptType.OUTSTOCK, transferID, OrderTrans.convertPOtoVO(commodityPO), area, row, frame, position);
		receiptInfo.add(vo);
		return vo;
	}
	 public ResultMessage saveExport(InventoryExportReceiptVO exportReceipt) throws RemoteException{
		 exportReceipt.receiptState=ReceiptState.DRAFT;
		 return receiptInfo.add(exportReceipt);
	    }
	 
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) throws RemoteException {
		exportReceipt.receiptState=ReceiptState.APPROVALING;
		return receiptInfo.modify(exportReceipt);
	}

	public String getAdjustID() throws RemoteException {
		String ID = receiptInfo.getImportID();
		return ID;
	}
	
	public InventoryVO getInventory(String transferID) throws RemoteException{
		InventoryPO inventoryPO = this.findInventoryByTransferID(transferID);
		InventoryVO inventoryVO  = InventoryTrans.convertPOtoVO(inventoryPO);
		return inventoryVO;
	}
	
	public ResultMessage adjust(String transferID, int exArea,int exRow,int exFrame,int exPosition, int afArea,int afRow,int afFrame,int afPosition) throws RemoteException {
		//生成库存调整单
		String adjustID = receiptInfo.getAdjustID();
		AdjustReceiptVO vo = new AdjustReceiptVO(adjustID, ReceiptType.TAKINGSTOCK, exArea,exRow,exFrame,exPosition,afArea,afRow,afFrame,afPosition);
		receiptInfo.add(vo);
		// 修改库存
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		CommodityPO[][][][] commos = inventory.getCommos();
		CommodityPO adjustCommodity = commos[exArea][exRow][exFrame][exPosition];
		commos[afArea][afRow][afFrame][afPosition] = adjustCommodity;
		commos[exArea][exRow][exFrame][exPosition]=null;
		inventory.setCommos(commos);
		return inventoryData.modify(inventory);
	}
	
	public double inventoryUseRate(String transferID) throws RemoteException{
		double positionUsed=0;
		double positionNotUsed=0;
		double useRate=0;
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		CommodityPO[][][][] commos = inventory.getCommos();
		for (CommodityPO[][][] areas : commos) {
			for (CommodityPO[][] rows : areas) {
				for (CommodityPO[] frames : rows) {
					for (CommodityPO commoInPosition : frames) {
						if(commoInPosition==null)	positionNotUsed+=1;
						else									positionUsed+=1;
					}
				}
			}
		}
		useRate=positionUsed/(positionUsed+positionNotUsed);
		return useRate;
	}
	public void exportToExcel(InventoryCheckVO vo) {
		String fileName="output/"+"库存盘点"+vo.lotNum+".xls";
		String head=vo.transferID+"中转中心库存"+vo.date+"盘点记录";
		String[] title = {"区号","排号","架号","位号","商品信息"};
		List<Object> list = new ArrayList<>();
		for (InventoryPositionVO position : vo.commos) {
			list.add(position);
		}
		ExportExcel.exportExcel(fileName, head, title, list);
	}
	public ArrayList<InventoryPositionVO> getCommoditiesInInventory(String transferID) throws RemoteException{
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		if(inventory==null){
			return new ArrayList<>();
		}
		CommodityPO[][][][] commos = inventory.getCommos();
		ArrayList<InventoryPositionVO> commosInInventory = new ArrayList<>();
		int inventoryArea = commos.length;
		int inventoryRow= commos[0].length;
		int inventoryFrame = commos[0][0].length;
		int inventoryPosition = commos[0][0][0].length;
		for (int area= 0; area <inventoryArea ; area++) {
			for (int row = 0; row < inventoryRow; row++) {
				for (int frame = 0; frame < inventoryFrame; frame++) {
					for (int position = 0; position < inventoryPosition; position++) {
						CommodityVO commodity = OrderTrans.convertPOtoVO(commos[area][row][frame][position]);
						if(commodity!=null){
							InventoryPositionVO commodityPosition = new InventoryPositionVO(area, row, frame, position, commodity);
							commosInInventory.add(commodityPosition);
						}
					}
				}
			}
		}
		return commosInInventory;
	}
	
	public CommodityPO[][][][] getEmptyPositionsInArray(String transferID) throws RemoteException{
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		CommodityPO[][][][] commos = inventory.getCommos();
		return commos;
	}
	
	public ArrayList<InventoryPositionVO> getEmptyPositionsInList(String transferID) throws RemoteException{
		InventoryPO inventory = this.findInventoryByTransferID(transferID);
		CommodityPO[][][][] commos = inventory.getCommos();
		ArrayList<InventoryPositionVO> commosInInventory = new ArrayList<>();
		int inventoryArea = commos.length;
		int inventoryRow= commos[0].length;
		int inventoryFrame = commos[0][0].length;
		int inventoryPosition = commos[0][0][0].length;
		for (int area= 0; area <inventoryArea ; area++) {
			for (int row = 0; row < inventoryRow; row++) {
				for (int frame = 0; frame < inventoryFrame; frame++) {
					for (int position = 0; position < inventoryPosition; position++) {
						CommodityVO commodity = OrderTrans.convertPOtoVO(commos[area][row][frame][position]);
						if(commodity==null){
							InventoryPositionVO commodityPosition = new InventoryPositionVO(area, row, frame, position, commodity);
							commosInInventory.add(commodityPosition);
						}
					}
				}
			}
		}
		return commosInInventory;
	}
}


