package data.recorddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.recorddataservice.RecordDataService;
import po.BussinessConditionPO;
import po.BussinessProcessPO;
import po.PersistentObject;
import util.SerSaveAndLoad;

public class RecordData extends ManageData<PersistentObject> implements RecordDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RecordData() throws RemoteException {
		poList=new SerSaveAndLoad<PersistentObject>("data/"+NAME+".ser");
	}

	@Override
	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate, String enddate) throws RemoteException {
		ArrayList< BussinessProcessPO> pos = new ArrayList<>();
		for (int i = 0; i < poList.size(); i++) {
			PersistentObject po = poList.get(i);
			if (inDate(po, begindate, enddate)) {
				pos.add((BussinessProcessPO)po);
			}
		}
		return pos;
	}

	@Override
	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate) throws RemoteException {
		ArrayList< BussinessConditionPO> pos = new ArrayList<>();
		for (int i = 0; i < poList.size(); i++) {
			PersistentObject po = poList.get(i);
			if (po.getDate().compareTo(enddate) <= 0) {
				pos.add((BussinessConditionPO)po);
			}
		}
		return pos;
	}

	@Override
	public String getBegin() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean inDate(PersistentObject po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}

}
