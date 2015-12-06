package businesslogic.accountbl;

import java.rmi.RemoteException;

import po.accountpo.AccountPO;
import state.ResultMessage;

/**
 * 更改机构中的人员信息
 * 
 * @author Ann
 * @version 创建时间：2015年12月6日 下午1:46:55
 */
public interface OranizationInfo_Account {
	/**
	 * 在机构中添加一个人员
	 * 
	 * @see AccountPO#getOrganizationID()
	 * @param account
	 *            AccountPO型，要添加的人员
	 * @return 是否添加成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage addAccount(AccountPO account) throws RemoteException;

	/**
	 * 在机构中修改一个人员信息
	 * 
	 * @see AccountPO#getOrganizationID()
	 * @param account
	 *            AccountPO型，要修改的人员
	 * @return 是否修改成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage modifyAccount(AccountPO account) throws RemoteException;

	/**
	 * 在机构中删除一个人员
	 * 
	 * @param organizationID
	 *            String型，人员所在的机构ID 用于查找机构
	 * @param ID
	 *            String型，人员的ID编号
	 * @return 是否删除成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage deleteAccount(String organizationID, String ID) throws RemoteException;
}
