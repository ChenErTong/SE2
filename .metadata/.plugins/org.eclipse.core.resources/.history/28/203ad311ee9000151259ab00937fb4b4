package businesslogicservice.fundblservice._driver;

import vo.DebitAndPayBillVO;
import businesslogicservice.fundblservice.DebitAndPayBillBLService;
import businesslogicservice.fundblservice._stub.DebitAndPayBillBLService_Stub;

public class DebitAndPayBillBLService_Driver {
	DebitAndPayBillVO vo = new DebitAndPayBillVO(null, 0, null, null, null, null, null, null, null);
	public void drive(DebitAndPayBillBLService service){
		service.addDebitAndPayBill(vo.getCourierID(), vo.getPayerName());
		service.getPayID();
		service.getExpenseID();
		service.getAllBankAccounts();
		service.showExpense();
		service.showExpenseApproving();
		service.showExpenseDraft();
		service.showExpenseFailure();
		service.showExpensePass();
		service.showPay();
		service.showPayApproving();
		service.showPayDraft();
		service.showPayFailure();
		service.showPayPass();
		service.updateDraft(vo);
		service.submit();
		service.submitDraft(vo.getID());
		service.save();
		
	}
	public static void main(String args[]){
		DebitAndPayBillBLService_Driver driver = new DebitAndPayBillBLService_Driver();
		DebitAndPayBillBLService stub = new DebitAndPayBillBLService_Stub();
		driver.drive(stub);
	}
}
