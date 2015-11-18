package data.inventorydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.inventorydataservice.InventoryDataService;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;

public class InventoryData extends Data implements InventoryDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryData() throws RemoteException {
		// TODO Auto-generated constructor stub
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

}
