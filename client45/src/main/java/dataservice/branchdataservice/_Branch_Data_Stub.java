package dataservice.branchdataservice;

import java.util.ArrayList;

import po.BranchPO;
import state.ResultMessage;

public class _Branch_Data_Stub implements BranchDataService {

	@Override
	public ResultMessage insert(BranchPO po) {
		System.out.println("You have inserted a branch!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public BranchPO find(String id) {
		BranchPO branchPO = new BranchPO(id, "Nanjing", "2015-2-3", new ArrayList<>(), new ArrayList<>());
		System.out.println("You have found a branch!");
		return branchPO;
	}

	@Override
	public ResultMessage update(BranchPO po) {
		System.out.println("You have updated a branch!");
		return ResultMessage.SUCCESS;
	}

}
