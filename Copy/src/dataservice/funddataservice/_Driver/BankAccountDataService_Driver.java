package dataservice.funddataservice._Driver;

import po.BankPO;
import state.FindTypeAccount;
import dataservice.funddataservice.BankAccountDataService;
import dataservice.funddataservice._stub.BankAccountDataService_Stub;
	
public class BankAccountDataService_Driver {
	private BankPO po = new BankPO("123","zsq",147,"high");
	public void drive(BankAccountDataService baDataService){
	
	baDataService.find("ID", FindTypeAccount.ID);
	baDataService.insert(po);
	baDataService.delete("123");
	baDataService.update(po);
	
	}
	public static void main(String args[]){
		BankAccountDataService_Driver driver = new BankAccountDataService_Driver();
		BankAccountDataService stub = new BankAccountDataService_Stub();
		driver.drive(stub);
	}
}
