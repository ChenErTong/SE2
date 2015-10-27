package businesslogicservice.orderblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
import businesslogicservice.BLService;

/**
 * 实现订单管理界面所需要的服务
 * @author czw
 * @version Oct 22,2015
 */
public interface OrderBLService extends BLService{
	/**
	 * 系统存储输入commodities和order
	 * 自动计算运送总价和预计到达日期
	 * 生成orderNumber（订单号）
	 * 并更新OrderPO的信息
	 * @return
	 * @param commmodities 货物集合
	 * @param order 订单
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities, OrderVO order);
	
	/**
	 * 根据输入的orderNumber查找相应的订单物流信息并返回
	 * @return 订单界面显示
	 * @param orderNumber 订单号
	 * @param senderName 寄件人姓名
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public OrderVO inquireOrder(String orderNumber, String senderName);
	
	/**
	 * 计算订单运费和预估到达时间
	 * @return
	 * @param order 订单数据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage costAndTime(OrderVO order);
}