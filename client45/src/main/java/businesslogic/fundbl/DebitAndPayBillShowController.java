package businesslogic.fundbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.DebitAndPayBillShowService;
import vo.receiptvo.DebitAndPayBillVO;

/**
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:42
 */
public class DebitAndPayBillShowController implements DebitAndPayBillShowService {

	DebitAndPayBillShow showBL = new DebitAndPayBillShow();

	@Override
	public ArrayList<DebitAndPayBillVO> showPay() throws RemoteException {
		return showBL.showPay();
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpense() throws RemoteException {
		return showBL.showExpense();
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayApproving() throws RemoteException {
		return showBL.showPayApproving();
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() throws RemoteException {
		return showBL.showExpenseApproving();
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayPass() throws RemoteException {
		return showBL.showPayPass();
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpensePass() throws RemoteException {
		return showBL.showExpensePass();
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayFailure() throws RemoteException {
		try {
			return showBL.showPayFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() throws RemoteException {
		try {
			return showBL.showExpenseFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayDraft() throws RemoteException {
		return showBL.showPayDraft();
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() throws RemoteException {
		return showBL.showExpenseDraft();
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showList(String end) throws RemoteException {
		return showBL.showList(end);
	}

}
