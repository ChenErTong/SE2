package businesslogic.fundbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.DebitAndPayBillBLService;
import po.receiptpo.DebitAndPayBillPO;
import state.PayBillItem;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.DebitAndPayBillVO;

public class DebitAndPayBillController implements DebitAndPayBillBLService{
    DebitAndPayBill DebitAndPayBL = new DebitAndPayBill();
	@Override
	public String getPayID() {
		try {
			return DebitAndPayBL.getPayID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getExpenseID() {
		try {
			return DebitAndPayBL.getExpenseID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DebitAndPayBillVO find(String ID) {
		try {
			return DebitAndPayBL.find(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ResultMessage addDebitBill(double money, String courierID, ReceiptType type, ArrayList<String> orderNumbers) {
		try {
			return DebitAndPayBL.addDebitBill(money, courierID, type, orderNumbers);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ResultMessage addPayBill(double money, String payerName, String accountID, ReceiptType type,
			PayBillItem items, String transferReceiptID) {
		try {
			return DebitAndPayBL.addPayBill(money, payerName, accountID, type, items, transferReceiptID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ResultMessage submit(DebitAndPayBillPO po) {
		try {
			return DebitAndPayBL.submit(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage save(DebitAndPayBillPO po) {
		try {
			return DebitAndPayBL.save(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateDraft(DebitAndPayBillPO po) {
		try {
			return DebitAndPayBL.updateDraft(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPay() {
		try {
			return DebitAndPayBL.showPay();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpense() {
		try {
			return DebitAndPayBL.showExpense();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayApproving() {
		try {
			return DebitAndPayBL.showPayApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() {
		try {
			return DebitAndPayBL.showExpenseApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayPass() {
		try {
			return DebitAndPayBL.showPayPass();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpensePass() {
		try {
			return DebitAndPayBL.showExpensePass();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayFailure() {
		try {
			return DebitAndPayBL.showPayFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() {
		try {
			return DebitAndPayBL.showExpenseFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayDraft() {
		try {
			return DebitAndPayBL.showPayDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() {
		try {
			return DebitAndPayBL.showExpenseDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
