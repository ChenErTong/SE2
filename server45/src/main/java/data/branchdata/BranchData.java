package data.branchdata;

import java.rmi.RemoteException;

import data.Data;
import dataservice.branchdataservice.BranchDataService;
import po.BranchPO;
import state.ResultMessage;

public class BranchData extends Data implements BranchDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BranchData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(BranchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BranchPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BranchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
