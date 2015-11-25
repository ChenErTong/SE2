package data.recorddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import data.ManageData;
import dataservice.recorddataservice.RecordDataService;
import po.BussinessConditionPO;
import po.BussinessProcessPO;
import po.OrderPO;
import po.PersistentObject;
import po.receiptpo.DebitAndPayBillPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import state.ReceiptType;
import util.SerSaveAndLoad;

public class RecordData extends ManageData<PersistentObject>implements RecordDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RecordData() throws RemoteException {
			poList=new SerSaveAndLoad<PersistentObject>("data/"+NAME+".ser");
	}

	
	
	
	
	
	@Override
	public String getBegin() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
