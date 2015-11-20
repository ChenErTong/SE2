package businesslogicservice.recordblservice;


import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BussinessConditionVO;
import vo.BussinessProcessVO;
import vo.DebitAndPayBillVO;
     /** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface RecordBLService {
/**统计经营情况表成本收益表**/
	/**符合条件的所有入款单和收款单
	 * @throws RemoteException **/
	public  ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException;
	/**成本收益表数据**/
	public  BussinessConditionVO bussinessCondition(String end) throws RemoteException;
	/**计算得到的收入**/
	public   double income(String  end) throws RemoteException;
	/**计算得到的利润**/
	public   double earning(String  end) throws RemoteException;
	/**计算得到的支出**/
	public   double expense(String  end) throws RemoteException;
}
