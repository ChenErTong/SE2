package dataservice.funddataservice._Driver;

import po.ExpensePO;
import dataservice.funddataservice.ExpenseDataService;
import dataservice.funddataservice._stub.ExpenseDataService_Stub;

public class ExpenseDataService_Driver {
	private ExpensePO po = new ExpensePO("123","NJWU",6800,"MB");
	public void drive(ExpenseDataService expenseDataService){
		expenseDataService.show(po.getID());
		expenseDataService.insert(po);
		expenseDataService.delete(po.getID());
		expenseDataService.update(po);
	
	}
	public static void main(String args[]){
		ExpenseDataService_Driver driver = new ExpenseDataService_Driver();
		ExpenseDataService stub = new ExpenseDataService_Stub();
		driver.drive(stub);
	}
}
