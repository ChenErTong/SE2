package data.inventorydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.inventorydataservice.InventoryDataService;
import po.PersistentObject;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class InventoryData extends ManageData<PersistentObject> implements InventoryDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public InventoryData() throws RemoteException {
		poList=new SerSaveAndLoad<PersistentObject>("data/"+NAME+".ser");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getImportID()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExportID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlarmID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getA() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getB() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getC()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getD()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getASize() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBSize() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCSize() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDSize() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getANum() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBNum() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCNum() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDNum() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryImportReceiptPO> showImport() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryExportReceiptPO> showExport() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AdjustReceiptPO> showAdjust() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
	public int getImportNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getExportNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
