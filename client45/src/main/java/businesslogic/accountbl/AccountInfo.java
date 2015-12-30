package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.fundbl.AccountInfo_DebitAndPayBillVOShow;
import businesslogic.openingstockbl.AccountInfo_OpeningStock;
import businesslogic.organizationbl.AccountInfo_Branch_Transfer;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;
import vo.accountvo.AccountVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:08
 */
public class AccountInfo
		implements AccountInfo_DebitAndPayBillVOShow, AccountInfo_OpeningStock, AccountInfo_Branch_Transfer {
	Account account;
	AccountDataService accountData;

	public AccountInfo() throws MalformedURLException, RemoteException, NotBoundException {
		account = new Account();
		accountData = account.getData();
	}

	/**
	 * @see AccountInfo_DebitAndPayBillVOShow#isAccountAMemberOfBranch(String,
	 *      String)
	 */
	public boolean isAccountAMemberOfBranch(String accountID, String branchID) throws RemoteException {
		AccountPO po = accountData.find(accountID);
		if (po.getOrganizationID().equals(branchID))
			return true;
		return false;
	}

	/**
	 * @see AccountInfo_OpeningStock#find()
	 */
	public ArrayList<AccountPO> find() throws RemoteException {
		return accountData.find();
	}

	/**
	 * @see AccountInfo_Branch_Transfer#getAccountByOrganizationID(String)
	 */
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID) throws RemoteException {
		ArrayList<AccountPO> pos = accountData.find();
		ArrayList<AccountVO> vos = new ArrayList<>();
		for (AccountPO accountPO : pos) {
			if (accountPO.getOrganizationID().equals(organizationID)) {
				AccountVO vo = AccountTrans.convertPOToVO(accountPO);
				vos.add(vo);
			}
		}
		return vos;
	}
}