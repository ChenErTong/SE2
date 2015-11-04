package dataservice.funddataservice._stub;

import java.util.ArrayList;

import po.DebitAndPayBillPO;
import state.ReceiptCondition;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import dataservice.funddataservice.DebitAndPayBillDataService;

public class DebitAndPayBillDataService_Stub implements DebitAndPayBillDataService{
	private ArrayList<DebitAndPayBillPO> debitAndPayBillPOs;
	private DebitAndPayBillPO debitAndPayBillPO_1;
	private DebitAndPayBillPO debitAndPayBillPO_2;
	private ArrayList orderNumbers;
	private ArrayList transListNumbers;
	public DebitAndPayBillDataService_Stub(){
		debitAndPayBillPOs = new ArrayList<DebitAndPayBillPO>();
		debitAndPayBillPO_1 = new DebitAndPayBillPO("123", 500, "courierID",ReceiptType.EXPENSE,orderNumbers);
		debitAndPayBillPO_2 = new DebitAndPayBillPO("456", 471, "payername", ReceiptType.PAY, transListNumbers);
		debitAndPayBillPOs.add(debitAndPayBillPO_1);
		debitAndPayBillPOs.add(debitAndPayBillPO_2);
	}
	@Override
	public ResultMessage insert(DebitAndPayBillPO po) {
		System.out.println("Insert a debitbill or paybill succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a debitbill or paybill succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(DebitAndPayBillPO PO) {
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

}