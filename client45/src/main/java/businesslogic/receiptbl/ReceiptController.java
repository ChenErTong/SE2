package businesslogic.receiptbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.receiptblservice.ReceiptBLService;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class ReceiptController implements ReceiptBLService{
    Receipt ReceiptBL = new Receipt();
	@Override
	public ResultMessage updateReceipt(ReceiptVO receiptVO, ReceiptType receiptType) {
		try {
			return ReceiptBL.updateReceipt(receiptVO, receiptType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		
		return ReceiptBL.passReceipt(VOs, receiptTypes);
	}

	@Override
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		return ReceiptBL.dontPassReceipt(VOs, receiptTypes);
	}

	@Override
	public <T extends ReceiptVO> ArrayList<T> show(ReceiptType type, ReceiptState state) {
		try {
			return ReceiptBL.show(type, state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
