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
		poList=new SerSaveAndLoad<OrderPO>("data/"+NAME+".ser");
	}

	@Override
	public void initialFile() {
		// TODO Auto-generated method stub
		
	}

}
