package businesslogicservice.inventoryblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.inventorydataservice.InventoryDataService;
import dataservice.inventorydataservice._Inventory_Data_Stub;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

public class _Inventory_Stub implements InventoryBLService{
	InventoryDataService data_stub = new _Inventory_Data_Stub();
	@Override
	public InventoryViewVO viewInventory(String beginDate, String endDate) {
		InventoryViewVO ivVO = null;
		
		System.out.println("Succeed in showing the condition of the inventory!");
		return ivVO;
	}

	@Override
	public InventoryCheckVO checkRecord(String enddate) {
		InventoryImportReceiptVO iirVO = new InventoryImportReceiptVO("1234567890", null, "Nanjing", 1, 1, 1, 1);
		ArrayList<InventoryImportReceiptVO> iirVOs = new ArrayList<InventoryImportReceiptVO>();
		iirVOs.add(iirVO);
		InventoryCheckVO icVO = new InventoryCheckVO(null, null);
		System.out.println("Succeed in showing the shortcut of the inventory!");
		return icVO;
	}

	@Override
	public String getImportID() {
		System.out.println("Succeed in getting the import receipt id!");
		try {
			return data_stub.getImportID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public String getExportID() {
		System.out.println("Succeed in getting the export receipt id!");
		try {
			return data_stub.getExportID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		System.out.println("Succeed in submitting the export receipt to the top manager!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getAdjustID() {
		System.out.println("Succeed in getting the adjusting receipt id!");
		try {
			return data_stub.getAdjustID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ResultMessage adjust(InventoryVO before, InventoryVO now) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addCommodities(String ArrivalListID, InventoryVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage minusCommodities(String ImportID, String Transfer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}

	