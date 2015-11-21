package dataservice.funddataservice._stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ExpensePO;
import state.ResultMessage;
import dataservice.funddataservice.ExpenseDataService;

public class ExpenseDataService_Stub implements ExpenseDataService{
	
	private ArrayList<ExpensePO> expensePOs;
	private ExpensePO expensePO_1;
	private ExpensePO expensePO_2;
	
	public ExpenseDataService_Stub(){
		expensePOs = new ArrayList<ExpensePO>();
		expensePO_1 = new ExpensePO("123", "NJWU", 5800, "FUCK");
		expensePO_2 = new ExpensePO("456", "PKWU", 4577, "LUANMA");
		
		expensePOs.add(expensePO_1);
		expensePOs.add(expensePO_2);
	}

	@Override
	public ResultMessage add(ExpensePO po) {
		System.out.println("Insert a expensePO succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a expensePO succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(ExpensePO PO) {
		System.out.println("Modify a expensePO succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ExpensePO> find() {
		System.out.println("Show all the expensePO");
		return new ArrayList<ExpensePO>();
	}



}
