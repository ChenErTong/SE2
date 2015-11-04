package dataservice.receiptdataservice;

import po.receiptpo.ReceiptPO;

public class ReceiptDataService_Driver {
	private ReceiptPO po = new ReceiptPO("456");
	public void drive(@SuppressWarnings("rawtypes") ReceiptDataService receiptDataService){
		receiptDataService.find();
		receiptDataService.update(po);
		
	}
	public static void main(String args[]){
		ReceiptDataService_Driver driver = new ReceiptDataService_Driver();
		ReceiptDataService stub = new ReceiptDataService_Stub();
		
		driver.drive(stub);
	}
}
