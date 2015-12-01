package businesslogic.inventorybl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.OrderTrans;
import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.inventorydataservice.InventoryDataService;
import po.CommodityPO;
import po.InventoryPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import state.ExpressType;
import state.ReceiptCondition;
import state.ReceiptType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
//TODO 要发生较大改动！！！！！！！
//虽然和初衷不一样，但是果然发生了超大改动
/**
 * 
 * @author Ann
 *
 */
public class Inventory {
	private InventoryDataService inventoryData;
	private ReceiptInfo_Inventory receiptInfo;
	public Inventory() {
		receiptInfo = new ReceiptInfo();
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
		//通过receiptInfo得到一段时间内入库单和出库单的数量
		int importNumber=receiptInfo.getImportNumber(beginDate, endDate);
		int exportNumber = receiptInfo.getExportNumber(beginDate, endDate);
		int sum = importNumber+exportNumber;
		//新建库存查看VO
		InventoryViewVO viewVO = new InventoryViewVO(importNumber,exportNumber,sum, inventoryVO);
		return viewVO;
	}
	

	public InventoryCheckVO checkRecord(String enddate) throws RemoteException {
		ArrayList<InventoryPO> pos = inventoryData.find();
		ArrayList<InventoryVO> VOs =InventoryTrans.convertInventoryPOstoVOs(pos);
		String lotNum = inventoryData.getLotID();
		InventoryCheckVO checkVO = new InventoryCheckVO(VOs, lotNum);
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
		ArrayList<InventoryPO> inventorys = inventoryData.find();
		for (InventoryPO inventoryPO : inventorys) {
			if(inventoryPO.getTransferID().equals(transferID))
				return inventoryPO;
		}
		return null;
	}
	public ResultMessage saveImport(InventoryImportReceiptVO importReceipt) throws RemoteException{
    	return receiptInfo.add(importReceipt);
    }
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) throws RemoteException {
		importReceipt.receiptCondition=ReceiptCondition.SUBITTED;
		receiptInfo.modify(importReceipt);
		return ResultMessage.SUCCESS;
	}
    
	public String getExportID() throws RemoteException {
		String ID = receiptInfo.getExportID();
		return ID;
	}
	//生成出库单
	public InventoryExportReceiptVO minusCommodities(String ID, String ImportID, ExpressType Transfer) throws RemoteException {
		InventoryImportReceiptPO importPo = receiptInfo.findImport(ImportID);
		int area = importPo.getArea();
		int row= importPo.getRow();
		int frame = importPo.getFrame();
		int position = importPo.getPosition();
		ArrayList<InventoryPO> pos = inventoryData.find();
		InventoryPO inventorypoFind = null;
		for (InventoryPO inventoryPO : pos) {
			if(isValid(inventoryPO,area,row,frame,position)){
				inventorypoFind=inventoryPO;
				break;
			}
		}
		String depture = importPo.getDepture();
		String TransferID = receiptInfo.getTransferID();
		String destination = importPo.getDestination();
		String Commodities = importPo.getCommoditiesID();
		InventoryExportReceiptPO po = new InventoryExportReceiptPO(ID, ReceiptType.OUTSTOCK, destination, depture,
				Transfer, TransferID, Commodities, area,row,frame,position);
		InventoryExportReceiptVO voExport=InventoryTrans.convertPOtoVO(po);
//		inventorypoFind.setEmptyOrFull("empty");
		//TODO
		inventoryData.modify(inventorypoFind);
		return voExport;
	}
	 public ResultMessage saveExport(InventoryExportReceiptVO exportReceipt) throws RemoteException{
	    	return receiptInfo.add(exportReceipt);
	    }
	 
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) throws RemoteException {
		exportReceipt.receiptCondition=ReceiptCondition.SUBITTED;
		receiptInfo.modify(exportReceipt);
		return ResultMessage.SUCCESS;
	}

	public String getAdjustID() throws RemoteException {
		String ID = receiptInfo.getImportID();
		return ID;
	}

	public ResultMessage adjust(String ID, InventoryVO before, InventoryVO now) throws RemoteException {
		//TODO
		/*		int exArea = before.area;
		int exRow = before.row;
		int exFrame = before.frame;
		int exPosition = before.position;
		int afArea = now.area;
		int afRow = now.row;
		int afFrame = now.frame;
		int afPosition = now.position;
		AdjustReceiptVO vo = new AdjustReceiptVO(ID, ReceiptType.TAKINGSTOCK, exArea,exRow,exFrame,exPosition,afArea,afRow,afFrame,afPosition);
		InventoryPO beforePO = InventoryTrans.convertVOtoPO(before);
		InventoryPO afterPO = InventoryTrans.convertVOtoPO(now);
		//TODO
//		beforePO.setEmptyOrFull("empty");
//		afterPO.setEmptyOrFull("full");
		inventoryData.modify(beforePO);
		inventoryData.modify(afterPO);
		receiptInfo.add(vo);*/
		return ResultMessage.SUCCESS;
	}
	/*private ArrayList<InventoryVO> getInventoryPOsInDate(String begin,String end) throws RemoteException{
		ArrayList<InventoryPO> POs = inventoryData.find();
		ArrayList<InventoryVO> vos = new ArrayList<>();
		for (InventoryPO inventoryPO : POs) {
			if(inDate(inventoryPO, begin, end)){
				InventoryVO vo  = InventoryTrans.convertPOtoVO(inventoryPO);
				vos.add(vo);
			}
		}
		return vos;
	}*/
	/*private boolean inDate(InventoryPO po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}

	
	private boolean isValid(InventoryPO po,int area,int row,int frame,int position){
		if(po.getArea()==area&&po.getRow()==row&&po.getFrame()==frame&&po.getPosition()==position){
			return true;
		}
		return false;
	}*/
}


