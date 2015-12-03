package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.receiptvo.DebitAndPayBillVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:13
 */
public interface DebitAndPayBillShowInfo_Record {
	public ArrayList<DebitAndPayBillVO> getBusinessProcess(String startDate,String endDate) throws RemoteException;
	public BussinessConditionVO getBussinessCondition(String endDate) throws RemoteException;
	public BussinessOneDayVO getBussinessOneDayIncome(String branch,String date) throws RemoteException; 
}
