package businesslogic.receiptbl;

import java.util.ArrayList;

import businesslogicservice.receiptblservice.ReceiptBLService;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class Receipt implements ReceiptBLService{

	@Override
	public ResultMessage updateReceipt(ReceiptVO receiptVO, ReceiptType receiptType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> showReceipt(ReceiptState receiptStates) {
		// TODO Auto-generated method stub
		return null;
	}

}
