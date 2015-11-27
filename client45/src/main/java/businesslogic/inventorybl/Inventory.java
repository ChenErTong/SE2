package businesslogic.inventorybl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.inventorydataservice.InventoryDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
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
		ArrayList<InventoryPO> POs = inventoryData.getInventoryPOList(endDate);
		ArrayList<InventoryVO> VOs = InventoryTrans.convertInventoryPOstoVOs(POs);
		InventoryViewVO viewVO = new InventoryViewVO(receiptData.getimportNumber(beginDate, endDate),
				receiptData.getexportNumber(beginDate, endDate), receiptData.getNum(beginDate, endDate), VOs);
		return viewVO;
	}

	public InventoryCheckVO checkRecord(String enddate) throws RemoteException {
		ArrayList<InventoryImportReceiptPO> POs = receiptData.showImport(enddate);
		ArrayList<InventoryImportReceiptVO> VOs = InventoryTrans.convertInventoryImportReceiptPOstoVOs(POs);
		String lotNum = inventoryData.getLotNum();
		InventoryCheckVO checkVO = new InventoryCheckVO(VOs, lotNum);
		return checkVO;
	}

	public String getImportID() throws RemoteException {
		String ID = receiptData.getImportID();
		return ID;
	}

	public ResultMessage addCommodities(String ID, String ArrivalListID, InventoryVO vo) throws RemoteException {

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
		receiptData.insertImport(po);
		inventoryData.add(inventorypo);
		return inventoryData.add(inventorypo);

	}

	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		return ResultMessage.SUCCESS;
	}

	public String getExportID() throws RemoteException {
		String ID = receiptData.getExportID();
		return ID;
	}

	public ResultMessage minusCommodities(String ID, String ImportID, String Transfer) throws RemoteException {
		InventoryImportReceiptPO importPo = receiptData.findImport(ImportID);
		int a = importPo.getA();
		int b = importPo.getB();
		int c = importPo.getC();
		int d = importPo.getD();
		InventoryPO inventorypo = inventoryData.getInventoryPO(a, b, c, d);
		String depture = importPo.getDepture();
		String TransferID = receiptData.getTransferID();
		String destination = importPo.getDestination();
		String Commodities = importPo.getCommoditiesID();
		InventoryExportReceiptPO po = new InventoryExportReceiptPO(ID, ReceiptType.OUTSTOCK, destination, depture,
				Transfer, TransferID, Commodities, a, b, c, d);
		receiptData.insertExport(po);
		inventorypo.setEmptyOrFull("empty");
		inventoryData.modify(inventorypo);
		return receiptData.insertExport(po);
	}

	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		// TODO 提交
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

}
