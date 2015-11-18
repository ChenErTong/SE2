package fund;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.fundbl.BankAccount;

public class TestBankAccount {

	@Test
	public void test() {
		MockBankAccount mockBank = new MockBankAccount("ACC980");
		String bankID = mockBank.getID();
		assertEquals(bankID, "ACC980");
		
		
	}

}