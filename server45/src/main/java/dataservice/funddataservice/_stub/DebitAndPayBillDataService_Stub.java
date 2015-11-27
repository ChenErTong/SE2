package dataservice.funddataservice._stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.funddataservice.DebitAndPayBillDataService;
import po.receiptpo.DebitAndPayBillPO;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;

public class DebitAndPayBillDataService_Stub implements DebitAndPayBillDataService{
	private ArrayList<DebitAndPayBillPO> debitAndPayBillPOs;
	private DebitAndPayBillPO debitAndPayBillPO_1;
	private DebitAndPayBillPO debitAndPayBillPO_2;
	private ArrayList<String> orderNumbers;
	private ArrayList<String> transListNumbers;
	public DebitAndPayBillDataService_Stub(){
		debitAndPayBillPOs = new ArrayList<DebitAndPayBillPO>();
		debitAndPayBillPO_1 = new DebitAndPayBillPO("123", 500, "courierID",ReceiptType.EXPENSE,orderNumbers);
		debitAndPayBillPO_2 = new DebitAndPayBillPO("456", 471, "payername", ReceiptType.PAY, transListNumbers);
		debitAndPayBillPOs.add(debitAndPayBillPO_1);
		debitAndPayBillPOs.add(debitAndPayBillPO_2);
	}
	@Override
	public ResultMessage add(DebitAndPayBillPO po) {
		System.out.println("Insert a debitbill or paybill succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a debitbill or paybill succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(DebitAndPayBillPO PO) {
		System.out.println("Update the message succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getID(ReceiptType type) {
		System.out.println("Get the receiptID succeed!");
		return "123";
	}

	@Override
	public String getExpenseID() {
		System.out.println("Get the expenseID succeed!");
		return "456";
	}

	@Override
	public String getPayID() {
		System.out.println("Get the payID succeed!");
		return "789";
	}

	@Override
	public ArrayList<DebitAndPayBillPO> show(ReceiptType type) {
		System.out.println("Show all the debitbills or paybills succeed!");
		return new ArrayList<DebitAndPayBillPO>();
	}
	@Override
	public ArrayList<DebitAndPayBillPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<DebitAndPayBillPO> showList(String begin, String end) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DebitAndPayBillPO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<DebitAndPayBillPO> show(ReceiptType type, ReceiptState State) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashMap<String, String> getAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void initialFile() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<DebitAndPayBillPO> showList(String end) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}