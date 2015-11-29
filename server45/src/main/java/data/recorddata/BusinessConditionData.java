package data.recorddata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.recorddataservice.BusinessConditionDataService;
import po.BussinessConditionPO;
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
		poList = new SerSaveAndLoad<BussinessConditionPO>("data/" + NAME + ".ser");
		configReader = new XMLReader("config/" + NAME + ".xml");
	}

	// TODO 好像用不到了 ----不一定用不到 这个方法应该是返回list吧
	
	@Override
	public BussinessConditionPO getBussinessCondition(String enddate) throws RemoteException {
		return  null;
	}

}
