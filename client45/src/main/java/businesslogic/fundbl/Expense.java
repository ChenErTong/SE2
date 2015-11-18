package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.ExpenseBLService;
import dataservice.facilitydataservice.FacilityDataService;
import dataservice.funddataservice.ExpenseDataService;
import state.ConfirmState;
import state.ResultMessage;
import vo.ExpenseVO;

public class Expense implements ExpenseBLService{

	private ExpenseDataService expenseData;
	public Expense() {
		try {
			expenseData = (ExpenseDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+ExpenseDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ExpenseVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(ExpenseVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(ExpenseVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
