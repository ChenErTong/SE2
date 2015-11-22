package dataservice.openingstockdataservice;

import java.rmi.RemoteException;

import po.OpeningStockPO;

public class OpeningStockDataService_Driver {
	private OpeningStockPO po;
	public OpeningStockDataService_Driver(){
	po = new OpeningStockPO("123", "2015/10/25", po.getOrganizations(), po.getAccounts(), po.getFacilities(), po.getInventories());
	
	}
	public void drive(OpeningStockDataService service) throws RemoteException{
		service.init();
		service.add(po);
		service.findOpeningStock(po.getID());
		
	}
	public static void main(String args[]) throws RemoteException{
		OpeningStockDataService_Driver driver = new OpeningStockDataService_Driver();
		OpeningStockDataService stub = new OpeningStockDataService_Stub();
		driver.drive(stub);
	}
}
