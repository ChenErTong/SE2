package businesslogic.orderbl;

import java.util.ArrayList;

import businesslogicservice.orderblservice.OrderBLService;
import dataservice.orderdataservice.OrderDataService;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class Order implements OrderBLService{
	private OrderDataService orderData;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities,
			OrderVO order) {
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
