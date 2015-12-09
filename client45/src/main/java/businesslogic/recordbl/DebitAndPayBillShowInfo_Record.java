package businesslogic.recordbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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
	/**
	 * 获得成本收益表
	 * 
	 * @param startDate
	 *            String型，开始日期
	 * @param endDate
	 *            String型，结束日期
	 * @return ArrayList<DebitAndPayBillVO>型，收款单和付款单立标
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<DebitAndPayBillVO> getBusinessProcess(String startDate, String endDate) throws RemoteException;

	/**
	 * 获得经营情况表
	 * 
	 * @param endDate
	 *            String型，结束日期
	 * @return BussinessConditionVO型，经营情况表
	 * @throws RemoteException
	 *             远程异常
	 */
	public BussinessConditionVO getBussinessCondition(String endDate) throws RemoteException;

	/**
	 * 获得某营业厅单日的收款单
	 * 
	 * @param branch
	 *            String型，营业厅编号
	 * @param date
	 *            String型，日期
	 * @return BussinessOneDayVO型，单日收款单列表对象
	 * @throws RemoteException
	 *             远程异常
	 * @throws NotBoundException
	 * @throws MalformedURLException
	 */
	public BussinessOneDayVO getBussinessOneDayIncome(String branch, String date) throws RemoteException;
}
