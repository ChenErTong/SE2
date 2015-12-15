package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.DebitAndPayBillShowService;
import state.ReceiptState;
import state.ReceiptType;
import vo.receiptvo.DebitAndPayBillVO;

/**
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:42
 */
public class DebitAndPayBillShowController implements DebitAndPayBillShowService {

	DebitAndPayBillShow showBL;

	public DebitAndPayBillShowController() throws MalformedURLException, RemoteException, NotBoundException {
		showBL = new DebitAndPayBillShow();
	}

	/**
	 * @see DebitAndPayBillShowService#showPay()
	 */
	public ArrayList<DebitAndPayBillVO> showPay() throws RemoteException {
		return showBL.showPay();
	}

	/**
	 * @see DebitAndPayBillShowService#showExpense()
	 */
	public ArrayList<DebitAndPayBillVO> showExpense() throws RemoteException {
		return showBL.showExpense();
	}

	/**
	 * @see DebitAndPayBillShowService#showPayApproving()
	 */
	public ArrayList<DebitAndPayBillVO> showPayApproving() throws RemoteException {
		return showBL.showPayApproving();
	}

	/**
	 * @see DebitAndPayBillShowService#showExpenseApproving()
	 */
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() throws RemoteException {
		return showBL.showExpenseApproving();
	}

	/**
	 * @see DebitAndPayBillShowService#showPayPass()
	 */
	public ArrayList<DebitAndPayBillVO> showPayPass() throws RemoteException {
		return showBL.showPayPass();
	}

	/**
	 * @see DebitAndPayBillShowService#showExpensePass()
	 */
	public ArrayList<DebitAndPayBillVO> showExpensePass() throws RemoteException {
		return showBL.showExpensePass();
	}

	/**
	 * @see DebitAndPayBillShowService#showPayFailure()
	 */
	public ArrayList<DebitAndPayBillVO> showPayFailure() throws RemoteException {
		try {
			return showBL.showPayFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see DebitAndPayBillShowService#showExpenseFailure()
	 */
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() throws RemoteException {
		try {
			return showBL.showExpenseFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see DebitAndPayBillShowService#showPayDraft()
	 */
	public ArrayList<DebitAndPayBillVO> showPayDraft() throws RemoteException {
		return showBL.showPayDraft();
	}

	/**
	 * @see DebitAndPayBillShowService#showExpenseDraft()
	 */
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() throws RemoteException {
		return showBL.showExpenseDraft();
	}

	/**
	 * @see DebitAndPayBillShowService#showList(String)
	 */
	public ArrayList<DebitAndPayBillVO> showList(String end) throws RemoteException {
		return showBL.showList(end);
	}

	@Override
	public <T extends DebitAndPayBillVO> ArrayList<T> show(ReceiptType type, ReceiptState state)
			throws RemoteException {
		return showBL.show(type, state);
	}

}
