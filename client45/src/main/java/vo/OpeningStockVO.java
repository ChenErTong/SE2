package vo;

import java.util.ArrayList;

import po.BankAccountPO;
import po.BranchPO;
import po.FacilityPO;
import po.InventoryPO;
import po.TransferPO;
import po.accountpo.AccountPO;

public class OpeningStockVO {
	private String ID;
	private String date;
private  ArrayList<TransferPO> transfers;
	
	private ArrayList<BranchPO> branchs;

	private ArrayList<AccountPO> accounts;

	private ArrayList<FacilityPO> facilities;

	private ArrayList<InventoryPO> inventories;
	
	private ArrayList<BankAccountPO> bankAccounts;

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


	public ArrayList<FacilityPO> getFacilities() {
		return facilities;
	}

	public ArrayList<InventoryPO> getInventories() {
		return inventories;
	}

	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}

	public String getID() {
		return ID;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<TransferPO> getTransfers() {
		return transfers;
	}

	public ArrayList<BranchPO> getBranchs() {
		return branchs;
	}


	public ArrayList<BankAccountPO> getBankAccounts() {
		return bankAccounts;
	}

}
