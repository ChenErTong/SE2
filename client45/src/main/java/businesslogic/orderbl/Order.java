package businesslogic.orderbl;

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
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class Order{
	private OrderDataService orderData;
	private BaseInfo_Order baseInfo = new BaseInfo();
	public Order() {
		orderData=getOrderData();
	}
	
	public OrderDataService getOrderData(){
		try {
			return (OrderDataService) Naming.lookup(RMIConfig.PREFIX + OrderDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}


	public ResultMessage addOrder(OrderVO order) throws RemoteException {
			return orderData.add(OrderTrans.convertVOtoPO(order));
	}


	public OrderVO inquireOrder(String orderNumber, String senderName) {
		OrderPO po=null;
		try {
			po = orderData.find(orderNumber);
			OrderVO vo = OrderTrans.convertPOtoVO(po);
			System.out.println("找到了响应的PO");
			if(vo.senderName.equals(senderName)){
				System.out.println("名字正确，返回");
				return vo;
			}else {
				System.out.println("名字不正确，不返回");
				return null;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Order中打印：没有响应的PO");
		}
		return null;
	}

	
	public String getOrderId() throws RemoteException {
		return orderData.getID();
	}

	public double getCost(CommodityVO[] commodityList, String senderAddress, String receiverAddress,
			ExpressType expressType) throws RemoteException {
		double weight = 0;
		for (CommodityVO commodityVO : commodityList) {
			weight+=commodityVO.weight;
		}
		double priceConstant = expressType.priceConstant;
		return baseInfo.getArrialPriceByCities(senderAddress, receiverAddress, weight, priceConstant);
	}

	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType,String begindate) throws RemoteException {
		double transSpeed = expressType.speed;
		return baseInfo.getArrialDateByCities(senderAddress, receiverAddress, begindate, transSpeed);
	}

	public ResultMessage addOrder(CommodityVO[] commmodities, OrderVO order) throws RemoteException {
		ArrayList<CommodityVO> commos = new ArrayList<>();
		for (CommodityVO commodityVO : commmodities) {
			commos.add(commodityVO);
		}
		order.commodities=commos;
		return this.addOrder(order);
	}
	
	public OrderVO inquireOrder(String orderNumber) throws RemoteException {
		OrderPO po= orderData.find(orderNumber);
		return OrderTrans.convertPOtoVO(po);
	}

}
