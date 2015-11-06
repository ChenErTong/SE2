package receipt;

import java.util.ArrayList;

import org.junit.Test;

import state.ReceiptType;
import vo.receiptvo.ReceiptVO;

public class TestReceipt {

	@Test
	public void test() {
		MockReceipt mockReceipt = new MockReceipt();
		ArrayList<ReceiptVO> VOs = new ArrayList<>();
		VOs.add(new ReceiptVO("BRANCH001"));
		VOs.add(new ReceiptVO("TRANSFER056"));
		mockReceipt.passReceipt(VOs, ReceiptType.BRANCH_ARRIVAL);
	}

}
