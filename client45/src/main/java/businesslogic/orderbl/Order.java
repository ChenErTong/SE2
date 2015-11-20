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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage costAndTime(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

}
