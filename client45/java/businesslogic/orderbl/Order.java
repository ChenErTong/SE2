package businesslogic.orderbl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.basebl.BaseInfo;
import config.RMIConfig;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import state.ConfirmState;
import state.ExpressType;
import state.OrderState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:35
 */
public class Order {
	private OrderDataService orderData;
	private BaseInfo_Order baseInfo;

	public Order() throws MalformedURLException, RemoteException, NotBoundException {
		orderData = getOrderData();
		baseInfo = new BaseInfo();
	}

	public OrderDataService getOrderData() throws MalformedURLException, RemoteException, NotBoundException {
		return (OrderDataService) Naming.lookup(RMIConfig.PREFIX + OrderDataService.NAME);
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ResultMessage addOrder(OrderVO order) throws RemoteException {
		OrderPO po = OrderTrans.convertVOtoPO(order);
		po.setOrderstate(OrderState.TO_BE_EXPORTED);
		return orderData.add(po);
	}

	/**
	 * 查找订单
	 * 
	 * 需要进行验证 即如果寄件人姓名和订单中保存的寄件人姓名相符 才返回相应的订单信息
	 * 
	 * @param orderNumber
	 *            String型，订单编号
	 * @param senderName
	 *            String型，寄件人姓名
	 * @return OrderVO型，订单值对象
	 */
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		OrderPO po = null;
		try {
			po = orderData.find(orderNumber);
			OrderVO vo = OrderTrans.convertPOtoVO(po);
			System.out.println("找到了响应的PO");
			if (vo.senderName.equals(senderName)) {
				// 名字正确，返回
				return vo;
			} else {
				// 名字不正确，返回空
				return null;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			// 没有相应的PO
			System.out.println("Order中打印：没有相应的PO");
		}
		return null;
	}

	public String getOrderId() throws RemoteException {
		return orderData.getID();
	}

	/**
	 * 获取订单价格
	 * 
	 * @see BaseInfo_Order#getArrialPriceByCities(String, String, BigDecimal,
	 *      BigDecimal)
	 * @param commodityList
	 *            CommodityVO[]型，商品列表
	 * @param senderAddress
	 *            String型，寄件人地址
	 * @param receiverAddress
	 *            String型，收件人地址
	 * @param expressType
	 *            ExpressType型，运送类型
	 * @return BigDecimal型，价格
	 * @throws RemoteException
	 *             远程异常
	 */
	public BigDecimal getCost(CommodityVO[] commodityList, String senderAddress, String receiverAddress,
			ExpressType expressType) throws RemoteException {
		// 获取运送订单的总重量
		BigDecimal weight = new BigDecimal(0);
		for (CommodityVO commodityVO : commodityList) {
			weight = weight.add(commodityVO.weight);
		}
		// 获取运送类型的价格常量
		BigDecimal priceConstant = expressType.priceConstant;
		return baseInfo.getArrialPriceByCities(senderAddress, receiverAddress, weight, priceConstant);
	}

	/**
	 * 获取订单预计到达日期
	 * 
	 * @see BaseInfo_Order#getArrialDateByCities(String, String, String,
	 *      BigDecimal)
	 * @param senderAddressString
	 *            String型，寄件人地址
	 * @param receiverAddress
	 *            String型，收件人地址
	 * @param expressType
	 *            ExpressType型，运送类型
	 * @param begindate
	 *            String型，发件日期
	 * @return String型，预计到达日期
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType,
			String begindate) throws RemoteException {
		// 获取运送类型的速度
		BigDecimal transSpeed = expressType.speed;
		return baseInfo.getArrialDateByCities(senderAddress, receiverAddress, begindate, transSpeed);
	}

	/**
	 * 添加订单
	 * 
	 * @param commmodities
	 *            CommodityVO[]型，货物列表
	 * @param order
	 *            OrderVO型，订单值对象
	 * @return ResultMessage型，是否添加成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage addOrder(CommodityVO[] commmodities, OrderVO order) throws RemoteException {
		ArrayList<CommodityVO> commos = new ArrayList<>();
		for (CommodityVO commodityVO : commmodities) {
			commos.add(commodityVO);
		}
		order.commodities = commos;
		return this.addOrder(order);
	}

	/**
	 * 获取订单（工作人员使用，不需要进行验证）
	 * 
	 * @param orderNumber
	 *            String型，订单编号
	 * @return OrderVO型，订单值对象
	 * @throws RemoteException
	 *             远程异常
	 */
	public OrderVO inquireOrder(String orderNumber) throws RemoteException {
		OrderPO po = orderData.find(orderNumber);
		return OrderTrans.convertPOtoVO(po);
	}

	public ResultMessage updateOrder(OrderVO order) throws RemoteException {
		OrderPO po = OrderTrans.convertVOtoPO(order);
		return orderData.modify(po)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
	}

}
