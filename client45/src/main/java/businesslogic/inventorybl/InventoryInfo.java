package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.InventoryInfo_OpeningStock;
import businesslogic.organizationbl.InventoryInfo_Branch_Transfer;
import dataservice.inventorydataservice.InventoryDataService;
import po.InventoryPO;
import vo.InventoryVO;

public class InventoryInfo implements InventoryInfo_OpeningStock,InventoryInfo_Branch_Transfer{
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
	@Override
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) throws RemoteException {
		ArrayList<InventoryPO> pos = inventoryData.find();
		ArrayList<InventoryVO> vos = new ArrayList<>();
		for (InventoryPO inventoryPO : pos) {
			if(inventoryPO.getTransferID().equals(transferID)){
				InventoryVO vo = InventoryTrans.convertPOtoVO(inventoryPO);
				vos.add(vo);
			}
		}
		return null;
	}

}
