package data.facilitydata;

import java.rmi.RemoteException;

import data.Data;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import po.accountpo.AccountPO;
import state.ResultMessage;

public class FacilityData extends Data implements FacilityDataService<FacilityPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FacilityData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FacilityPO findFacility(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addFacility(FacilityPO facility) {
		// TODO Auto-generated method stub
		return null;
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
