package fund;

import businesslogic.fundbl.BankAccount;

public class MockBankAccount extends BankAccount {
	private String ID;

	public MockBankAccount(String iD) {
		ID = iD;
	}

	public String getID() {
		return ID;
	}
	
}
