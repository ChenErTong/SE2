package data.branchdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.branchdataservice.BranchDataService;
import po.BasePO;
import po.BranchPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class BranchData extends ManageData implements BranchDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public BranchData() throws RemoteException {
		poList=new SerSaveAndLoad<BranchPO>("data/"+NAME+".ser");
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
