package data.organizationdata;

import java.rmi.RemoteException;

import data.Data;
import dataservice.organizationdataservice.OrganizationDataService;

public class OrganizationData extends Data implements OrganizationDataService {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrganizationData() throws RemoteException {
//		poList=new SerSaveAndLoad<OrganizationPO>("data/"+NAME+".ser");
		//这个类好像用不到了
	}

	@Override
	public void initialFile() {
		//TODO
	}
}
