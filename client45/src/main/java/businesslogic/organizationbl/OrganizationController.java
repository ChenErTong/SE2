package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.organizationblservice.OrganizationBLService;
import state.ResultMessage;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:24
 */
public class OrganizationController implements OrganizationBLService {
	
	Organization organization = new Organization();

	public String getID() {
		/**
		 * @author Ann
		 */
		//我觉得没有必要getID
		return null;
	}

	@Override
	public String getBranchID(String city) throws RemoteException {
			return organization.getBranchID(city);
	}

	@Override
	public ResultMessage addBranch(BranchVO vo) throws RemoteException {
			return organization.addBranch(vo);
	}

	@Override
	public ResultMessage deleteBranch(String organizationID)  throws RemoteException{
			return organization.deleteBranch(organizationID);
	}

	@Override
	public ResultMessage updateBranch(BranchVO vo) throws RemoteException {
			return organization.updateBranch(vo);
	}

	
	
	@Override
	public ArrayList<BranchVO> showBranch() throws RemoteException {
			return organization.showBranch();
	}

	@Override
	public ArrayList<String> getAllBranchNumbers() throws RemoteException {
			return organization.getAllBranchNumbers();
	}

	@Override
	public String getTransferID(String city)  throws RemoteException{
			return organization.getTransferID(city);
	}

	@Override
	public ResultMessage addTransfer(TransferVO vo) throws RemoteException {
			return organization.addTransfer(vo);
	}

	@Override
	public ResultMessage deleteTransfer(String organizationID) throws RemoteException {
			return organization.deleteTransfer(organizationID);
	}

	@Override
	public ResultMessage updateTransfer(TransferVO vo) throws RemoteException {
			return organization.updateTransfer(vo);
	}

	public ArrayList<TransferVO> showTransfer() throws RemoteException {
			return organization.showTransfer();
	}

	@Override
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID) throws RemoteException {
			return organization.getAccountsByOrganizationID(organizationID);
	}

	@Override
	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) throws RemoteException {
			return organization.getFacilitiesByBranchID(branchID);
	}

	@Override
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID)  throws RemoteException{
			return organization.getInventoriesByTransferID(transferID);
	}
	

}
