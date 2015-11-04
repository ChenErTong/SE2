package dataservice.receiptdataservice;

import java.util.ArrayList;

import po.PersistentObject;
import po.receiptpo.ReceiptPO;
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
	public ResultMessage update(PersistentObject PO) {
		System.out.println("Modify the receipt succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptPO> find() {
		System.out.println("Find all the receiptPO succeed!");
		return new ArrayList<ReceiptPO>(){};
	}

}
