package dataservice.organizationdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BranchPO;
import po.OrganizationPO;
import po.TransferPO;
import state.OrganizationType;
import state.ResultMessage;

public class OrganizationDataService_Stub implements OrganizationDataService{
	
	private ArrayList<OrganizationPO> organizationPOs;
	private OrganizationPO organizationPO_1;
	private OrganizationPO organizationPO_2;
	
	public OrganizationDataService_Stub(){
		organizationPOs = new ArrayList<OrganizationPO>();
		organizationPO_1 = new OrganizationPO("123","FUCK",120,OrganizationType.BRANCH);
		organizationPO_2 = new OrganizationPO("456","FUCKFUCK",150,OrganizationType.TRANSFER);
		
		organizationPOs.add(organizationPO_1);
		organizationPOs.add(organizationPO_2);
		}

	@Override
	public ResultMessage add(BranchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteBranch(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(BranchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BranchPO> findBranch() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteTransfer(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferPO> findTransfer() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ResultMessage add(OrganizationPO po) {
//		System.out.println("Insert a organization succeed!");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage delete(String ID) {
//		System.out.println("Delete a organization succeed!");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ResultMessage modify(OrganizationPO po) {
//		System.out.println("Modify the information of an organizationg succeed!");
//		return ResultMessage.SUCCESS;
//	}
//
//	@Override
//	public ArrayList<OrganizationPO> find() {
//		System.out.println("Show all organizations succeed!");
//		return new ArrayList<OrganizationPO>();
//	}

	

	

}
