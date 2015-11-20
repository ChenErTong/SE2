package dataservice.receiptdataservice;

import java.rmi.RemoteException;

import po.receiptpo.ReceiptPO;

public class ReceiptDataService_Driver {
	private ReceiptPO po = new ReceiptPO("456");
	public void drive(ReceiptDataService receiptDataService) throws RemoteException{
		receiptDataService.find();
		receiptDataService.update(po);
		
	}
	public static void main(String args[]) throws RemoteException{
		ReceiptDataService_Driver driver = new ReceiptDataService_Driver();
		ReceiptDataService stub = new ReceiptDataService_Stub();
		
		driver.drive(stub);
	}
}
