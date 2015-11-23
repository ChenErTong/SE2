package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import businesslogicservice.fundblservice.DebitAndPayBillBLService;
import dataservice.funddataservice.BankAccountDataService;
import dataservice.funddataservice.DebitAndPayBillDataService;
import state.ResultMessage;
import vo.DebitAndPayBillVO;

public class DebitAndPayBill implements DebitAndPayBillBLService {
	private DebitAndPayBillDataService debitAndPayBillData;

	public DebitAndPayBill() {
		try {
			debitAndPayBillData = (DebitAndPayBillDataService) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + DebitAndPayBillDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPayID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExpenseID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DebitAndPayBillVO find(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addDebitAndPayBill(String operatorID, String operatorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DebitAndPayBillVO submit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DebitAndPayBillVO save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateDraft(DebitAndPayBillVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submitDraft(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpense() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayApproving() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayPass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpensePass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayFailure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayDraft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() {
		// TODO Auto-generated method stub
		return null;
	}

}
