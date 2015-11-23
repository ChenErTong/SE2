package businesslogic.organizationbl;

import java.util.ArrayList;

import businesslogicservice.organizationblservice.OrganizationBLService;
import state.ResultMessage;
import vo.BranchVO;
import vo.OrganizationVO;
import vo.TransferVO;

public class OrganizationController implements OrganizationBLService {
	
	Organization organization = new Organization();

	@Override
	public ArrayList<BranchVO> showBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBranchID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addBranch(BranchVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteBranch(String organizationID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateBranch(BranchVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public ArrayList<TransferVO> showTransfer() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransferID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addTransfer(TransferVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteTransfer(String organizationID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateTransfer(TransferVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
