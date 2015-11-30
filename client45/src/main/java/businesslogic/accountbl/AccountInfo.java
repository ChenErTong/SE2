package businesslogic.accountbl;

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
	public boolean isAccountAMemberOfBranch(String accountID, String branchID) {
		AccountPO po = accountData.find(accountID);
		if(po.getBranchID().equals(branchID))
			return true;
		return false;
	}
}
