package businesslogicservice.fundblservice._driver;

import vo.ExpenseVO;
import businesslogicservice.fundblservice.ExpenseBLService;
import businesslogicservice.fundblservice._stub.ExpenseBLService_Stub;

public class ExpenseBLService_Driver {
	ExpenseVO vo = new ExpenseVO(null, null, 0, null);
	public void driver(ExpenseBLService service){
		service.getID();
		service.add(vo);
		service.confirmOperation();
		service.delete(null);
		
		service.update(vo);
		
	}
	
	public static void main(String args[]){
		ExpenseBLService_Driver driver = new ExpenseBLService_Driver();
		ExpenseBLService stub = new ExpenseBLService_Stub();
		driver.driver(stub);
	}
}
