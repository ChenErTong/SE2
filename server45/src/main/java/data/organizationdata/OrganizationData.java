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
	}

	@Override
	public ResultMessage add(BranchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteBranch(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(BranchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BranchPO> findBranch() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteTransfer(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferPO> findTransfer() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
