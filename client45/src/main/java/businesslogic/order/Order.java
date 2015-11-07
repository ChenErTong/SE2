package businesslogic.order;

import java.util.ArrayList;

import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
import businesslogicservice.orderblservice.OrderBLService;

public class Order implements OrderBLService{

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
