package dataservice.openingstockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OpeningStockPO;
import state.ResultMessage;

public class OpeningStockDataService_Stub implements OpeningStockDataService{
	private OpeningStockPO openingStockPO;
	public OpeningStockDataService_Stub(){
		openingStockPO = null;
//				new OpeningStockPO("123", "2015/10/25", openingStockPO.getOrganizations(),  openingStockPO.getAccounts(),openingStockPO.getFacilities(), openingStockPO.getInventories());
	}

	@Override
	public ResultMessage add(OpeningStockPO po) {
		System.out.println("Add a new openingstockpo succeed!");
		return ResultMessage.SUCCESS;
	}


	@Override
	public OpeningStockPO findOpeningStock(String id) {
		System.out.println("Find the openingstockpo accroding to the id succeed!");
		return openingStockPO;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OpeningStockPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
