package dataservice.inventorydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;

public class _Inventory_Data_Stub implements InventoryDataService{

	@Override
	public void init() {
		System.out.println("Succeed in initing the inventory data.");
	}

	@Override
	public String getImportID() {
		System.out.println("Succeed in getting the import receipt id.");
		return "0123456789";
	}

	@Override
	public String getExportID() {
		System.out.println("Succeed in getting the export receipt id.");
		return "0123456789";
	}


	public String getAdjustID() {
		System.out.println("Succeed in getting the adjusting receipt id.");
		return "0123456789";
	}


	

	
	@Override
	public ResultMessage insertImport(InventoryImportReceiptPO po) {
		System.out.println("Succeed in inserting the import receipts.");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertExport(InventoryExportReceiptPO po) {
		System.out.println("Succeed in inserting the export receipts.");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertAdjust(AdjustReceiptPO po) {
		System.out.println("Succeed in inserting the adjusting receipts.");
		return ResultMessage.SUCCESS;
	}

	
	@Override
	public String getInventoryID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryImportReceiptPO findImport(String importID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryExportReceiptPO findExport(String exportID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdjustReceiptPO findAdjust(String adjustID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransferID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryPO getInventoryPO(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryPO getInventoryPO(int a, int b, int c, int d) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryPO> getInventoryPOList(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryImportReceiptPO> showImport(String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryExportReceiptPO> showExport(String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AdjustReceiptPO> showAdjust(String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getexportNumber(String beginDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getimportNumber(String beginDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNum(String beginDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage insertInventory(InventoryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyInventory(InventoryPO po, int a, int b, int c, int d, String EmptyOrFull)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}