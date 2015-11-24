package data.inventorydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.inventorydataservice.InventoryDataService;
import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class InventoryData extends ManageData<InventoryPO> implements InventoryDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public InventoryData() throws RemoteException {
		poList=new SerSaveAndLoad<InventoryPO>("data/"+NAME+".ser");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getImportID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExportID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAdjustID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
	public ResultMessage insertImport(InventoryImportReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertExport(InventoryExportReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertAdjust(AdjustReceiptPO po) throws RemoteException {
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

	
}
