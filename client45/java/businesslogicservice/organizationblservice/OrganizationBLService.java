package businesslogicservice.organizationblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ResultMessage;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

/**
 * 提供进行公司机构管理界面所需要的服务【Orz感觉这个接口单独放好怪异】
 * 
 * @author zsq
 * @author Ann
 * @version Oct 22,2015
 */
public interface OrganizationBLService {

	public ArrayList<BranchVO> showBranch() throws RemoteException;

	/**
	 * 界面进行新建用户操作是得到一个可用的ID
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getBranchID(String city) throws RemoteException;

	/**
	 * 添加一个机构
	 * 
	 * @param vo
	 *            OrganizationVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addBranch(BranchVO vo) throws RemoteException;

	/**
	 * 删除一个机构
	 * 
	 * @param organizationID
	 * @return 处理信息
	 * @author zsq
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteBranch(String organizationID) throws RemoteException;

	/**
	 * 更新一个机构的信息
	 * 
	 * @param vo
	 *            OrganizationVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateBranch(BranchVO vo) throws RemoteException;

	/**
	 * @return 全部的系统用户
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<TransferVO> showTransfer() throws RemoteException;

	/**
	 * 界面进行新建用户操作是得到一个可用的ID
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getTransferID(String city) throws RemoteException;

	/**
	 * 添加一个机构
	 * 
	 * @param vo
	 *            OrganizationVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addTransfer(TransferVO vo) throws RemoteException;

	/**
	 * 删除一个机构
	 * 
	 * @param organizationID
	 * @return 处理信息
	 * @author zsq
	 * @veersion Oct 22,2015
	 */

	public ResultMessage deleteTransfer(String organizationID) throws RemoteException;

	/**
	 * 更新一个机构的信息
	 * 
	 * @param vo
	 *            OrganizationVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */

	public ResultMessage updateTransfer(TransferVO vo) throws RemoteException;

	/**
	 * 获得所有的营业厅编号
	 * 
	 * @author Ann
	 */
	public ArrayList<String> getAllBranchNumbers() throws RemoteException;

	// branch和transfer都调这一个方法
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID) throws RemoteException;

	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) throws RemoteException;

	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) throws RemoteException;
	/**
	 * 是否可以进行撤销操作
	 * 
	 * @return boolean型，返回true，表示可以进行撤销操作，此时撤销按钮应设为可以按下
	 *         返回false，表示不可以进行撤销操作，此时撤销按钮应设为不可以按下
	 */
	public boolean canUndo();
	/**
	 * 是否可以进行回撤操作
	 * 
	 * @return boolean型，返回true，表示可以进行回撤操作，此时回撤按钮应设为可以按下
	 *         返回false，表示不可以进行回撤操作，此时回撤按钮应设为不可以按下
	 */
	public boolean canRedo();
	/**
	 * 执行撤销操作
	 * @return 操作结果
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage undo() throws RemoteException;
	/**
	 * 执行回撤操作
	 * @return 操作结果
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage redo() throws RemoteException;
}
