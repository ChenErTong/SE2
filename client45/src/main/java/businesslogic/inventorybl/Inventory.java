package businesslogic.inventorybl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.inventorydataservice.InventoryDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
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
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

public class Inventory {
	private InventoryDataService inventoryData;
	private ReceiptDataService receiptData;

	public Inventory() {
		try {
			inventoryData = (InventoryDataService) Naming.lookup(RMIConfig.PREFIX + InventoryDataService.NAME);
			receiptData = (ReceiptDataService) Naming.lookup(RMIConfig.PREFIX + ReceiptDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public InventoryViewVO viewInventory(String beginDate, String endDate) throws RemoteException {
		ArrayList<InventoryVO> VOs = this.getInventoryPOsInDate(beginDate,endDate);
		InventoryViewVO viewVO = new InventoryViewVO(receiptData.getimportNumber(beginDate, endDate),
				receiptData.getexportNumber(beginDate, endDate), receiptData.getNum(beginDate, endDate), VOs);
		return viewVO;
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

	public InventoryCheckVO checkRecord(String enddate) throws RemoteException {
		ArrayList<InventoryPO> pos = inventoryData.find();
		ArrayList<InventoryVO> VOs =InventoryTrans.convertInventoryPOstoVOs(pos);
		String lotNum = inventoryData.getLotID();
		InventoryCheckVO checkVO = new InventoryCheckVO(VOs, lotNum);
		return checkVO;
	}

	public String getImportID() throws RemoteException {
		String ID = receiptData.getImportID();
		return ID;
	}

	public InventoryImportReceiptVO addCommodities(String ID, String ArrivalListID, InventoryVO vo) throws RemoteException {
		TransferArrivalListPO receipt = receiptData.findTransferArrivalList(ArrivalListID);
		String commodities = receipt.getTransferCenterID();
		String destination = receipt.getDestination();
		String depture = receipt.getDeparture();
		int a = vo.a;
		int b = vo.b;
		int c = vo.c;
		int d = vo.d;
		InventoryPO inventorypo = new InventoryPO(inventoryData.getID(), a, b, c, d, "full");
		InventoryImportReceiptPO po = new InventoryImportReceiptPO(ID, ReceiptType.INSTOCK, destination, depture,
				commodities, a, b, c, d);
		InventoryImportReceiptVO voImport=InventoryTrans. convertPOtoVO(po);
		inventoryData.add(inventorypo);
		return voImport;

	}
    public ResultMessage saveImport(InventoryImportReceiptVO importReceipt) throws RemoteException{
    	InventoryImportReceiptPO po= InventoryTrans. convertVOtoPO( importReceipt);
    	return receiptData.insertImport(po);
    }
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) throws RemoteException {
		InventoryImportReceiptPO po= InventoryTrans. convertVOtoPO( importReceipt);
		po.setReceiptCondition(ReceiptCondition.SUBITTED);
		receiptData.modify(po);
		return ResultMessage.SUCCESS;
	}
    
	public String getExportID() throws RemoteException {
		String ID = receiptData.getExportID();
		return ID;
	}

	public InventoryExportReceiptVO minusCommodities(String ID, String ImportID, ExpressType Transfer) throws RemoteException {
		InventoryImportReceiptPO importPo = receiptData.findImport(ImportID);
		int a = importPo.getA();
		int b = importPo.getB();
		int c = importPo.getC();
		int d = importPo.getD();
		ArrayList<InventoryPO> pos = inventoryData.find();
		InventoryPO inventorypoFind = null;
		for (InventoryPO inventoryPO : pos) {
			if(isValid(inventoryPO, a, b, c, d)){
				inventorypoFind=inventoryPO;
				break;
			}
		}
		String depture = importPo.getDepture();
		String TransferID = receiptData.getTransferID();
		String destination = importPo.getDestination();
		String Commodities = importPo.getCommoditiesID();
		InventoryExportReceiptPO po = new InventoryExportReceiptPO(ID, ReceiptType.OUTSTOCK, destination, depture,
				Transfer, TransferID, Commodities, a, b, c, d);
		InventoryExportReceiptVO voExport=InventoryTrans.convertPOtoVO(po);
		inventorypoFind.setEmptyOrFull("empty");
		inventoryData.modify(inventorypoFind);
		return voExport;
	}
	 public ResultMessage saveExport(InventoryExportReceiptVO exportReceipt) throws RemoteException{
	    	InventoryExportReceiptPO po= InventoryTrans. convertVOtoPO( exportReceipt);
	    	return receiptData.insertExport(po);
	    }
	 
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) throws RemoteException {
		InventoryExportReceiptPO po= InventoryTrans.convertVOtoPO( exportReceipt);
		po.setReceiptCondition(ReceiptCondition.SUBITTED);
		receiptData.modify(po);
		return ResultMessage.SUCCESS;
	}

	public String getAdjustID() throws RemoteException {
		String ID = receiptData.getImportID();
		return ID;
	}

	public ResultMessage adjust(String ID, InventoryVO before, InventoryVO now) throws RemoteException {
		int exA = before.a;
		int exB = before.b;
		int exC = before.c;
		int exD = before.d;
		int afA = now.a;
		int afB = now.b;
		int afC = now.c;
		int afD = now.d;
		AdjustReceiptPO po = new AdjustReceiptPO(ID, ReceiptType.TAKINGSTOCK, exA, exB, exC, exD, afA, afB, afC, afD);
		InventoryPO beforePO = InventoryTrans.convertVOtoPO(before);
		InventoryPO afterPO = InventoryTrans.convertVOtoPO(now);
		beforePO.setEmptyOrFull("empty");
		afterPO.setEmptyOrFull("full");
		inventoryData.modify(beforePO);
		inventoryData.modify(afterPO);
		receiptData.insertAdjust(po);
		return ResultMessage.SUCCESS;
	}

	public void Init() throws RemoteException {
		inventoryData.initialFile();
	}
	
	private boolean isValid(InventoryPO po,int a,int b,int c,int d){
		if(po.getA()==a&&po.getB()==b&&po.getC()==c&&po.getD()==d){
			return true;
		}
		return false;
	}

}
