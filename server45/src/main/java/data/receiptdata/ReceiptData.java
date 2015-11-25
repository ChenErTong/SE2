package data.receiptdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.receiptdataservice.ReceiptDataService;
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
		return (TransferArrivalListPO) super.find(id);
	}

	@Override
	public String getImportID() throws RemoteException {
		String prifix="IMPORT";
		int idNumber=0;
		for (int i = 0; i < poList.size(); i++) {
			ReceiptPO po = poList.get(i);
			if (po.getReceiptType()==ReceiptType.INSTOCK)
				++idNumber;
		}
		return prifix+Util.transIntToString(idNumber, 8);
	}

	@Override
	public String getExportID() throws RemoteException {
		String prifix="EXPORT";
		int idNumber=0;
		for (int i = 0; i < poList.size(); i++) {
			ReceiptPO po = poList.get(i);
			if (po.getReceiptType()==ReceiptType.OUTSTOCK)
				++idNumber;
		}
		return prifix+Util.transIntToString(idNumber, 8);
	}

	@Override
	public String getAdjustID() throws RemoteException {
		String prifix="ADJUST";
		int idNumber=0;
		for (int i = 0; i < poList.size(); i++) {
			ReceiptPO po = poList.get(i);
			if (po.getReceiptType()==ReceiptType.TAKINGSTOCK)
				++idNumber;
		}
		return prifix+Util.transIntToString(idNumber, 8);
	}

	@Override
	public String getInventoryID() throws RemoteException {
		//???
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryImportReceiptPO findImport(String importID) throws RemoteException {
		return (InventoryImportReceiptPO) super.find(importID);
	}
	

	@Override
	public InventoryExportReceiptPO findExport(String exportID) throws RemoteException {
		return (InventoryExportReceiptPO) super.find(exportID);
	}

	@Override
	public AdjustReceiptPO findAdjust(String adjustID) throws RemoteException {
		return (AdjustReceiptPO) super.find(adjustID);
	}

	@Override
	public String getTransferID() throws RemoteException {
		//???
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLotNum() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<InventoryImportReceiptPO> showImport(String enddate) throws RemoteException {
		ArrayList<InventoryImportReceiptPO> inventoryImportReceipts = new ArrayList<>();
		for (ReceiptPO po: poList.getInList()) {
			if(po.getReceiptType()==ReceiptType.INSTOCK&&po.getDate().compareTo(enddate)<=0)
				inventoryImportReceipts.add((InventoryImportReceiptPO)po);
		}
		return inventoryImportReceipts;
	}

	@Override
	public ArrayList<InventoryExportReceiptPO> showExport(String enddate) throws RemoteException {
		ArrayList<InventoryExportReceiptPO> inventoryExportReceipts = new ArrayList<>();
		for (ReceiptPO po: poList.getInList()) {
			if(po.getReceiptType()==ReceiptType.OUTSTOCK&&po.getDate().compareTo(enddate)<=0)
				inventoryExportReceipts.add((InventoryExportReceiptPO)po);
		}
		return inventoryExportReceipts;
	}

	@Override
	public ArrayList<AdjustReceiptPO> showAdjust(String enddate) throws RemoteException {
		ArrayList<AdjustReceiptPO> adjustReceipts = new ArrayList<>();
		for (ReceiptPO po: poList.getInList()) {
			if(po.getReceiptType()==ReceiptType.TAKINGSTOCK&&po.getDate().compareTo(enddate)<=0)
				adjustReceipts.add((AdjustReceiptPO)po);
		}
		return adjustReceipts;
	}

	@Override
	public ResultMessage insertImport(InventoryImportReceiptPO po) throws RemoteException {
		return super.add(po);
	}

	@Override
	public ResultMessage insertExport(InventoryExportReceiptPO po) throws RemoteException {
		return super.add(po);
	}

	@Override
	public ResultMessage insertAdjust(AdjustReceiptPO po) throws RemoteException {
		return super.add(po);
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

}
