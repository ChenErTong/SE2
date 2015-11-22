package businesslogic.record;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.recordblservice.RecordBLService;
import vo.BussinessConditionVO;
import vo.DebitAndPayBillVO;

public class RecordController implements RecordBLService{
    Record  RecordBL;
		
	@Override
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordBL.bussinessProcess(begin, end);
	}

	@Override
	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordBL.bussinessCondition(end);
	}

	@Override
	public double income(String end) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordBL.income(end);
	}

	@Override
	public double earning(String end) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordBL.expense(end);
	}

	@Override
	public double expense(String end) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordBL.expense(end);
	}

}
