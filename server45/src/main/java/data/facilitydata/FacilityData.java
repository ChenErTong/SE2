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
		for (int i = 0; i < poList.size(); i++) {
			PersistentObject po = poList.get(i);
			if(po.getID().equals(id))
				return (FacilityPO)po;
		}
		return null;
	}

	@Override
	public ResultMessage addFacility(FacilityPO facility)throws RemoteException {
		if(poList.add(facility))
			return ResultMessage.SUCCESS;
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteFacility(FacilityPO facility)throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PersistentObject po = poList.get(i);
			if(po.getID().equals(facility.getID())){
				poList.remove(i);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage modifyFacility(FacilityPO facility)throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PersistentObject po = poList.get(i);
			if(po.getID().equals(facility.getID())){
				poList.set(i, facility);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAIL;
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
