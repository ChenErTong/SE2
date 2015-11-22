package dataservice.accountdataservice;

import java.rmi.RemoteException;

public class AccountDataService_Driver {
	public void drive(AccountDataService service) throws RemoteException{
		service.init();
	}
	
	public static void main(String args[]) throws RemoteException{
		AccountDataService_Driver driver = new AccountDataService_Driver();
		AccountDataService stub = new AccountDataService_Stub();
		driver.drive(stub);
	}
}
