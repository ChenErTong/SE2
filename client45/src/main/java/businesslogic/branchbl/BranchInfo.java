package businesslogic.branchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.BranchInfo_OpeningStock;
import dataservice.branchdataservice.BranchDataService;
import po.BranchPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:15
 */
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
