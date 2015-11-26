package data.recorddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import config.XMLReader;
import data.ManageData;
import dataservice.recorddataservice.BusinessProcessDataService;
import po.BussinessProcessPO;
import po.PersistentObject;
import util.SerSaveAndLoad;

public class BusinessProcessData extends ManageData<BussinessProcessPO> implements BusinessProcessDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessProcessData() throws RemoteException {
	}

	@Override
	public void initialFile() throws RemoteException {
		poList=new SerSaveAndLoad<BussinessProcessPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
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
	
	private boolean inDate(PersistentObject po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}

}
