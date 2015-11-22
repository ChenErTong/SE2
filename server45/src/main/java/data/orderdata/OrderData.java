package data.orderdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import util.SerSaveAndLoad;

public class OrderData extends ManageData<OrderPO> implements OrderDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderData() throws RemoteException {
		//TODO 什么Name待考虑
		poList=new SerSaveAndLoad<OrderPO>("data/"+NAME+".ser");
	}

}
