package businesslogic.branchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.facilitybl.BranchInfo_Facility;
import businesslogic.openingstockbl.BranchInfo_OpeningStock;
import dataservice.branchdataservice.BranchDataService;
import po.BranchPO;
import po.FacilityPO;
import po.accountpo.AccountPO;
import state.ResultMessage;
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
	public ResultMessage addCar(FacilityPO car) throws RemoteException {
		BranchPO branch = branchData.find(car.getBranchID());
		ArrayList<FacilityPO> cars = branch.getFacilities();
		cars.add(car);
		return branchData.add(branch);
	}
	@Override
	public ResultMessage modifyCar(FacilityPO car) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteCar(FacilityPO car) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage addAccount(AccountPO account) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage modifyAccount(AccountPO account) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteAccount(AccountPO account) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
