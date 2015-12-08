package businesslogic.fundbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.BankAccountInfo_OpeningStock;
import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:12
 */
public class BankAccountInfo implements BankAccountInfo_OpeningStock {
	BankAccount bankAccount;
	BankAccountDataService bankAccountData;

	public BankAccountInfo() {
		bankAccount = new BankAccount();
		bankAccountData = bankAccount.getData();
	}

	/**
	 * @see BankAccountInfo_OpeningStock#find()
	 */
	public ArrayList<BankAccountPO> find() throws RemoteException {
		return bankAccountData.find();
	}
}
