package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.organizationblservice.OrganizationBLService;
import state.ResultMessage;
import vo.BranchVO;

import vo.TransferVO;

public class OrganizationController implements OrganizationBLService {
	
	Organization organization = new Organization();

	@Override
	public ArrayList<BranchVO> showBranch() {
		try {
			return organization.showBranch();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getBranchID() {
		try {
			return organization.getBranchID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addBranch(BranchVO vo) {
		try {
			return organization.addBranch(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteBranch(String organizationID) {
		try {
			return organization.deleteBranch(organizationID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage updateBranch(BranchVO vo) {
		try {
			return organization.updateBranch(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	
	
	public ArrayList<TransferVO> showTransfer() {

		try {
			return organization.showTransfer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String getTransferID() {
		try {
			return organization.getTransferID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addTransfer(TransferVO vo) {
		try {
			return organization.addTransfer(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteTransfer(String organizationID) {
		try {
			return organization.deleteTransfer(organizationID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage updateTransfer(TransferVO vo) {
		try {
			return organization.updateTransfer(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
