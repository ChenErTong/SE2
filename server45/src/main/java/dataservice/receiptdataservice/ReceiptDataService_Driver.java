package dataservice.receiptdataservice;

import java.rmi.RemoteException;

import po.receiptpo.ReceiptPO;

public class ReceiptDataService_Driver {
	private ReceiptPO po;
	public void drive(ReceiptDataService receiptDataService) throws RemoteException{
		receiptDataService.find();
		receiptDataService.modify(po);
		
	}
	public static void main(String args[]) throws RemoteException{
		ReceiptDataService_Driver driver = new ReceiptDataService_Driver();
		ReceiptDataService stub = new ReceiptDataService_Stub();
		
		driver.drive(stub);
	}
}
