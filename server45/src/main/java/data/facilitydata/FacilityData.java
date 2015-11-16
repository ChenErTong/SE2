package data.facilitydata;

import java.rmi.RemoteException;

import data.Data;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import po.PersistentObject;
import po.accountpo.AccountPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class FacilityData extends Data implements FacilityDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SerSaveAndLoad<PersistentObject> poList;
	public FacilityData() throws RemoteException {
		poList=new SerSaveAndLoad<PersistentObject>("data/"+NAME+".ser");
	}

	@Override
	public FacilityPO findFacility(String id)throws RemoteException {
		return (FacilityPO) poList.get(0);
	}

	@Override
	public ResultMessage addFacility(FacilityPO facility)throws RemoteException {
		System.out.println("ADD");
		if(poList.add(facility))
			return ResultMessage.SUCCESS;
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteFacility(FacilityPO facility)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyFacility(FacilityPO facility)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountPO findDriver(String id)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addDriver(AccountPO driver)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteDriver(AccountPO driver)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyDriver(AccountPO driver)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
