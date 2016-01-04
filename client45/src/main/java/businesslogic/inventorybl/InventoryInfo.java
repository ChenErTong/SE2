package businesslogic.inventorybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.InventoryInfo_OpeningStock;
import businesslogic.orderbl.OrderInfo;
import businesslogic.orderbl.OrderTrans;
import businesslogic.organizationbl.InventoryInfo_Branch_Transfer;
import businesslogic.organizationbl.transferbl.InventoryInfo_Transfer;
import businesslogic.organizationbl.transferbl.TransferInfo;
import businesslogic.receiptbl.InventoryInfo_Receipt;
import dataservice.inventorydataservice.InventoryDataService;
import po.CommodityPO;
import po.InventoryPO;
import po.TransferPO;
import vo.CommodityVO;
import vo.InventoryVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:32
 */
public class InventoryInfo
		implements InventoryInfo_OpeningStock, InventoryInfo_Branch_Transfer, InventoryInfo_Transfer,InventoryInfo_Receipt {
	Inventory inventory;
	InventoryDataService inventoryData;
	OrderInfo orderInfo;
	TransferInfo transferInfo;

	public InventoryInfo() throws MalformedURLException, RemoteException, NotBoundException {
		inventory = new Inventory();
		inventoryData = inventory.getData();
		orderInfo = new OrderInfo();
		transferInfo=new TransferInfo();
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
		InventoryVO vo = new InventoryVO(inventoryData.getID(), 4, 10, 10, 10, transferID);
		return vo;
	}
	
	public void inventoryImport(String transferID, CommodityVO commodity, int area, int row, int frame, int position)
			throws RemoteException {
		// 修改仓库信息
		CommodityPO commodityPO = OrderTrans.convertVOtoPO(commodity);
		// 通过中转中心的id获取inventoryPO
		InventoryPO inventoryPO = inventory.findInventoryByTransferID(transferID);
		// 修改库存
		CommodityPO[][][][] commos = inventoryPO.getCommos();
		commos[area][row][frame][position] = commodityPO;
		inventoryPO.setCommos(commos);
		String orderID = commodityPO.getOrderID();
		orderInfo.changeCommodityStateInOrder(orderID, true);
		updateTransferInventory(transferID, inventoryPO);
	}
	
	public void inventoryExport(String transferID, int area, int row, int frame, int position)
			throws RemoteException {
		// 通过中转中心的id获取inventoryPO
		InventoryPO inventoryPO = inventory.findInventoryByTransferID(transferID);
		// 修改库存
		CommodityPO[][][][] commos = inventoryPO.getCommos();
		CommodityPO commodityPO = commos[area][row][frame][position];
		commos[area][row][frame][position] = null;
		String orderID = commodityPO.getOrderID();
		orderInfo.changeCommodityStateInOrder(orderID, false);
		inventoryPO.setCommos(commos);
		inventoryData.modify(inventoryPO);
		updateTransferInventory(transferID, inventoryPO);
	}

	private void updateTransferInventory(String transferID, InventoryPO inventoryPO) throws RemoteException {
		TransferPO transferPO = transferInfo.getTransfer(transferID);
		ArrayList<InventoryPO> inventories = new ArrayList<>();
		inventories.add(inventoryPO);
		transferPO.setInventories(inventories);
		transferInfo.modify(transferPO);
	}

}
