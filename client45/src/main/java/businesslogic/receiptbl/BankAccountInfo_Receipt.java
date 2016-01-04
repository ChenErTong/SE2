package businesslogic.receiptbl;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import state.ResultMessage;

public interface BankAccountInfo_Receipt {
public ResultMessage subtractMoneyInBankAccount(String accountID,BigDecimal money) throws RemoteException;
	
	public ResultMessage addMoneyInBankAccount(String accountID,BigDecimal money) throws RemoteException;
}
