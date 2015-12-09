package fund;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.fundbl.BankAccount;

public class MockBankAccount extends BankAccount {
	private String ID;

	
	public MockBankAccount(String iD) throws MalformedURLException, RemoteException, NotBoundException {
		ID = iD;
	}

	public String getID() {
		return ID;
	}
	
}
