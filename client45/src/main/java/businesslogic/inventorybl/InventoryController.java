package businesslogic.inventorybl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;

import businesslogicservice.inventoryblservice.InventoryBLService;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

public class InventoryController implements InventoryBLService {
    Inventory InventoryBL;
	@Override
	public InventoryViewVO viewInventory(String beginDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return InventoryBL.viewInventory(beginDate, endDate);
	}

	@Override
	public InventoryCheckVO checkRecord(String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return InventoryBL.checkRecord(enddate);
	}

	@Override
	public String getImportID() throws RemoteException {
		// TODO Auto-generated method stub
		return InventoryBL.getImportID();
	}

	@Override
	public ResultMessage addCommodities(String ArrivalListID, InventoryVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return InventoryBL.addCommodities(ArrivalListID, vo);
	}

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		// TODO Auto-generated method stub
		return InventoryBL.submitImport(importReceipt);
	}

	@Override
	public String getExportID() throws RemoteException {
		// TODO Auto-generated method stub
		return InventoryBL.getExportID();
	}

	@Override
	public ResultMessage minusCommodities(String ImportID, String Transfer) throws RemoteException {
		// TODO Auto-generated method stub
		return InventoryBL.minusCommodities(ImportID, Transfer);
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		// TODO Auto-generated method stub
		return InventoryBL.submitExport(exportReceipt);
	}

	@Override
	public String getAdjustID() throws RemoteException {
		// TODO Auto-generated method stub
		return InventoryBL.getAdjustID();
	}

	@Override
	public ResultMessage adjust(InventoryVO before, InventoryVO now) throws RemoteException {
		// TODO Auto-generated method stub
		return InventoryBL.adjust(before, now);
	}

}