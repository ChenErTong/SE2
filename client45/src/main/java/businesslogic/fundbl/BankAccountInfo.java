package businesslogic.fundbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.BankAccountInfo_OpeningStock;
import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;

public class BankAccountInfo implements BankAccountInfo_OpeningStock{
	BankAccount bankAccount;
	BankAccountDataService bankAccountData;
	public BankAccountInfo() {
		bankAccount = new BankAccount();
		bankAccountData = bankAccount.getData();
	}
	@Override
	public ArrayList<BankAccountPO> find() throws RemoteException {
		return bankAccountData.find();
	}
}