package businesslogicservice.recordblservice;


import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.BussinessProcessVO;
import vo.receiptvo.DebitAndPayBillVO;
/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:43:42
 */
public interface RecordBLService {
/**统计经营情况表成本收益表**/
	/**符合条件的所有入款单和收款单
	 * @throws RemoteException **/
	public  ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException ;
	/**成本收益表数据**/
	public  BussinessConditionVO bussinessCondition(String end) throws RemoteException ;
	
	 public BussinessOneDayVO bussinessOneDay(String WorkPlace, String date) throws RemoteException;
	 
	 public void exportBussinessProcessToExcel(BussinessProcessVO vo,String fileDirectoryPath);
	
	 public void exportBussinessConditionToExcel(BussinessConditionVO vo,String fileDirectoryPath);
}
