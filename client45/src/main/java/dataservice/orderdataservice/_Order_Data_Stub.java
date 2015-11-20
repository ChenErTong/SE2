package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;
import state.ResultMessage;
import vo.CommodityVO;

public class _Order_Data_Stub implements OrderDataService {

	@Override
	public OrderPO find(String ordernumber) {
		System.out.println("Finding the order......");
		if(ordernumber=="00001"){
			System.out.println("You have found an order!");
		OrderPO orderPO = new OrderPO(ordernumber,ordernumber,
				"xiaowang", "Nanjing123", "18888888888", "SoftwareCo",
				"xiaoli", "Nanjing233", "16666666666", "HardwareCo",
				new ArrayList<CommodityVO>(),
				"Nanjing156-Nanjing188" , 
				"2015-10-24", "2015-10-26",6.767);
		return orderPO;
		}else{
			System.out.println("Can not find an order!");
			return null;
		}
	}

	@Override
	public ResultMessage add(OrderPO order) {
		System.out.println("You have insert an order!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(OrderPO order) {
		System.out.println("You have modified an order!");
		return ResultMessage.SUCCESS;
	}


	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
