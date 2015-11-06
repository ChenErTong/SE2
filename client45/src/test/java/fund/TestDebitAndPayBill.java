package fund;

import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import vo.DebitAndPayBillVO;

public class TestDebitAndPayBill {

	@Test
	public void testDebitAndPayBill() {
		HashMap<String, String> accounts = new HashMap<>();
		accounts.put("ACC001", "公司一号账户");
		accounts.put("ACC002", "公司二号账户");
		accounts.put("ACC999", "公司秘密账户");
		MockDebitAndPayBill mockDebitAndPayBill = new MockDebitAndPayBill("PAY00123", "EXPENSE00532", accounts);

		String payID = mockDebitAndPayBill.getPayID();
		assertEquals("PAY00123", payID);
		
		String expenseID = mockDebitAndPayBill.getExpenseID();
		assertEquals("EXPENSE00532", expenseID);
		
		mockDebitAndPayBill.findDebitAndPayBillVO(payID);
		DebitAndPayBillVO debitAndPayBillVO = mockDebitAndPayBill.getDebitAndPayBillVO();
		assertEquals(payID, debitAndPayBillVO.getID());
		
		HashMap<String, String> allAccounts=  mockDebitAndPayBill.getAllBankAccounts();
		assertEquals(accounts, allAccounts);
	}

}
