package businesslogic.inventorybl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;

import businesslogicservice.inventoryblservice.InventoryBLService;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

public class InventoryController implements InventoryBLService {
    Inventory InventoryBL = new Inventory();
	@Override
	public InventoryViewVO viewInventory(String beginDate, String endDate)  {
		try {
			return InventoryBL.viewInventory(beginDate, endDate);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InventoryCheckVO checkRecord(String enddate){
		try {
			return InventoryBL.checkRecord(enddate);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getImportID()  {
		try {
			return InventoryBL.getImportID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addCommodities(String ID ,String ArrivalListID, InventoryVO vo)  {
		try {
			return InventoryBL.addCommodities( ID ,ArrivalListID, vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		return InventoryBL.submitImport(importReceipt);
	}

	@Override
	public String getExportID() {
		try {
			return InventoryBL.getExportID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage minusCommodities(String ID ,String ImportID, String Transfer) {
		try {
			return InventoryBL.minusCommodities( ID ,ImportID, Transfer);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		return InventoryBL.submitExport(exportReceipt);
	}

	@Override
	public String getAdjustID()  {
		try {
			return InventoryBL.getAdjustID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage adjust(String ID ,InventoryVO before, InventoryVO now) {
		try {
			return InventoryBL.adjust(ID ,before, now);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
