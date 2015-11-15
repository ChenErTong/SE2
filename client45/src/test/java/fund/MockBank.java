package fund;

import businesslogic.fundbl.Bank;

public class MockBank extends Bank {
	private String ID;

	public MockBank(String iD) {
		ID = iD;
	}

	public String getID() {
		return ID;
	}
	
}
