package dataservice.funddataservice._stub; 

import java.util.ArrayList;

import po.BankPO;
import state.FindTypeAccount;
import state.ResultMessage;
import dataservice.funddataservice.BankAccountDataService;

public class BankAccountDataService_Stub implements BankAccountDataService{
	
	private ArrayList<BankPO> bankPOs;
	private BankPO bankPO_1;
	private BankPO bankPO_2;

	
	public BankAccountDataService_Stub(){
		bankPOs = new ArrayList<BankPO>();
		bankPO_1 = new BankPO("123", "zsq", 147, "high");
		bankPO_2 = new BankPO("145", "whd", 258, "low");
		bankPOs.add(bankPO_1);
		bankPOs.add(bankPO_2);
	}
	@Override
	public ResultMessage insert(BankPO po) {
		System.out.println("Insert a bankaccount succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a bankaccount succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(BankPO PO) {
		System.out.println("Modify the information of a bankaccount succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<BankPO> find(String keywords,
			FindTypeAccount bankAccoutType) {
		System.out.println("Find the bankaccount using keywords succeed!");
		return new ArrayList<BankPO>();
	}

}
