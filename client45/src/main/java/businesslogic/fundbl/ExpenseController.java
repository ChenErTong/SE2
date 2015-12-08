package businesslogic.fundbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.ExpenseBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.receiptvo.ExpenseVO;

/**
 * 此类禁止用，用了给组里说
 * 
 * @author Ann
 *
 */
@Deprecated
public class ExpenseController implements ExpenseBLService {
	Expense ExpenseBL = new Expense();

	@Override
	public ConfirmState confirmOperation() {
		return ExpenseBL.confirmOperation();
	}

	@Override
	public String getID() {
		try {
			return ExpenseBL.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ExpenseVO> show() {
		try {
			return ExpenseBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage add(ExpenseVO vo) {
		return ExpenseBL.add(vo);
	}

	@Override
	public ResultMessage delete(String ID) {
		return ExpenseBL.delete(ID);
	}

	@Override
	public ResultMessage update(ExpenseVO vo) {
		return ExpenseBL.update(vo);
	}

}
