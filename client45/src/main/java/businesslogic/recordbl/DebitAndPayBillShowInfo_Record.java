package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BussinessConditionVO;
import vo.receiptvo.DebitAndPayBillVO;

public interface DebitAndPayBillShowInfo_Record {
	public ArrayList<DebitAndPayBillVO> getBusinessProcess(String startDate,String endDate) throws RemoteException;
	public BussinessConditionVO getBussinessCondition(String endDate) throws RemoteException;
}
