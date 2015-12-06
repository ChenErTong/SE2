package businesslogic.branchbl;

import java.nio.channels.AcceptPendingException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.facilitybl.BranchInfo_Facility;
import businesslogic.openingstockbl.BranchInfo_OpeningStock;
import dataservice.branchdataservice.BranchDataService;
import po.BranchPO;
import po.accountpo.AccountPO;
import state.ResultMessage;
import vo.FacilityVO;
import vo.accountvo.AccountVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:15
 */
public class BranchInfo implements BranchInfo_OpeningStock,BranchInfo_Facility{
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
	@Override
	public ResultMessage addCar(FacilityVO driver) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage modifyCar(FacilityVO driver) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteCar(FacilityVO driver) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage addAccount(AccountVO account) throws RemoteException {
		BranchPO po = branchData.find(account.branchID);
		ArrayList<AccountPO> accounts = po.getAccounts();
		accounts.add(a)
		return ResultMessage.SUCCESS;
	}
	@Override
	public ResultMessage modifyAccount(AccountVO account) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteAccount(AccountVO account) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
