package data.organizationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.organizationdataservice.OrganizationDataService;
import po.OrganizationPO;
import state.ResultMessage;

public class OrganizationData extends Data implements OrganizationDataService<OrganizationPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrganizationData() throws RemoteException {
		// TODO Auto-generated constructor stub
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
