package dataservice.funddataservice._Driver;

import java.util.ArrayList;

import po.DebitAndPayBillPO;
import state.ReceiptType;
import dataservice.funddataservice.DebitAndPayBillDataService;
import dataservice.funddataservice._stub.DebitAndPayBillDataService_Stub;

public class DebitAndPayBillDataService_Driver {
	private ArrayList orderNumbers;
	private DebitAndPayBillPO po = new DebitAndPayBillPO("123", 500, "courierID",ReceiptType.EXPENSE,orderNumbers);
	public void drive(DebitAndPayBillDataService DPBillDataService){
		DPBillDataService.getExpenseID();
		DPBillDataService.getID(ReceiptType.EXPENSE);
		DPBillDataService.getPayID();
		DPBillDataService.insert(po);
		DPBillDataService.delete(po.getID());
		DPBillDataService.show(ReceiptType.EXPENSE);
		DPBillDataService.update(po);
	
		
	}
	
	public static void main(String args[]){
		DebitAndPayBillDataService_Driver driver = new DebitAndPayBillDataService_Driver();
		DebitAndPayBillDataService stub = new DebitAndPayBillDataService_Stub();
		driver.drive(stub);
	}
}
