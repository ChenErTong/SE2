package data.recorddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import config.XMLReader;
import data.ManageData;
import dataservice.recorddataservice.BusinessConditionDataService;
import po.BussinessConditionPO;
import po.PersistentObject;
import util.SerSaveAndLoad;

public class BusinessConditionData extends ManageData<BussinessConditionPO> implements BusinessConditionDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessConditionData() throws RemoteException {
	}

	@Override
	public void initialFile() throws RemoteException {
		poList=new SerSaveAndLoad<BussinessConditionPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
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

}
