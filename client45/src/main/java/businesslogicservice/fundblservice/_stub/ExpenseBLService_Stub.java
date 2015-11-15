package businesslogicservice.fundblservice._stub;

import java.util.ArrayList;



import state.ConfirmState;
import state.ResultMessage;
import vo.ExpenseVO;
import businesslogicservice.fundblservice.ExpenseBLService;

public class ExpenseBLService_Stub implements ExpenseBLService{

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("Please confirm your operations!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public String getID() {
		System.out.println("Please offer an available ID for the new Expense!");
		return "123";
	}

	@Override
	public ArrayList<ExpenseVO> show() {
		System.out.println("Please show all the expense!");
		return new ArrayList<ExpenseVO>(){};
	}

	@Override
	public ResultMessage add(ExpenseVO vo) {
		System.out.println("Add a new expense!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete an expense!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(ExpenseVO vo) {
		System.out.println("Modify an expense!");
		return ResultMessage.SUCCESS;
	}

}
