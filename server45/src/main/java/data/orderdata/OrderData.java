package data.orderdata;

import java.rmi.RemoteException;

import config.XMLReader;
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
	}

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<OrderPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
