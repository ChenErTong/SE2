package data.facilitydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import po.PersistentObject;
import po.accountpo.AccountPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class FacilityData extends Data implements FacilityDataService<FacilityPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SerSaveAndLoad<PersistentObject> poList;
	public FacilityData() throws RemoteException {
		poList=new SerSaveAndLoad<PersistentObject>(NAME);
	}

	@Override
	public FacilityPO findFacility(String id) {
		return (FacilityPO) poList.get(0);
	}

	@Override
	public ResultMessage addFacility(FacilityPO facility) {
		if(poList.add(facility))
			return ResultMessage.SUCCESS;
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteFacility(FacilityPO facility) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyFacility(FacilityPO facility) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountPO findDriver(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addDriver(AccountPO driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteDriver(AccountPO driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyDriver(AccountPO driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
