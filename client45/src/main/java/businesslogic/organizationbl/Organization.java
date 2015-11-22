package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.branchdataservice.BranchDataService;
import dataservice.organizationdataservice.OrganizationDataService;
import dataservice.transferdataservice.TransferDataService;
import po.BranchPO;
import po.FacilityPO;
import po.OrganizationPO;
import po.TransferPO;
import state.ResultMessage;
import vo.OrganizationVO;

public class Organization {
	private BranchDataService branchData;
	private TransferDataService transferData;

	public Organization() {
		try {
			branchData = (BranchDataService) Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + BranchDataService.NAME);
			transferData = (TransferDataService) Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + TransferDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<OrganizationVO> show() throws RemoteException{
		ArrayList<BranchPO> branchPOs = branchData.find();
		ArrayList<TransferPO> transferPOs = transferData.find();
//		ArrayList<OrganizationPO> organizationPOs=organizationData.find();
//		ArrayList<OrganizationVO> organizationVOs=
		return null;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addOrganization(OrganizationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteOrganization(String organizationID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateOrganization(OrganizationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
}
