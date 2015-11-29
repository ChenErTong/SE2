package data.receiptdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import config.XMLReader;
import data.ManageData;
import dataservice.receiptdataservice.ReceiptDataService;
import po.PersistentObject;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class ReceiptData extends ManageData<ReceiptPO> implements ReceiptDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String importPrifix ;
	String exportPrifix ;
	String adjustPrifix ;
	String transferArrialPrifix;
	// poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public ReceiptData() throws RemoteException {
		importPrifix=configReader.getValue("importPrifix");
		exportPrifix=configReader.getValue("exportPrifix");
		adjustPrifix=configReader.getValue("adjustPrifix");
		transferArrialPrifix=configReader.getValue("transferArrialPrifix");
	}

	//TODO
	@Override
	public ArrayList<ReceiptPO> showReceipt(ReceiptState receiptState) throws RemoteException {
		ArrayList<ReceiptPO> bills = new ArrayList<>();
		for (ReceiptPO po : poList.getInList()) {
			if (po.getReceiptState() == receiptState)
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
		return importPrifix +super.getID();
	}

	@Override
	public String getExportID() throws RemoteException {
		return exportPrifix +super.getID();
	}

	@Override
	public String getAdjustID() throws RemoteException {
		return adjustPrifix +super.getID();
	}
	
	@Override
	public String getTransferID() throws RemoteException {
		return transferArrialPrifix +super.getID();
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

	
	
	//TODO
	@Override
	public ArrayList<InventoryImportReceiptPO> showImport(String enddate) throws RemoteException {
		ArrayList<InventoryImportReceiptPO> inventoryImportReceipts = new ArrayList<>();
		for (ReceiptPO po : poList.getInList()) {
			if (po.getReceiptType() == ReceiptType.INSTOCK && po.getDate().compareTo(enddate) <= 0)
				inventoryImportReceipts.add((InventoryImportReceiptPO) po);
		}
		return inventoryImportReceipts;
	}
	//TODO
	@Override
	public ArrayList<InventoryExportReceiptPO> showExport(String enddate) throws RemoteException {
		ArrayList<InventoryExportReceiptPO> inventoryExportReceipts = new ArrayList<>();
		for (ReceiptPO po : poList.getInList()) {
			if (po.getReceiptType() == ReceiptType.OUTSTOCK && po.getDate().compareTo(enddate) <= 0)
				inventoryExportReceipts.add((InventoryExportReceiptPO) po);
		}
		return inventoryExportReceipts;
	}
	//TODO
	@Override
	public ArrayList<AdjustReceiptPO> showAdjust(String enddate) throws RemoteException {
		ArrayList<AdjustReceiptPO> adjustReceipts = new ArrayList<>();
		for (ReceiptPO po : poList.getInList()) {
			if (po.getReceiptType() == ReceiptType.TAKINGSTOCK && po.getDate().compareTo(enddate) <= 0)
				adjustReceipts.add((AdjustReceiptPO) po);
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
	//TODO
	@Override
	public int getexportNumber(String beginDate, String endDate) throws RemoteException {
		int size = 0;
		for (int i = 0; i < poList.size(); i++) {
			ReceiptPO po = poList.get(i);
			if (po.getReceiptType() == ReceiptType.OUTSTOCK && inDate(po, beginDate, endDate))
				++size;
		}
		return size;
	}

	//TODO
	@Override
	public int getimportNumber(String beginDate, String endDate) throws RemoteException {
		int size = 0;
		for (int i = 0; i < poList.size(); i++) {
			ReceiptPO po = poList.get(i);
			if (po.getReceiptType() == ReceiptType.INSTOCK && inDate(po, beginDate, endDate))
				++size;
		}
		return size;
	}
	//TODO
	@Override
	public int getNum(String beginDate, String endDate) throws RemoteException {
		int size = 0;
		for (int i = 0; i < poList.size(); i++) {
			ReceiptPO po = poList.get(i);
			if ((po.getReceiptType() == ReceiptType.INSTOCK || po.getReceiptType() == ReceiptType.OUTSTOCK)
					&& inDate(po, beginDate, endDate))
				++size;
		}
		return size;
	}
	
	private boolean inDate(PersistentObject po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<ReceiptPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
