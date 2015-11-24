package dataservice.branchdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BranchPO;
import state.ResultMessage;

public class _Branch_Data_Stub implements BranchDataService {

	@Override
	public ResultMessage add(BranchPO po) {
		System.out.println("You have inserted a branch!");
		return ResultMessage.SUCCESS;
	}

//	@Override
//	public BranchPO find(String id) {
//		BranchPO branchPO = new BranchPO(id, "Nanjing", "2015-2-3", new ArrayList<>(), new ArrayList<>());
//		System.out.println("You have found a branch!");
//		return branchPO;
//	}

	@Override
	public ResultMessage modify(BranchPO po) {
		System.out.println("You have updated a branch!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BranchPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getID(String cityCode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
