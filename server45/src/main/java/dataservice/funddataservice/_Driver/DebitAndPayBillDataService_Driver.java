package dataservice.funddataservice._Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DebitAndPayBillPO;
import state.ReceiptType;
import dataservice.funddataservice.DebitAndPayBillDataService;
import dataservice.funddataservice._stub.DebitAndPayBillDataService_Stub;

public class DebitAndPayBillDataService_Driver {
	private ArrayList orderNumbers;
	private DebitAndPayBillPO po = new DebitAndPayBillPO("123", 500, "courierID",ReceiptType.EXPENSE,orderNumbers);
	public void drive(DebitAndPayBillDataService DPBillDataService) throws RemoteException{
		DPBillDataService.getExpenseID();
		DPBillDataService.getID(ReceiptType.EXPENSE);
		DPBillDataService.getPayID();
		DPBillDataService.add(po);
		DPBillDataService.delete(po.getID());
		DPBillDataService.show(ReceiptType.EXPENSE);
		DPBillDataService.modify(po);
	
		
	}
	
	public static void main(String args[]) throws RemoteException{
		DebitAndPayBillDataService_Driver driver = new DebitAndPayBillDataService_Driver();
		DebitAndPayBillDataService stub = new DebitAndPayBillDataService_Stub();
		driver.drive(stub);
	}
}
