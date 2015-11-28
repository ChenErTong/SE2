package businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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


	public ResultMessage addOrder(OrderVO order) {
		try {
			return orderData.add(OrderTrans.convertVOtoPO(order));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
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

	
	public String getOrderId() {
		return null;
	}

	public double getCost(CommodityVO[] commodityList, String senderAddress, String receiverAddress,
			ExpressType expressType) {
		return 0;
	}

	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType) {
		return null;
	}

}
