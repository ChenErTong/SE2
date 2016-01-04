package businesslogic.receiptbl;

import java.rmi.RemoteException;

import vo.CommodityVO;

public interface InventoryInfo_Receipt {
	public void inventoryExport(String transferID, int area, int row, int frame, int position) throws RemoteException;

	public void inventoryImport(String transferID, CommodityVO commodity, int area, int row, int frame, int position)
			throws RemoteException;
}
