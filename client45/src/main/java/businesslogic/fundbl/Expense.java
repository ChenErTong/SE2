package businesslogic.fundbl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.funddataservice.ExpenseDataService;
import po.ExpensePO;
import state.ConfirmState;
import state.ResultMessage;
import vo.receiptvo.ExpenseVO;
@Deprecated
public class Expense {

	private ExpenseDataService expenseData;
	public Expense() {
		try {
			expenseData = (ExpenseDataService)Naming.lookup(RMIConfig.PREFIX+ExpenseDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	
	public String getID() throws RemoteException {
		return expenseData.getID();
	}

	
	public ArrayList<ExpenseVO> show() throws RemoteException {
		ArrayList<ExpensePO> pos=expenseData.find();
		ArrayList<ExpenseVO> vos=FundTrans.convertExpensePOstoVOs(pos);
		return vos;
	}
	
    
	
	public ResultMessage add(ExpenseVO vo) {
		ExpensePO expensePO = FundTrans.convertVOtoPO(vo);
		try {
			return expenseData.add(expensePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	
	public ResultMessage delete(String ID) {
		return null;
//			expenseData.delete(ID);
	}

	
	public ResultMessage update(ExpenseVO vo) {
//		ExpensePO expensePO = FundTrans.convertVOtoPO(vo);
//		try {
//			return expenseData.modify(expensePO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
		return ResultMessage.FAIL;
	}

}
