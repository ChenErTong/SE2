package data.recorddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.recorddataservice.RecordDataService;
import po.BussinessConditionPO;
import po.BussinessProcessPO;
import po.receiptpo.ReceiptPO;
import util.SerSaveAndLoad;

public class RecordData extends ManageData implements RecordDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public RecordData() throws RemoteException {
		poList=new SerSaveAndLoad<BussinessProcessPO>("data/"+NAME+".ser");
	}

	@Override
	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate, String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
