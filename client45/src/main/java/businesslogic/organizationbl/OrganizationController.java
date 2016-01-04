package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogic.organizationbl.branchbl.Branch;
import businesslogic.organizationbl.branchbl.BranchTrans;
import businesslogic.organizationbl.transferbl.Transfer;
import businesslogic.organizationbl.transferbl.TransferTrans;
import businesslogicservice.organizationblservice.OrganizationBLService;
import command.Command;
import command.CommandAdd;
import command.CommandController;
import command.CommandDelete;
import command.CommandModify;
import command.OrganizationCommandDoubleStack;
import po.BranchPO;
import po.TransferPO;
import state.OrganizationType;
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

	private Branch branchBL;
	private Transfer transferBL;
	private Organization organization;
	private CommandController<BranchPO> branchCommandController;
	private CommandController<TransferPO> transferCommandController;
	private OrganizationCommandDoubleStack doubleStack;

	public OrganizationController() throws MalformedURLException, RemoteException, NotBoundException {
		branchBL = new Branch();
		transferBL = new Transfer();
		organization = new Organization();
		branchCommandController = new CommandController<BranchPO>("branch");
		transferCommandController = new CommandController<TransferPO>("transfer");
		doubleStack = new OrganizationCommandDoubleStack("organization");
	}


	/**
	 * @see OrganizationBLService#getBranchID(String)
	 */
	public String getBranchID(String city) throws RemoteException {
		return branchBL.getBranchID(city);
	}

	/**
	 * @see OrganizationBLService#addBranch(BranchVO)
	 */
	public ResultMessage addBranch(BranchVO vo) throws RemoteException {
		LogController.getInstance().addLog("添加营业厅");
		BranchPO po = BranchTrans.convertVOtoPO(vo);
		Command<BranchPO> addCommand=new CommandAdd<BranchPO>(Branch.BLNAME, po);
		branchCommandController.addCommand(addCommand);
		doubleStack.add(OrganizationType.BRANCH);
		return addCommand.execute();
	}

	/**
	 * @see OrganizationBLService#deleteBranch(String)
	 */
	public ResultMessage deleteBranch(String organizationID) throws RemoteException {
		LogController.getInstance().addLog("删除营业厅");
		BranchPO po = branchBL.delete(organizationID);
		if (po == null) {
			return ResultMessage.FAIL;
		} else {
			branchCommandController.addCommand(new CommandDelete<BranchPO>(Branch.BLNAME, po));
			doubleStack.add(OrganizationType.BRANCH);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see OrganizationBLService#updateBranch(BranchVO)
	 */
	public ResultMessage updateBranch(BranchVO vo) throws RemoteException {
		LogController.getInstance().addLog("修改营业厅信息");
		BranchPO po = BranchTrans.convertVOtoPO(vo);
		BranchPO res =  branchBL.modify(po);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			Command<BranchPO> modifyCommand = new CommandModify<BranchPO>(Branch.BLNAME, res);
			branchCommandController.addCommand(modifyCommand);
			doubleStack.add(OrganizationType.BRANCH);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see OrganizationBLService#showBranch()
	 */
	public ArrayList<BranchVO> showBranch() throws RemoteException {
		return branchBL.showBranch();
	}

	/**
	 * @see OrganizationBLService#getAllBranchNumbers()
	 */
	public ArrayList<String> getAllBranchNumbers() throws RemoteException {
		return branchBL.getAllBranchNumbers();
	}

	/**
	 * @see OrganizationBLService#getTransferID(String)
	 */
	public String getTransferID(String city) throws RemoteException {
		return transferBL.getTransferID(city);
	}

	/**
	 * @see OrganizationBLService#addTransfer(TransferVO)
	 */
	public ResultMessage addTransfer(TransferVO vo) throws RemoteException {
		LogController.getInstance().addLog("添加中转中心");
		TransferPO transferPO = TransferTrans.convertVOtoPO(vo);
		Command<TransferPO> addCommand=new CommandAdd<TransferPO>(Transfer.BLNAME, transferPO);
		transferCommandController.addCommand(addCommand);
		doubleStack.add(OrganizationType.TRANSFER);
		return addCommand.execute();
	}

	/**
	 * @see OrganizationBLService#deleteTransfer(String)
	 */
	public ResultMessage deleteTransfer(String organizationID) throws RemoteException {
		LogController.getInstance().addLog("删除中转中心");
		TransferPO po = transferBL.delete(organizationID);
		if (po == null) {
			return ResultMessage.FAIL;
		} else {
			transferCommandController.addCommand(new CommandDelete<TransferPO>(Transfer.BLNAME, po));
			doubleStack.add(OrganizationType.TRANSFER);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see OrganizationBLService#updateTransfer(TransferVO)
	 */
	public ResultMessage updateTransfer(TransferVO vo) throws RemoteException {
		LogController.getInstance().addLog("修改中转中心信息");
		TransferPO transferPO = TransferTrans.convertVOtoPO(vo);
		TransferPO res =  transferBL.modify(transferPO);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			Command<TransferPO> modifyCommand = new CommandModify<TransferPO>(Transfer.BLNAME, res);
			transferCommandController.addCommand(modifyCommand);
			doubleStack.add(OrganizationType.BRANCH);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see OrganizationBLService#showTransfer()
	 */
	public ArrayList<TransferVO> showTransfer() throws RemoteException {
		return transferBL.showTransfer();
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


	private ResultMessage undo_Branch() throws RemoteException {
		return branchCommandController.undoCommand();
	}

	private ResultMessage redo_Branch() throws RemoteException {
		return branchCommandController.redoCommand();
	}


	private ResultMessage undo_Transfer() throws RemoteException {
		return transferCommandController.undoCommand();
	}

	private ResultMessage redo_Transfer() throws RemoteException {
		return transferCommandController.redoCommand();
	}

	@Override
	public boolean canUndo() {
		return doubleStack.canUndo();
	}

	@Override
	public boolean canRedo() {
		return doubleStack.canRedo();
	}

	@Override
	public ResultMessage undo() throws RemoteException {
		OrganizationType type = doubleStack.undo();
		if(type==OrganizationType.BRANCH)
			return this.undo_Branch();
		else{
			return this.undo_Transfer();
		}
	}

	@Override
	public ResultMessage redo() throws RemoteException {
		OrganizationType type = doubleStack.redo();
		if(type==OrganizationType.BRANCH)
			return this.redo_Branch();
		else{
			return this.redo_Transfer();
		}
	}

}
