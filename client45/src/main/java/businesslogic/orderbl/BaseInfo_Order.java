package businesslogic.orderbl;

import java.rmi.RemoteException;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:31
 */
public interface BaseInfo_Order {
	/**
	 * 计算获得单次订单的预计到达日期
	 * @author Ann
	 * @param cityFrom 起始城市
	 * @param cityTo 到达城市
	 * @param begindate 开始运送日期
	 * @param transSpeed 运送速度常数
	 * @return 预计到达日期
	 * @throws RemoteException
	 */
	public String getArrialDateByCities(String cityFrom,String cityTo,String begindate,double transSpeed) throws RemoteException;
	public double getArrialPriceByCities(String cityFrom,String cityTo,double weight,double priceConstant) throws RemoteException;
}
