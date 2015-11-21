package businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.orderblservice.OrderBLService;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class Order implements OrderBLService {
	private OrderDataService orderData;

	public Order() {
		try {
			orderData = (OrderDataService) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + OrderDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities, OrderVO order) {
		try {
			return orderData.add(OrderPO.convertVOtoPO(commmodities, order));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		OrderPO po=null;
		try {
			po = orderData.find(orderNumber);
			OrderVO vo = OrderVO.convertPOtoVO(po);
			System.out.println("找到了响应的PO");
			if(vo.getSenderName().equals(senderName)){
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

	@Override
	public ResultMessage costAndTime(OrderVO order) {
		//TODO 之后再搞，不知道返回什么
		return ResultMessage.SUCCESS;
	}

}
