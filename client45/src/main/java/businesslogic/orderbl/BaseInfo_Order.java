package businesslogic.orderbl;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import state.ExpressType;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:31
 */
public interface BaseInfo_Order {
	/**
	 * 计算获得单次订单的预计到达日期
	 * 
	 * @author Ann
	 * @param cityFrom
	 *            起始城市
	 * @param cityTo
	 *            到达城市
	 * @param begindate
	 *            开始运送日期
	 * @param transSpeed
	 *            运送速度常数
	 * @return String型，预计到达日期，日期格式为yyyy-MM-dd
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getArrialDateByCities(String cityFrom, String cityTo, String begindate, BigDecimal transSpeed)
			throws RemoteException;

	/**
	 * 计算获得单次订单的金额
	 * 
	 * @see ExpressType#priceConstant 成本比例常数
	 * @param cityFrom
	 *            起始城市
	 * @param cityTo
	 *            到达城市
	 * @param weight
	 *            订单总重
	 * @param priceConstant
	 *            成本比例常数
	 * @return double型，计算获得单次订单的金额
	 * @throws RemoteException
	 *             远程异常
	 */
	public BigDecimal getArrialPriceByCities(String cityFrom, String cityTo, BigDecimal weight,
			BigDecimal priceConstant) throws RemoteException;
}
