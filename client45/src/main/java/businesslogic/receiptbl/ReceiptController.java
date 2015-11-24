package businesslogic.receiptbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.receiptblservice.ReceiptBLService;
import po.receiptpo.ReceiptPO;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class ReceiptController implements ReceiptBLService{
    Receipt ReceiptBL;
	@Override
	public ResultMessage updateReceipt(ReceiptVO receiptVO, ReceiptType receiptType) {
		try {
			return ReceiptBL.updateReceipt(receiptVO, receiptType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> passReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		
		return ReceiptBL.passReceipt(VOs, receiptTypes);
	}

	@Override
	public ArrayList<ReceiptPO> dontPassReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		
		return ReceiptBL.dontPassReceipt(VOs, receiptTypes);
	}

	@Override
	public ArrayList<ReceiptVO> showReceipt(ReceiptState receiptStates) {
		try {
			return ReceiptBL.showReceipt(receiptStates);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
