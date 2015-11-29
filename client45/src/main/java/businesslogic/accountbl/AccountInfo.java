package businesslogic.accountbl;

import java.rmi.RemoteException;

import businesslogic.fundbl.AccountInfo_DebitAndPayBillVOShow;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;

public class AccountInfo implements AccountInfo_DebitAndPayBillVOShow {
	Account account;
	AccountDataService accountData;
	public AccountInfo() {
		account = new Account();
		accountData = account.getData();
	}
	
	@Override
	public boolean isAccountAMemberOfBranch(String accountID, String branchID) throws RemoteException {
		AccountPO po = accountData.find(accountID);
		if(po.getBranchID().equals(branchID))
			return true;
		return false;
	}
}
