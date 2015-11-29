package fund;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBankAccount {

	@Test
	public void test() {
		MockBankAccount mockBank = new MockBankAccount("ACC980");
		String bankID = mockBank.getID();
		assertEquals(bankID, "ACC980");
		
		
	}

}
