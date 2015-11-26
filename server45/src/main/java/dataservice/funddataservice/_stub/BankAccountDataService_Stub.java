package dataservice.funddataservice._stub; 

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;
import state.FindTypeAccount;
import state.ResultMessage;
import dataservice.funddataservice.BankAccountDataService;

public class BankAccountDataService_Stub implements BankAccountDataService{
	
	private ArrayList<BankAccountPO> bankPOs;
	private BankAccountPO bankPO_1;
	private BankAccountPO bankPO_2;

	
	public BankAccountDataService_Stub(){
		bankPOs = new ArrayList<BankAccountPO>();
		bankPO_1 = new BankAccountPO("123", "zsq", 147, "high");
		bankPO_2 = new BankAccountPO("145", "whd", 258, "low");
		bankPOs.add(bankPO_1);
		bankPOs.add(bankPO_2);
	}
	@Override
	public ResultMessage add(BankAccountPO po) {
		System.out.println("Insert a bankaccount succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a bankaccount succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(BankAccountPO PO) {
		System.out.println("Modify the information of a bankaccount succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<BankAccountPO> find(String keywords,
			FindTypeAccount bankAccoutType) {
		System.out.println("Find the bankaccount using keywords succeed!");
		return new ArrayList<BankAccountPO>();
	}
	@Override
	public ArrayList<BankAccountPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void initialFile() {
		// TODO Auto-generated method stub
		
	}
	

}
