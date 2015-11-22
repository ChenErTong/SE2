package data.organizationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.organizationdataservice.OrganizationDataService;
import po.BranchPO;
import po.OrganizationPO;
import po.TransferPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

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
