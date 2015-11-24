package data.branchdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.branchdataservice.BranchDataService;
import po.BranchPO;
import util.SerSaveAndLoad;
import util.Util;

public class BranchData extends ManageData<BranchPO> implements BranchDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public BranchData() throws RemoteException {
		poList=new SerSaveAndLoad<BranchPO>("data/"+NAME+".ser");
	}
	/**
	 * 营业厅编号(025(城市编码)+1(营业厅)+000(鼓楼营业厅))
	 * @author Ann
	 */
	@Override
	public String getID(String cityCode) {
		String prifix=cityCode+1;
		int branchNumber=poList.size();
		return prifix+Util.transIntToString(branchNumber, 3);
	}
}
