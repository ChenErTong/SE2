package data.receiptdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.receiptdataservice.ReceiptDataService;
import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.TransferArrivalListPO;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import util.SerSaveAndLoad;
import util.Util;

public class ReceiptData extends ManageData<ReceiptPO> implements ReceiptDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public ReceiptData() throws RemoteException {
		poList=new SerSaveAndLoad<ReceiptPO>("data/"+NAME+".ser");
	}
	
	@Override
	public String getID() {
		int newID = poList.size();
		return Util.transIntToString(newID, 5);
	}

	@Override
	public ArrayList<ReceiptPO> showReceipt(ReceiptState receiptState) throws RemoteException {
		ArrayList<ReceiptPO> bills = new ArrayList<>();
		for (ReceiptPO po: poList.getInList()) {
			if(po.getReceiptState()==receiptState)
				bills.add(po);
		}
		return bills;
	}

	@Override
	public TransferArrivalListPO findTransferArrivalList(String id) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			ReceiptPO po = poList.get(i);
			if (po.getReceiptType()==ReceiptType.TRANS_ARRIVAL&&po.getID().equals(id))
				return (TransferArrivalListPO) po;
		}
		return null;
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
	public InventoryImportReceiptPO findImport(String importID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryExportReceiptPO findExport(String exportID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdjustReceiptPO findAdjust(String adjustID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransferID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLotNum() throws RemoteException {
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
