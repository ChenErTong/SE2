package businesslogic.fundbl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.BankAccountInfo_OpeningStock;
import businesslogic.receiptbl.BankAccountInfo_Receipt;
import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;
import state.ResultMessage;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:12
 */
public class BankAccountInfo implements BankAccountInfo_OpeningStock,BankAccountInfo_Receipt {
	BankAccount bankAccount;
	BankAccountDataService bankAccountData;

	public BankAccountInfo() throws MalformedURLException, RemoteException, NotBoundException {
		bankAccount = new BankAccount();
		bankAccountData = bankAccount.getData();
	}

	/**
	 * @see BankAccountInfo_OpeningStock#find()
	 */
	public ArrayList<BankAccountPO> find() throws RemoteException {
		return bankAccountData.find();
	}
	
	/**
	 * 减少银行账户中的金额
	 * 
	 * @param accountID
	 *            String型，银行账户编号
	 * @param money
	 *            BigDecimal型，金额
	 * @return ResultMessage型，扣款是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage subtractMoneyInBankAccount(String accountID, BigDecimal money) throws RemoteException {
		BankAccountPO po = bankAccountData.find(accountID);
		System.out.println(accountID);
		if(po==null)
			return ResultMessage.FAIL;
		BigDecimal oldmoney = po.getMoney();
		if (oldmoney.compareTo(money) >= 0)
			oldmoney = oldmoney.subtract(money);
		po.setMoney(oldmoney);
		return bankAccount.modify(po)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
	}
	
	/**
	 * 添加银行账户中的金额
	 * 
	 * @param String型，银行账户编号
	 * @param money
	 *            BigDecimal型，金额
	 * @return ResultMessage型，添加是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage addMoneyInBankAccount(String accountID, BigDecimal money) throws RemoteException {
		BankAccountPO po = bankAccountData.find(accountID);
		BigDecimal oldmoney = po.getMoney();
		oldmoney = oldmoney.add(money);
		po.setMoney(oldmoney);
		return bankAccount.modify(po)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
	}
}
