package businesslogic.fundbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.DebitAndPayBillShowService;
import vo.receiptvo.DebitAndPayBillVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:42
 */
public class DebitAndPayBillShowController implements DebitAndPayBillShowService {

	DebitAndPayBillShow showBL = new DebitAndPayBillShow();
	@Override
	public ArrayList<DebitAndPayBillVO> showPay() {
		try {
			return showBL.showPay();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpense() {
		try {
			return showBL.showExpense();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayApproving() {
		try {
			return showBL.showPayApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() {
		try {
			return showBL.showExpenseApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayPass() {
		try {
			return showBL.showPayPass();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpensePass() {
		try {
			return showBL.showExpensePass();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayFailure() {
		try {
			return showBL.showPayFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() {
		try {
			return showBL.showExpenseFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayDraft() {
		try {
			return showBL.showPayDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() {
		try {
			return showBL.showExpenseDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showList(String end) {
		try {
			return showBL.showList(end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
