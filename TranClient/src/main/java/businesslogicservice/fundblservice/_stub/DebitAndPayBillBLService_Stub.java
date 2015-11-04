package businesslogicservice.fundblservice._stub;

import java.util.ArrayList;
import java.util.HashMap;

import state.ResultMessage;
import vo.DebitAndPayBillVO;
import businesslogicservice.fundblservice.DebitAndPayBillBLService;

public class DebitAndPayBillBLService_Stub implements DebitAndPayBillBLService{

	@Override
	public String getPayID() {
		System.out.println("Give a new ID to the payreceipt!");
		return "123";
	}

	@Override
	public String getExpenseID() {
		System.out.println("Give a new ID to the expensereceipt!");
		return "123";
	}

	@Override
	public DebitAndPayBillVO find(String ID) {
		System.out.println("Find the debit or pay bill according to the id");
		return new DebitAndPayBillVO(ID, 0, ID, null, null, ID, ID, null, null);
	}

	@Override
	public HashMap<String, String> getAllBankAccounts() {
		System.out.println("Show all BankAccounts!");
		return new HashMap<String,String>(){};
	}

	@Override
	public ResultMessage addDebitAndPayBill(String operatorID, String operatorName) {
		System.out.println("Add a new debitbill or paybill");
		return  ResultMessage.SUCCESS;
		
		
	}

	@Override
	public DebitAndPayBillVO submit() {
		System.out.println("Submit the bill");
		return new DebitAndPayBillVO(null, 0, null, null, null, null, null, null, null);
	}

	@Override
	public DebitAndPayBillVO save() {
		System.out.println("Save the bill");
		return new DebitAndPayBillVO(null, 0, null, null, null, null, null, null, null);
	}

	@Override
	public ResultMessage updateDraft(DebitAndPayBillVO vo) {
		System.out.println("Modify the draft");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage submitDraft(String ID) {
		System.out.println("Submit the draft");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPay() {
		System.out.println("Show the all PayBills");	
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpense() {
		System.out.println("Show the all expenseBills");
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayApproving() {
		System.out.println("Show the approving paybills");
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() {
		System.out.println("Show the approving expensebills");
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayPass() {
		System.out.println("Show the pss paybills");
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpensePass() {
		System.out.println("Show the pass expensebills");
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayFailure() {
		System.out.println("Show the failed paybills");
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() {
		System.out.println("Show the failed expensebills");
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayDraft() {
		System.out.println("Show the draft paybills");
		return new ArrayList<DebitAndPayBillVO>(){};
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() {
		System.out.println("Show the draft expensebills");
		return new ArrayList<DebitAndPayBillVO>(){};

}

}