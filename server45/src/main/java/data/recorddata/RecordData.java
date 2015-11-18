package data.recorddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.recorddataservice.RecordDataService;
import po.BussinessConditionPO;
import po.BussinessProcessPO;

public class RecordData extends Data implements RecordDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordData() throws RemoteException {
		// TODO Auto-generated constructor stub
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
