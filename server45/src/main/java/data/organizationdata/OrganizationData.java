package data.organizationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.organizationdataservice.OrganizationDataService;
import po.OpeningStockPO;
import po.OrganizationPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class OrganizationData extends ManageData<OrganizationPO> implements OrganizationDataService<OrganizationPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrganizationData() throws RemoteException {
		poList=new SerSaveAndLoad<OrganizationPO>("data/"+NAME+".ser");
	}

	@Override
	public ResultMessage insert(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrganizationPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
