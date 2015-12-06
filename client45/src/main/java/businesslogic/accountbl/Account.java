package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branchbl.BranchInfo;
import config.RMIConfig;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;
import state.ResultMessage;
import vo.accountvo.AccountVO;

/**
 * 存取account信息 通过BranchInfo和TransferInfo改变响应机构中人员的信息
 * 
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:31:26
 */
public class Account {
	/**
	 * Account数据接口
	 */
	private AccountDataService accountData;

	private BranchInfo_Account branchInfo;
	private TransferInfo_Account transferInfo;

	public Account() {
		accountData = getData();
		branchInfo = new BranchInfo();
	}

	public AccountDataService getData() {
		try {
			return (AccountDataService) Naming.lookup(RMIConfig.PREFIX + AccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AccountVO> show() throws RemoteException {
		return AccountTrans.convertPOstoVOs(accountData.find());
	}

	/**
	 * 按照职务返回人员列表
	 * 
	 * @param duty
	 *            String型，给定职务
	 * @return ArrayList<AccountVO>型 符合给定职务的人员列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<AccountVO> show(String duty) throws RemoteException {
		ArrayList<AccountPO> pos = accountData.find();
		return AccountTrans.convertPOstoVOsByDuty(pos, duty);
	}

	public String getID() throws RemoteException {
		return accountData.getID();
	}

	public ResultMessage addAccount(AccountVO vo) throws RemoteException {
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		ResultMessage message = this.addAccountInOrganization(po);
		if (message == ResultMessage.SUCCESS)
			return accountData.add(po);
		return ResultMessage.FAIL;
	}

	public ResultMessage deleteAccount(String ID) throws RemoteException {
		AccountPO po = accountData.find(ID);
		if (po == null) {
			return ResultMessage.FAIL;
		} else {
			String organizationID = po.getOrganizationID();
			ResultMessage message = this.deleteAccountInOrganization(organizationID, ID);
			if (message == ResultMessage.SUCCESS)
				return accountData.delete(ID);
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage updateAccount(AccountVO vo) throws RemoteException {
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		ResultMessage message = this.modifyAccountInOrganization(po);
		if (message == ResultMessage.SUCCESS)
			return accountData.modify(po);
		return ResultMessage.FAIL;
	}

	public AccountVO find(String id) throws RemoteException {
		AccountPO po = accountData.find(id);
		return AccountTrans.convertPOToVO(po);
	}

	/**
	 * 删除机构中的人员信息
	 * 
	 * @see BranchInfo_Account#addAccount(AccountPO)
	 * @see TransferInfo_Account#addAccount(AccountPO)
	 * @param organizationID
	 *            String型，机构编号
	 * @param accountID
	 *            String型，人员编号
	 * @return 是否删除成功
	 * @throws RemoteException
	 *             远程异常
	 */
	private ResultMessage deleteAccountInOrganization(String organizationID, String accountID) throws RemoteException {
		if (organizationID.length() == 4) {
			// The organization is transfer,use transferInfo to delete this
			// account
			return transferInfo.deleteAccount(organizationID, accountID);
		} else if (organizationID.length() == 6) {
			// The organization is branch, use branchInfo to delete this account
			return branchInfo.deleteAccount(organizationID, accountID);
		} else {
			// the length of organizationID is not 4 or 6
			System.out.println(
					"the length of organizationID is not 4 or 6,please check the length of organizaiont ID in account"
							+ accountID);
			return ResultMessage.FAIL;
		}
	}

	/**
	 * 添加机构中的人员信息
	 * 
	 * @see BranchInfo_Account#addAccount(AccountPO)
	 * @see TransferInfo_Account#addAccount(AccountPO)
	 * @param account
	 *            AccountPO型，人员信息
	 * @return 是否添加成功
	 * @throws RemoteException
	 *             远程异常
	 */
	private ResultMessage addAccountInOrganization(AccountPO account) throws RemoteException {
		String organizationID = account.getOrganizationID();
		if (organizationID.length() == 4) {
			// The organization is transfer,use transferInfo to add this account
			return transferInfo.addAccount(account);
		} else if (organizationID.length() == 6) {
			// The organization is branch, use branchInfo to add this account
			return branchInfo.addAccount(account);
		} else {
			// the length of organizationID is not 4 or 6
			System.out.println(
					"the length of organizationID is not 4 or 6,please check the length of organizaiont ID in account"
							+ account.getID());
			return ResultMessage.FAIL;
		}
	}

	/**
	 * 修改机构中的人员信息
	 * 
	 * @see BranchInfo_Account#modifyAccount(AccountPO)
	 * @see TransferInfo_Account#modifyAccount(AccountPO)
	 * @param account
	 *            AccountPO型，新人员信息
	 * @return 是否修改成功
	 * @throws RemoteException
	 *             远程异常
	 */
	private ResultMessage modifyAccountInOrganization(AccountPO account) throws RemoteException {
		String organizationID = account.getOrganizationID();
		if (organizationID.length() == 4) {
			// The organization is transfer,use transferInfo to modify this
			// account
			return transferInfo.modifyAccount(account);
		} else if (organizationID.length() == 6) {
			// The organization is branch, use branchInfo to modify this account
			return branchInfo.modifyAccount(account);
		} else {
			// the length of organizationID is not 4 or 6
			System.out.println(
					"the length of organizationID is not 4 or 6,please check the length of organizaiont ID in account"
							+ account.getID());
			return ResultMessage.FAIL;
		}
	}

}
