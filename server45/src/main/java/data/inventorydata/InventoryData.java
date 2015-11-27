package data.inventorydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import config.XMLReader;
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
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
	}


	@Override
	public InventoryPO getInventoryPO(String id) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			InventoryPO po = poList.get(i);
			if (po.getID().equals(id)) {
				return po;
			}
		}
		return null;
	}

	@Override
	public InventoryPO getInventoryPO(int a, int b, int c, int d) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			InventoryPO po = poList.get(i);
			if (isValid(po,a,b,c,d)) {
				return po;
			}
		}
		return null;
	}
	
	private boolean isValid(InventoryPO po,int a,int b,int c,int d){
		if(po.getA()==a&&po.getB()==b&&po.getC()==c&&po.getD()==d){
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<InventoryPO> getInventoryPOList(String date) throws RemoteException {
		ArrayList< InventoryPO> inventories = new ArrayList<>();
		for (int i = 0; i < poList.size(); i++) {
			InventoryPO po = poList.get(i);
			if (po.getDate().compareTo(date)<0) {
				inventories.add(po);
			}
		}
		return inventories;
	}

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<InventoryPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
