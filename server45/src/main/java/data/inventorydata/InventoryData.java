package data.inventorydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.inventorydataservice.InventoryDataService;
import po.InventoryPO;
import util.SerSaveAndLoad;

public class InventoryData extends ManageData<InventoryPO> implements InventoryDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public InventoryData() throws RemoteException {
		poList = new SerSaveAndLoad<InventoryPO>("data/" + NAME + ".ser");
	}

	@Override
	public void init() throws RemoteException {
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

}
