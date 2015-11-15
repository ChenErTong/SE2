package Test;

import java.util.ArrayList;

import businesslogic.receiptbl.Receipt;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class MockReceipt extends Receipt{
	@Override
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		System.out.println("These receipts have passed!");
		return ResultMessage.SUCCESS;
	}
}
