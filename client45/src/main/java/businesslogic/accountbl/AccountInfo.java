package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.fundbl.AccountInfo_DebitAndPayBillVOShow;
import businesslogic.openingstockbl.AccountInfo_OpeningStock;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;

public class AccountInfo implements AccountInfo_DebitAndPayBillVOShow,AccountInfo_OpeningStock {
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

	@Override
	public ArrayList<AccountPO> find() throws RemoteException {
		return accountData.find();
	}
}
