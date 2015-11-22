package businesslogic.fundbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.ExpenseBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.ExpenseVO;

public class ExpenseController implements ExpenseBLService{
    Expense ExpenseBL;
	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return ExpenseBL.confirmOperation();
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		try {
			return ExpenseBL.getID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ExpenseVO> show() {
		// TODO Auto-generated method stub
		try {
			return ExpenseBL.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage add(ExpenseVO vo) {
		// TODO Auto-generated method stub
		return ExpenseBL.add(vo);
	}

	@Override
	public ResultMessage delete(String ID) {
		// TODO Auto-generated method stub
		return ExpenseBL.delete(ID);
	}

	@Override
	public ResultMessage update(ExpenseVO vo) {
		// TODO Auto-generated method stub
		return ExpenseBL.update(vo);
	}

}
