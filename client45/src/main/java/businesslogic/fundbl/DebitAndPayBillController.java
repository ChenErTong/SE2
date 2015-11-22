package businesslogic.fundbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import businesslogicservice.fundblservice.DebitAndPayBillBLService;
import po.BankAccountPO;
import po.receiptpo.DebitAndPayBillPO;
import state.PayBillItem;
import state.ReceiptType;
import state.ResultMessage;
import vo.DebitAndPayBillVO;

public class DebitAndPayBillController implements DebitAndPayBillBLService{
    DebitAndPayBill DebitAndPayBL;
	@Override
	public String getPayID() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.getPayID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getExpenseID() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.getExpenseID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DebitAndPayBillVO find(String ID) {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.find(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public HashMap<String, String> getAllBankAccounts() {
		// TODO Auto-generated method stub
		return DebitAndPayBL.getAllBankAccounts();
	}

	@Override
	public ResultMessage addDebitBill(double money, String courierID, ReceiptType type, ArrayList orderNumbers) {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.addDebitBill(money, courierID, type, orderNumbers);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addPayBill(double money, String payerName, ArrayList<BankAccountPO> bankAccouts,
			ReceiptType type, String rentYear, String salaryMonth, PayBillItem items, ArrayList transListNumber){
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.addPayBill(money, payerName, bankAccouts, type, rentYear, salaryMonth, items, transListNumber);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submit(DebitAndPayBillPO po) {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.submit(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage save(DebitAndPayBillPO po) {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.save(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateDraft(DebitAndPayBillPO po) {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.updateDraft(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPay() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showPay();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpense() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showExpense();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayApproving() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showPayApproving();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showExpenseApproving();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayPass() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showPayPass();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpensePass() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showExpensePass();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayFailure() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showPayFailure();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showExpenseFailure();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayDraft() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showPayDraft();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() {
		// TODO Auto-generated method stub
		try {
			return DebitAndPayBL.showExpenseDraft();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
