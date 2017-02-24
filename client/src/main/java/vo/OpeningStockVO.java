package vo;

import java.util.ArrayList;

import po.BankAccountPO;
import po.BranchPO;
import po.FacilityPO;
import po.InventoryPO;
import po.TransferPO;
import po.accountpo.AccountPO;

public class OpeningStockVO {
	public String ID;
	public String date;
	public  ArrayList<TransferPO> transfers;
	
	public ArrayList<BranchPO> branchs;

	public ArrayList<AccountPO> accounts;

	public ArrayList<FacilityPO> facilities;

	public ArrayList<InventoryPO> inventories;
	
	public ArrayList<BankAccountPO> bankAccounts;

	public OpeningStockVO(String ID, String date, ArrayList<TransferPO> transfers,ArrayList<BranchPO> branchs,
			ArrayList<AccountPO> accounts, ArrayList<FacilityPO> facilities, ArrayList<InventoryPO> inventories,ArrayList<BankAccountPO> bankAccounts) {
		this.ID=ID;
		this.date=date;
		this.transfers=transfers;
		this.branchs=branchs;
		this.accounts = accounts;
		this.facilities = facilities;
		this.inventories = inventories;
		this.bankAccounts = bankAccounts;
	}



}
