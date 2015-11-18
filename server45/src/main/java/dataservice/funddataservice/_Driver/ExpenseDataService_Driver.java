package dataservice.funddataservice._Driver;

import po.ExpensePO;

import java.rmi.RemoteException;

import dataservice.funddataservice.ExpenseDataService;
import dataservice.funddataservice._stub.ExpenseDataService_Stub;

public class ExpenseDataService_Driver {
	private ExpensePO po = new ExpensePO("123","NJWU",6800,"MB");
	public void drive(ExpenseDataService expenseDataService) throws RemoteException{
		expenseDataService.show(po.getID());
		expenseDataService.add(po);
		expenseDataService.delete(po.getID());
		expenseDataService.modify(po);
	
	}
	public static void main(String args[]) throws RemoteException{
		ExpenseDataService_Driver driver = new ExpenseDataService_Driver();
		ExpenseDataService stub = new ExpenseDataService_Stub();
		driver.drive(stub);
	}
}
