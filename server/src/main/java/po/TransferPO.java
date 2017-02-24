package po;

import java.util.ArrayList;

import po.accountpo.AccountPO;
import state.OrganizationType;

/**
 * 中转中心单一可持续化对象
 * 
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferPO extends OrganizationPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 员工信息
	 */
	private ArrayList<AccountPO> accounts;

	/**
	 * 仓库信息
	 */
	private ArrayList<InventoryPO> inventories;

	public TransferPO(String id, String date, String address, ArrayList<AccountPO> accounts,
			ArrayList<InventoryPO> inventories) {
		super(id, address, accounts.size(), OrganizationType.TRANSFER);
		this.accounts = accounts;
		this.inventories = inventories;
	}

	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}

	public ArrayList<InventoryPO> getInventories() {
		return inventories;
	}

	public void setAccounts(ArrayList<AccountPO> accounts) {
		this.accounts = accounts;
	}

	public void setInventories(ArrayList<InventoryPO> inventories) {
		this.inventories = inventories;
	}

}