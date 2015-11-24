package dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.receiptpo.ReceiptPO;
import po.receiptpo.TransferArrivalListPO;
import state.ReceiptState;
import state.ResultMessage;

public class ReceiptDataService_Stub implements ReceiptDataService{
	private ArrayList<ReceiptPO> receiptPOs;
	private ReceiptPO receiptPO_1;
	private ReceiptPO receiptPO_2;
	public ReceiptDataService_Stub(){
		receiptPOs = new ArrayList<ReceiptPO>();
		receiptPO_1 = new ReceiptPO("123");
		receiptPO_2 = new ReceiptPO("456");
		receiptPOs.add(receiptPO_1);
		receiptPOs.add(receiptPO_2);
	}
	@Override
	public ResultMessage modify(ReceiptPO PO) {
		System.out.println("Modify the receipt succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptPO> find() {
		System.out.println("Find all the receiptPO succeed!");
		return new ArrayList<ReceiptPO>();
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage add(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ReceiptPO> showReceipt(ReceiptState receiptStates) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ReceiptPO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TransferArrivalListPO findTransferArrivalList(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
