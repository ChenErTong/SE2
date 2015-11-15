package fund;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBank {

	@Test
	public void test() {
		MockBank mockBank = new MockBank("ACC980");
		String bankID = mockBank.getID();
		assertEquals(bankID, "ACC980");
	}

}
