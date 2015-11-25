package fund;

import org.junit.Test;

import businesslogic.fundbl.Expense;
import vo.receiptvo.ExpenseVO;

public class TestExpense {

	@Test
	public void testExpense() {
		Expense expense = new Expense();
		ExpenseVO expenseVO = new ExpenseVO("CCC123", "NanjingNan", 98.676767, "NanjingHHHHHH");
		expense.add(expenseVO);
		expense.update(expenseVO);
		expense.delete(expenseVO.getID());
		
	}

}
