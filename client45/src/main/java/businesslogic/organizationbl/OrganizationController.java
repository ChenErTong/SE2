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
		// 我觉得没有必要getID
		return null;
	}

	/**
	 * @see OrganizationBLService#getBranchID(String)
	 */
	public String getBranchID(String city) throws RemoteException {
		return organization.getBranchID(city);
	}

	/**
	 * @see OrganizationBLService#addBranch(BranchVO)
	 */
	public ResultMessage addBranch(BranchVO vo) throws RemoteException {
		return organization.addBranch(vo);
	}

	/**
	 * @see OrganizationBLService#deleteBranch(String)
	 */
	public ResultMessage deleteBranch(String organizationID) throws RemoteException {
		return organization.deleteBranch(organizationID);
	}

	/**
	 * @see OrganizationBLService#updateBranch(BranchVO)
	 */
	public ResultMessage updateBranch(BranchVO vo) throws RemoteException {
		return organization.updateBranch(vo);
	}

	/**
	 * @see OrganizationBLService#showBranch()
	 */
	public ArrayList<BranchVO> showBranch() throws RemoteException {
		return organization.showBranch();
	}

	/**
	 * @see OrganizationBLService#getAllBranchNumbers()
	 */
	public ArrayList<String> getAllBranchNumbers() throws RemoteException {
		return organization.getAllBranchNumbers();
	}

	/**
	 * @see OrganizationBLService#getTransferID(String)
	 */
	public String getTransferID(String city) throws RemoteException {
		return organization.getTransferID(city);
	}

	/**
	 * @see OrganizationBLService#addTransfer(TransferVO)
	 */
	public ResultMessage addTransfer(TransferVO vo) throws RemoteException {
		return organization.addTransfer(vo);
	}

	/**
	 * @see OrganizationBLService#deleteTransfer(String)
	 */
	public ResultMessage deleteTransfer(String organizationID) throws RemoteException {
		return organization.deleteTransfer(organizationID);
	}

	/**
	 * @see OrganizationBLService#updateTransfer(TransferVO)
	 */
	public ResultMessage updateTransfer(TransferVO vo) throws RemoteException {
		return organization.updateTransfer(vo);
	}

	/**
	 * @see OrganizationBLService#showTransfer()
	 */
	public ArrayList<TransferVO> showTransfer() throws RemoteException {
		return organization.showTransfer();
	}

	/**
	 * @see OrganizationBLService#getAccountByOrganizationID(String)
	 */
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID) throws RemoteException {
		return organization.getAccountsByOrganizationID(organizationID);
	}

	/**
	 * @see OrganizationBLService#getFacilitiesByBranchID(String)
	 */
	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) throws RemoteException {
		return organization.getFacilitiesByBranchID(branchID);
	}

	/**
	 * @see OrganizationBLService#getInventoriesByTransferID(String)
	 */
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) throws RemoteException {
		return organization.getInventoriesByTransferID(transferID);
	}

}
