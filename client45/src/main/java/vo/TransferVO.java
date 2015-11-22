package vo;

import java.util.ArrayList;

import po.InventoryPO;
import po.accountpo.AccountPO;

public class TransferVO extends OrganizationVO {
	

	/**
	 * 中转中心地址
	 */
	private String address;
	
	/**
	 * 员工信息
	 */
	private ArrayList<AccountPO> accounts;
	
	/**
	 * 仓库信息
	 */
	private ArrayList<InventoryPO> inventories;

	public TransferVO(String organizationID, String address, int number, ArrayList<AccountPO> accounts,
			ArrayList<InventoryPO> inventories) {
		super(organizationID, address, number);
		this.accounts = accounts;
		this.inventories = inventories;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<AccountPO> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<InventoryPO> getInventories() {
		return inventories;
	}

	public void setInventories(ArrayList<InventoryPO> inventories) {
		this.inventories = inventories;
	}
	
	
	
	
}
