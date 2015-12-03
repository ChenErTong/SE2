package businesslogic.branchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.BranchInfo_OpeningStock;
import dataservice.branchdataservice.BranchDataService;
import po.BranchPO;

public class BranchInfo implements BranchInfo_OpeningStock{
	Branch branch;
	BranchDataService branchData;
	public BranchInfo() {
		branch = new Branch();
		branchData = branch.getData();
	}
	@Override
	public ArrayList<BranchPO> find() throws RemoteException {
		return branchData.find();
	}
}
