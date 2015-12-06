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
		branch.setFacilities(cars);
		return branchData.add(branch);
	}
	@Override
	public ResultMessage modifyCar(FacilityPO car) throws RemoteException {
		BranchPO branch = branchData.find(car.getBranchID());
		ArrayList<FacilityPO> cars = branch.getFacilities();
		for (int i = 0; i < cars.size(); i++) {
			if(cars.get(i).getID().equals(car.getID())){
				cars.set(i, car);
			}
		}
		branch.setFacilities(cars);
		return branchData.add(branch);
	}
	@Override
	public ResultMessage deleteCar(String branchID,String ID) throws RemoteException {
		BranchPO branch = branchData.find(branchID);
		ArrayList<FacilityPO> cars = branch.getFacilities();
		for (int i = 0; i < cars.size(); i++) {
			if(cars.get(i).getID().equals(ID)){
				cars.remove(i);
			}
		}
		branch.setFacilities(cars);
		return branchData.add(branch);
	}
	@Override
	public ResultMessage addAccount(AccountPO account) throws RemoteException {
		BranchPO branch = branchData.find(account.getOrganizationID());
		ArrayList<AccountPO> accounts = branch.getAccounts();
		accounts.add(account);
		branch.setAccounts(accounts);
		return branchData.add(branch);
	}
	@Override
	public ResultMessage modifyAccount(AccountPO account) throws RemoteException {
		BranchPO branch = branchData.find(account.getOrganizationID());
		ArrayList<AccountPO> accounts = branch.getAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getID().equals(account.getID())){
				accounts.set(i, account);
			}
		}
		branch.setAccounts(accounts);
		return branchData.add(branch);
	}
	@Override
	public ResultMessage deleteAccount(String branchID,String ID) throws RemoteException {
		BranchPO branch = branchData.find(branchID);
		ArrayList<AccountPO> accounts = branch.getAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getID().equals(ID)){
				accounts.remove(i);
			}
		}
		branch.setAccounts(accounts);
		return branchData.add(branch);
	}
}
