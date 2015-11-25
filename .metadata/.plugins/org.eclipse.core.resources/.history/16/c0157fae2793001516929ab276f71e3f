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
import po.receiptpo.TransferArrivalListPO;
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
		InventoryViewVO viewVO = new InventoryViewVO(inventoryData.getimportNumber(beginDate, endDate),
				inventoryData.getexportNumber(beginDate, endDate), inventoryData.getNum(beginDate, endDate), VOs);
		return viewVO;
	}

	public InventoryCheckVO checkRecord(String enddate) throws RemoteException {
		ArrayList<InventoryImportReceiptPO> POs = inventoryData.showImport(enddate);
		ArrayList<InventoryImportReceiptVO> VOs = InventoryTrans.convertInventoryImportReceiptPOstoVOs(POs);
		// 记得补充一个生成方法
		String lotNum = null;
		InventoryCheckVO checkVO = new InventoryCheckVO(VOs, lotNum);
		return checkVO;
	}

	public String getImportID() throws RemoteException {
		// TODO Auto-generated method stub
		String ID = inventoryData.getImportID();
		return ID;
	}

	public ResultMessage addCommodities(String ArrivalListID, InventoryVO vo) throws RemoteException {
		
		TransferArrivalListPO receipt =receiptData.findTransferArrivalList(ArrivalListID);
		String ID = inventoryData.getImportID();
		String commodities = receipt.getTransferCenterID();
		String destination = receipt.getDestination();
		String depture = receipt.getDeparture();
		int a = vo.getA();
		int b = vo.getB();
		int c = vo.getC();
		int d = vo.getD();
		InventoryPO inventorypo = new InventoryPO(inventoryData.getInventoryID(), a, b, c, d, "full");
		InventoryImportReceiptPO po = new InventoryImportReceiptPO(ID, ReceiptType.INSTOCK, destination, depture,
				commodities, a, b, c, d);
		inventoryData.insertImport(po);
		inventoryData.insertInventory(inventorypo);
		return inventoryData.insertInventory(inventorypo);

	}

	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public String getExportID() throws RemoteException {
		String ID = inventoryData.getExportID();
		return ID;
	}

	public ResultMessage minusCommodities(String ImportID, String Transfer) throws RemoteException {
		InventoryImportReceiptPO importPo = inventoryData.findImport(ImportID);
		int a = importPo.getA();
		int b = importPo.getB();
		int c = importPo.getC();
		int d = importPo.getD();
		InventoryPO inventorypo = inventoryData.getInventoryPO(a, b, c, d);
		String ID = inventoryData.getExportID();
		String depture = importPo.getDepture();
		String TransferID = inventoryData.getTransferID();
		String destination = importPo.getDestination();
		String Commodities = importPo.getCommoditiesID();
		InventoryExportReceiptPO po = new InventoryExportReceiptPO(ID, ReceiptType.OUTSTOCK, destination, depture,
				Transfer, TransferID, Commodities, a, b, c, d);
		inventoryData.insertExport(po);
		inventoryData.modifyInventory(inventorypo, a, b, c, d, "empty");
		return inventoryData.insertExport(po);
	}

	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public String getAdjustID() throws RemoteException {
		String ID = inventoryData.getImportID();
		return ID;
	}

	public ResultMessage adjust(InventoryVO before, InventoryVO now) throws RemoteException {
		int exA = before.getA();
		int exB = before.getB();
		int exC = before.getC();
		int exD = before.getD();
		int afA = now.getA();
		int afB = now.getB();
		int afC = now.getC();
		int afD = now.getD();
		String ID = inventoryData.getImportID();
		AdjustReceiptPO po = new AdjustReceiptPO(ID, ReceiptType.TAKINGSTOCK, exA, exB, exC, exD, afA, afB, afC, afD);
		InventoryPO beforePO = InventoryTrans.convertVOtoPO(before);
		InventoryPO afterPO = InventoryTrans.convertVOtoPO(now);
		inventoryData.modifyInventory(beforePO, exA, exB, exC, exD, "empty");
		inventoryData.modifyInventory(afterPO, afA, afB, afC, afD, "full");
		inventoryData.insertAdjust(po);

		return ResultMessage.SUCCESS;

	}

}
