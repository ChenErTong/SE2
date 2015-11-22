package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branch.BranchTrans;
import dataservice.branchdataservice.BranchDataService;
import dataservice.organizationdataservice.OrganizationDataService;
import dataservice.transferdataservice.TransferDataService;
import po.BranchPO;
import po.FacilityPO;
import po.OrganizationPO;
import po.TransferPO;
import state.ResultMessage;
import vo.BranchVO;
import vo.OrganizationVO;
import vo.TransferVO;

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

	public ArrayList<BranchVO> showBranch() throws RemoteException {
		ArrayList<BranchPO> branchPOs = branchData.find();
		return BranchTrans.convertPOstoVOs(branchPOs);
	}

	public String getBranchID()throws RemoteException  {
		return branchData.getID();
	}

	public ResultMessage addBranch(BranchVO vo) throws RemoteException {
		BranchPO po = BranchTrans.convertVOtoPO(vo);
		return branchData.add(po);
	}

	public ResultMessage deleteBranch(String organizationID) throws RemoteException {
		return branchData.delete(organizationID);
	}

	public ResultMessage updateBranch(BranchVO vo)throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransferVO> showTransfer()throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTransferID()throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addTransfer(TransferVO vo)throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteTransfer(String organizationID)throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateTransfer(TransferVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
