package data.facilitydata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import po.PersistentObject;
import po.accountpo.AccountPO;
import state.ResultMessage;
import util.SerSaveAndLoad;
/**
 * 
 * @author Ann
 * 2015-11-17 21:37:04
 */
public class FacilityData extends ManageData<PersistentObject> implements FacilityDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public FacilityData() throws RemoteException {
		poList=new SerSaveAndLoad<PersistentObject>("data/"+NAME+".ser");
	}

	@Override
	public FacilityPO findFacility(String id)throws RemoteException {
		return (FacilityPO)super.find(id);}

	@Override
	public ResultMessage addFacility(FacilityPO facility)throws RemoteException {
		return super.add(facility);	}

	@Override
	public ResultMessage deleteFacility(String id)throws RemoteException {
		return super.delete(id);	}

	@Override
	public ResultMessage modifyFacility(FacilityPO facility)throws RemoteException {
		return super.modify(facility);}

	@Override
	public AccountPO findDriver(String id)throws RemoteException {
		return (AccountPO)super.find(id);}

	@Override
	public ResultMessage addDriver(AccountPO driver)throws RemoteException {
		return super.add(driver);}

	@Override
	public ResultMessage deleteDriver(String id)throws RemoteException {
		return super.delete(id);}

	@Override
	public ResultMessage modifyDriver(AccountPO driver)throws RemoteException {
		return super.modify(driver);}


}
