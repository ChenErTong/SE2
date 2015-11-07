package dataservice.basedataservice;

import java.rmi.RemoteException;

import po.BasePO;
import state.FindTypeBase;

public class BaseDataService_Driver {
	
	private BasePO po = new BasePO("123", "2015/11/3");
	public void drive(BaseDataService baseDataService) throws RemoteException{
		baseDataService.find(FindTypeBase.PRICE);
		baseDataService.delete("123");
		baseDataService.insert(po);
		baseDataService.update(po);
		
	}
	
	public static void main (String args[]) throws RemoteException{
		BaseDataService_Driver driver = new BaseDataService_Driver();
		BaseDataService stub = new BaseDataService_Stub();
		driver.drive(stub);
	}
}
