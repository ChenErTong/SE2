package data.organizationdata;

import java.rmi.RemoteException;

import dataservice.organizationdataservice.OrganizationDataService;

public class OrganizationData  implements OrganizationDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrganizationData() throws RemoteException {
//		poList=new SerSaveAndLoad<OrganizationPO>("data/"+NAME+".ser");
		//这个类好像用不到了
	}



}
