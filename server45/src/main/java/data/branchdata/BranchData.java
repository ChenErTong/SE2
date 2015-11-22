package data.branchdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.branchdataservice.BranchDataService;
import po.BranchPO;
import util.SerSaveAndLoad;

public class BranchData extends ManageData<BranchPO> implements BranchDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public BranchData() throws RemoteException {
		//TODO 什么Name待考虑
		poList=new SerSaveAndLoad<BranchPO>("data/"+NAME+".ser");
	}
	@Override
	public String getID() {
		return null;
	}
}
