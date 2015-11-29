package receipt;

import java.util.ArrayList;

import org.junit.Test;

import vo.receiptvo.ReceiptVO;

public class TestReceipt {

	@Test
	public void testReceipt() {
		MockReceipt mockReceipt = new MockReceipt();
		ArrayList<ReceiptVO> VOs = new ArrayList<>();
		VOs.add(new ReceiptVO("BRANCH001", null));
		VOs.add(new ReceiptVO("TRANSFER056", null));
		mockReceipt.passReceipt(VOs);
	}

}
