package receipt;

import java.util.ArrayList;

import businesslogic.receiptbl.Receipt;
import po.receiptpo.ReceiptPO;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class MockReceipt extends Receipt{
	@Override
	public ArrayList<ReceiptPO> passReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		System.out.println("These receipts have passed!");
		return null;
	}
}
