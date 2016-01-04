package businesslogicservice.orderblservice;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import businesslogicservice.BLService;
import state.ExpressType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

/**
 * 实现订单管理界面所需要的服务
 * 
 * @author czw
 * @author Ann
 * @version Oct 22,2015
 */
public interface OrderBLService extends BLService {
	/**
	 * 系统存储输入commodities和order 自动计算运送总价和预计到达日期 生成orderNumber（订单号） 并更新OrderPO的信息
	 * 
	 * @return
	 * @param commmodities
	 *            货物集合
	 * @param order
	 *            订单
	 * @author czw
	 * @version Oct 22,2015
	 */
	public ResultMessage addOrder(OrderVO order) throws RemoteException;

	public ResultMessage addOrder(CommodityVO[] commmodities, OrderVO order) throws RemoteException;

	/**
	 * 根据输入的orderNumber查找相应的订单物流信息并返回
	 * 
	 * @return 订单界面显示
	 * @param orderNumber
	 *            订单号
	 * @param senderName
	 *            寄件人姓名
	 * @author czw
	 * @version Oct 22,2015
	 */
	public OrderVO inquireOrder(String orderNumber, String senderName) throws RemoteException;

	/**
	 * 根据输入的orderNumber查找相应的订单物流信息并返回，供内部人员使用
	 * 
	 * @param orderNumber
	 *            订单号
	 * @return
	 */
	public OrderVO inquireOrder(String orderNumber) throws RemoteException;

	public ResultMessage updateOrder(OrderVO order) throws RemoteException;
	/**
	 * 计算订单运费和预估到达时间
	 * 
	 * @return
	 * @param order
	 *            订单数据
	 * @author czw
	 * @version Oct 22,2015
	 */
	// public ResultMessage costAndTime(OrderVO order);

	/**
	 * 自动生成订单号，不与已有的订单号重复
	 * 
	 * @return
	 * @author czw
	 */
	public String getOrderId() throws RemoteException;

	/**
	 * 根据订单信息生成运费
	 * 
	 * @return 运费
	 * @author czw
	 * @param expressType
	 *            快递类型（飞机、火车、汽车）
	 * @param receiverAddress
	 *            目的地（省+空格+市+空格+详细地址）
	 * @param senderAddress
	 *            始发地（省+空格+市+空格+详细地址）
	 * @param commodityList
	 *            货物数组，每个货物都有自己的重量
	 */
	public BigDecimal getCost(CommodityVO[] commodityList, String senderAddress, String receiverAddress,
			ExpressType expressType) throws RemoteException;

	/**
	 * @param senderAddress
	 *            始发地（省+空格+市+空格+详细地址）
	 * @param receiverAddress
	 *            目的地（省+空格+市+空格+详细地址）
	 * @param expressType
	 *            快递类型（飞机、火车、汽车）
	 * @return 日期（以字符串的形式，格式为yyyy-MM-dd）
	 */
	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType,
			String beginDate) throws RemoteException;
	
}