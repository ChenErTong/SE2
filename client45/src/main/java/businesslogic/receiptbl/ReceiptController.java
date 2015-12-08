package businesslogic.receiptbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.receiptblservice.ReceiptBLService;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:54
 */
public class ReceiptController implements ReceiptBLService {
	Receipt ReceiptBL = new Receipt();

	@Override
	public ResultMessage updateReceipt(ReceiptVO receiptVO) throws RemoteException {
		try {
			return ReceiptBL.updateReceipt(receiptVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException {
		try {
			return ReceiptBL.passReceipt(VOs);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException {
		try {
			return ReceiptBL.dontPassReceipt(VOs);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public <T extends ReceiptVO> ArrayList<T> show(ReceiptType type, ReceiptState state) throws RemoteException {
		try {
			return ReceiptBL.show(type, state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
