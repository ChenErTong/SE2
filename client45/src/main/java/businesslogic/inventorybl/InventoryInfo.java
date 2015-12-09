package businesslogic.inventorybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.InventoryInfo_OpeningStock;
import businesslogic.organizationbl.InventoryInfo_Branch_Transfer;
import businesslogic.transferbl.InventoryInfo_Transfer;
import dataservice.inventorydataservice.InventoryDataService;
import po.InventoryPO;
import vo.InventoryVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:32
 */
public class InventoryInfo
		implements InventoryInfo_OpeningStock, InventoryInfo_Branch_Transfer, InventoryInfo_Transfer {
	Inventory inventory;
	InventoryDataService inventoryData;

	public InventoryInfo() throws MalformedURLException, RemoteException, NotBoundException {
		inventory = new Inventory();
		inventoryData = inventory.getData();
	}

	/**
	 * @see InventoryInfo_OpeningStock#find()
	 */
	public ArrayList<InventoryPO> find() throws RemoteException {
		return inventoryData.find();
	}

	/**
	 * @see InventoryInfo_Branch_Transfer#getInventoriesByTransferID(String)
	 */
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) throws RemoteException {
		ArrayList<InventoryPO> pos = inventoryData.find();
		ArrayList<InventoryVO> vos = new ArrayList<>();
		for (InventoryPO inventoryPO : pos) {
			if (inventoryPO.getTransferID().equals(transferID)) {
				InventoryVO vo = InventoryTrans.convertPOtoVO(inventoryPO);
				vos.add(vo);
			}
		}
		return null;
	}

	/**
	 * @see InventoryInfo_Transfer#getTransferInitialInventory(String)
	 */
	public InventoryVO getTransferInitialInventory(String transferID) throws RemoteException {
		InventoryVO vo = new InventoryVO(inventoryData.getID(), 4, 100, 100, 100, transferID);
		return vo;
	}

}
