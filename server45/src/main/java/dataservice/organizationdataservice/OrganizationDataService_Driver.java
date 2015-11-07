package dataservice.organizationdataservice;

import java.rmi.RemoteException;

import po.OrganizationPO;

public class OrganizationDataService_Driver {
	
	//TODO 乱码
	
	private OrganizationPO po = new OrganizationPO("123","乱码",125);
	public void drive(OrganizationDataService orgDataService) throws RemoteException{
		orgDataService.show();
		orgDataService.insert(po);
		orgDataService.delete(po.getOrganizationID());
		orgDataService.update(po);
	}
	
	public static void main(String args[]) throws RemoteException{
		OrganizationDataService_Driver driver = new OrganizationDataService_Driver();
		OrganizationDataService stub = new OrganizationDataService_Stub();
		driver.drive(stub);
		
	}

}
