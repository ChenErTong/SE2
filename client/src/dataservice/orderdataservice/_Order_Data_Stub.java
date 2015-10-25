package dataservice.orderdataservice;

import java.util.ArrayList;

import po.OrderPO;
import state.ResultMessage;
import vo.CommodityVO;

public class _Order_Data_Stub implements OrderDataService<OrderPO> {

	@Override
	public OrderPO find(String ordernumber) {
		if(ordernumber=="00001"){
		OrderPO orderPO = new OrderPO(ordernumber,ordernumber,
				"xiaowang", "Nanjing123", "18888888888", "SoftwareCo",
				"xiaoli", "Nanjing233", "16666666666", "HardwareCo",
				new ArrayList<CommodityVO>(),
				"Nanjing156-Nanjing188" , 
				"2015-10-24", "2015-10-26",6.767);
		return orderPO;
		}else{
			return null;
		}
	}

	@Override
	public ResultMessage insert(OrderPO order) {
		System.out.println("You have insert an order!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(OrderPO order) {
		System.out.println("You have modified an order!");
		return ResultMessage.SUCCESS;
	}

}
