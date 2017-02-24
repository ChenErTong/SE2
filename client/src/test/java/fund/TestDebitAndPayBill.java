package fund;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import org.junit.Test;

public class TestDebitAndPayBill {

	@Test
	public void testDebitAndPayBill() {
		HashMap<String, String> accounts = new HashMap<>();
		accounts.put("ACC001", "公司一号账户");
		accounts.put("ACC002", "公司二号账户");
		accounts.put("ACC999", "公司秘密账户");
		MockDebitAndPayBill mockDebitAndPayBill = null;
		try {
			mockDebitAndPayBill = new MockDebitAndPayBill("PAY00123", "EXPENSE00532", accounts);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		String payID = mockDebitAndPayBill.getPayID();
		assertEquals("PAY00123", payID);

		String expenseID = mockDebitAndPayBill.getExpenseID();
		assertEquals("EXPENSE00532", expenseID);

		mockDebitAndPayBill.findDebitAndPayBillVO(payID);
		// DebitAndPayBillVO debitAndPayBillVO =
		// mockDebitAndPayBill.getDebitAndPayBillVO();
		// assertEquals(payID, debitAndPayBillVO.ID);

		HashMap<String, String> allAccounts = mockDebitAndPayBill.getAllBankAccounts();
		assertEquals(accounts, allAccounts);

	}

}
