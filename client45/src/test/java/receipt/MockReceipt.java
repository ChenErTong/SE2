package receipt;

import java.util.ArrayList;

import businesslogic.receiptbl.Receipt;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class MockReceipt extends Receipt{
	@Override
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs) {
		System.out.println("These receipts have passed!");
		return null;
	}
}
