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

	@Override
	public String getAdjustID() {
		System.out.println("Succeed in getting the adjusting receipt id.");
		return "0123456789";
	}


	
	@Override
	public ArrayList<InventoryImportReceiptPO> showImport(String enddate){
		ArrayList<InventoryImportReceiptPO> iirPOs = new ArrayList<InventoryImportReceiptPO>();
		InventoryImportReceiptPO iirPO = new InventoryImportReceiptPO("0123456789",null, "Shanghai","nanjing","0123456789",1,1,1,1);
		iirPOs.add(iirPO);
		System.out.println("Succeed in showing the import receipts.");
		return iirPOs;
	}

	@Override
	public ArrayList<InventoryExportReceiptPO> showExport(String enddate) {
		ArrayList<InventoryExportReceiptPO> ierPOs = new ArrayList<InventoryExportReceiptPO>();
		InventoryExportReceiptPO ierPO = new InventoryExportReceiptPO("1234567890",null, "Nanjing","shanghai","plane","0123456789","0123456789", 1, 1, 1, 1);
		ierPOs.add(ierPO);
		System.out.println("Succeed in showing the export receipts.");
		return ierPOs;
	}

	@Override
	public ArrayList<AdjustReceiptPO> showAdjust(String enddate) {
		ArrayList<AdjustReceiptPO> arPOs = new ArrayList<AdjustReceiptPO>();
		AdjustReceiptPO arPO = new AdjustReceiptPO("1234567890", null, 1, 1, 1, 1, 2, 2, 2, 2);
		arPOs.add(arPO);
		System.out.println("Succeed in showing the adjusting receipts.");
		return arPOs;
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
	public String getTransferID() throws RemoteException {
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
	public ArrayList<InventoryPO> getInventoryPOList(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}