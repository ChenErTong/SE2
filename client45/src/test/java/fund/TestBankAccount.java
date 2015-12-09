package fund;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

public class TestBankAccount {

	@Test
	public void test() {
		MockBankAccount mockBank = null;
		try {
			mockBank = new MockBankAccount("ACC980");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		String bankID = mockBank.getID();
		assertEquals(bankID, "ACC980");
		
		
	}

}
