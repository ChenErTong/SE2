package dataservice.funddataservice._stub;

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
		expensePO_1 = new ExpensePO("123", "NJWU", 5800, "“Ù¿÷∞…");
		expensePO_2 = new ExpensePO("456", "PKWU", 4577, "ƒœ√≈");
		
		expensePOs.add(expensePO_1);
		expensePOs.add(expensePO_2);
	}

	@Override
	public ResultMessage insert(ExpensePO po) {
		System.out.println("Insert a expensePO succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a expensePO succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(ExpensePO PO) {
		System.out.println("Modify a expensePO succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ExpensePO> show(String ID) {
		System.out.println("Show all the expensePO");
		return new ArrayList<ExpensePO>();
	}

}
