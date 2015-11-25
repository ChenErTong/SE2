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
		// TODO Auto-generated method stub
		try {
			return InventoryBL.viewInventory(beginDate, endDate);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InventoryCheckVO checkRecord(String enddate){
		// TODO Auto-generated method stub
		try {
			return InventoryBL.checkRecord(enddate);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getImportID()  {
		// TODO Auto-generated method stub
		try {
			return InventoryBL.getImportID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addCommodities(String ArrivalListID, InventoryVO vo)  {
		// TODO Auto-generated method stub
		try {
			return InventoryBL.addCommodities(ArrivalListID, vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		// TODO Auto-generated method stub
		return InventoryBL.submitImport(importReceipt);
	}

	@Override
	public String getExportID() {
		// TODO Auto-generated method stub
		try {
			return InventoryBL.getExportID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage minusCommodities(String ImportID, String Transfer) {
		// TODO Auto-generated method stub
		try {
			return InventoryBL.minusCommodities(ImportID, Transfer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		// TODO Auto-generated method stub
		return InventoryBL.submitExport(exportReceipt);
	}

	@Override
	public String getAdjustID()  {
		// TODO Auto-generated method stub
		try {
			return InventoryBL.getAdjustID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage adjust(InventoryVO before, InventoryVO now) {
		// TODO Auto-generated method stub
		try {
			return InventoryBL.adjust(before, now);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
