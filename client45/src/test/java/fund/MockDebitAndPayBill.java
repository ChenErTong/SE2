package fund;

import java.util.ArrayList;
import java.util.HashMap;

import businesslogic.fund.DebitAndPayBill;
import state.ReceiptType;
import vo.DebitAndPayBillVO;

public class MockDebitAndPayBill extends DebitAndPayBill{
	private String payID;
	private String ExpenseID;
	private DebitAndPayBillVO debitAndPayBillVO;
	private HashMap<String, String> bankAccounts;
	
	public MockDebitAndPayBill(String payID, String ExpenseID, HashMap<String, String> bankAccounts) {
		this.payID = payID;
		this.ExpenseID = ExpenseID;
		this.bankAccounts = bankAccounts;
	}

	public String getPayID() {
		return payID;
	}

	public String getExpenseID() {
		return ExpenseID;
	}

	public void findDebitAndPayBillVO(String ID){
		debitAndPayBillVO = new DebitAndPayBillVO(ID, 9980.56, "xiaoli",ReceiptType.PAY, new ArrayList<>());
	}
	
	public HashMap<String, String> getAllBankAccounts() {
		return bankAccounts;
	}

	public DebitAndPayBillVO getDebitAndPayBillVO() {
		return debitAndPayBillVO;
	}
	
}
