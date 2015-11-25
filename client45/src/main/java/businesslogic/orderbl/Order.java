package businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class Order{
	private OrderDataService orderData;

	public Order() {
		try {
			orderData = (OrderDataService) Naming
					.lookup(RMIConfig.PREFIX + OrderDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}


	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities, OrderVO order) {
		try {
			return orderData.add(OrderTrans.convertVOtoPO(commmodities, order));
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

	
	public ResultMessage costAndTime(OrderVO order) {
		//TODO 之后再搞，不知道返回什么
		return ResultMessage.SUCCESS;
	}

}
