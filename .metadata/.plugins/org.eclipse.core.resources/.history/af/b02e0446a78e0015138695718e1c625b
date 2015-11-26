package businesslogicservice.inventoryblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.inventorydataservice.InventoryDataService;
import dataservice.inventorydataservice._Inventory_Data_Stub;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.TransferArrivalListVO;

public class _Inventory_Stub implements InventoryBLService{
	InventoryDataService data_stub = new _Inventory_Data_Stub();
	@Override
	public InventoryViewVO viewInventory(String beginDate, String endDate) {
		InventoryViewVO ivVO = null;
		try {
			ivVO = new InventoryViewVO(data_stub.showExport().size(), data_stub.showImport().size(), data_stub.getANum());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println("Succeed in showing the condition of the inventory!");
		return ivVO;
	}

	@Override
	public InventoryCheckVO checkRecord() {
		InventoryImportReceiptVO iirVO = new InventoryImportReceiptVO("1234567890", "Nanjing", 1, 1, 1, 1);
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
	public ResultMessage addCommodities(TransferArrivalListVO receipt) {
		System.out.println("Succeed in adding the commodities to the import receipt!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public InventoryImportReceiptPO buildImport() {
		InventoryImportReceiptPO iirPO = new InventoryImportReceiptPO("0123456789","Shanghai","0123456789",1,1,1,1);
		System.out.println("Succeed in producing the import receipt!");
		return iirPO;
	}

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		System.out.println("Succeed in submitting the import receipt to the top manager!");
		return ResultMessage.SUCCESS;
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
	public ResultMessage minusCommodities(TransferArrivalListVO receipt) {
		System.out.println("Succeed in adding the commodities to the export receipt!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public InventoryExportReceiptPO buildExport() {
		InventoryExportReceiptPO ierPO = new InventoryExportReceiptPO("1234567890","Nanjing","plane","0123456789","0123456789", 1, 1, 1, 1);
		System.out.println("Succeed in producing the export receipt!");
		return ierPO;
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
	public AdjustReceiptPO adjust() {
		AdjustReceiptPO arPO = null;
		try {
			arPO = data_stub.showAdjust().get(0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println("Succeed in producing the adjusting receipt!");
		return arPO;
	}
}