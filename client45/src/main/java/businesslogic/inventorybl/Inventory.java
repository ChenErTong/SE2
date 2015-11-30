package businesslogic.inventorybl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.inventorydataservice.InventoryDataService;
import po.InventoryPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import state.ExpressType;
import state.ReceiptCondition;
import state.ReceiptType;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
//TODO 要发生较大改动！！！！！！！
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

	public InventoryViewVO viewInventory(String beginDate, String endDate) throws RemoteException {
		ArrayList<InventoryVO> VOs = this.getInventoryPOsInDate(beginDate,endDate);
		//获得receiptInfo
		ReceiptInfo_Inventory receiptInfo = new ReceiptInfo();
		//通过receiptInfo得到一段时间内入库单和出库单的数量
		int importNumber=receiptInfo.getImportNumber(beginDate, endDate);
		int exportNumber = receiptInfo.getExportNumber(beginDate, endDate);
		int sum = importNumber+exportNumber;
		//新建库存查看VO
		InventoryViewVO viewVO = new InventoryViewVO(importNumber,exportNumber,sum, VOs);
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

	public InventoryImportReceiptVO addCommodities(String ID, String ArrivalListID, InventoryVO vo) throws RemoteException {
		TransferArrivalListPO receipt = receiptInfo.findTransferArrivalList(ArrivalListID);
		String commodities = receipt.getTransferCenterID();
		String destination = receipt.getDestination();
		String depture = receipt.getDeparture();
		int area = vo.area;
		int row = vo.row;
		int frame = vo.frame;
		int position = vo.position;
		InventoryPO inventorypo = new InventoryPO(inventoryData.getID(),area,row,frame,position, "full");
		InventoryImportReceiptPO po = new InventoryImportReceiptPO(ID, ReceiptType.INSTOCK, destination, depture,
				commodities,area,row,frame,position);
		InventoryImportReceiptVO voImport=InventoryTrans. convertPOtoVO(po);
		inventoryData.add(inventorypo);
		return voImport;

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
		inventorypoFind.setEmptyOrFull("empty");
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
		int exArea = before.area;
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
		beforePO.setEmptyOrFull("empty");
		afterPO.setEmptyOrFull("full");
		inventoryData.modify(beforePO);
		inventoryData.modify(afterPO);
		receiptInfo.add(vo);
		return ResultMessage.SUCCESS;
	}
	private ArrayList<InventoryVO> getInventoryPOsInDate(String begin,String end) throws RemoteException{
		ArrayList<InventoryPO> POs = inventoryData.find();
		ArrayList<InventoryVO> vos = new ArrayList<>();
		for (InventoryPO inventoryPO : POs) {
			if(inDate(inventoryPO, begin, end)){
				InventoryVO vo  = InventoryTrans.convertPOtoVO(inventoryPO);
				vos.add(vo);
			}
		}
		return vos;
	}
	private boolean inDate(InventoryPO po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}

	
	private boolean isValid(InventoryPO po,int area,int row,int frame,int position){
		if(po.getArea()==area&&po.getRow()==row&&po.getFrame()==frame&&po.getPosition()==position){
			return true;
		}
		return false;
	}
}


