package data.organizationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.organizationdataservice.OrganizationDataService;
import po.OrganizationPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class OrganizationData extends ManageData<OrganizationPO> implements OrganizationDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrganizationData() throws RemoteException {
		poList=new SerSaveAndLoad<OrganizationPO>("data/"+NAME+".ser");
	}


}
