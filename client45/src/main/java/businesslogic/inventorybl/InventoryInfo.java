package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.InventoryInfo_OpeningStock;
import dataservice.inventorydataservice.InventoryDataService;
import po.InventoryPO;

public class InventoryInfo implements InventoryInfo_OpeningStock{
	Inventory inventory;
	InventoryDataService inventoryData;
	public InventoryInfo() {
		inventory = new Inventory();
		inventoryData = inventory.getData();
	}
	@Override
	public ArrayList<InventoryPO> find() throws RemoteException {
		return inventoryData.find();
	}

}
