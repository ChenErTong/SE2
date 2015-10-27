package po;

import java.util.ArrayList;

import po.accountpo.AccountPO;





/**
 * 中转中心单一可持续化对象
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferPO extends PersistentObject{
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

	public TransferPO(String id, String date, String address, ArrayList<AccountPO> accounts, ArrayList<InventoryPO> inventories) {
		super(id, date);
		this.address = address;
		this.accounts = accounts;
		this.inventories = inventories;
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}

	public ArrayList<InventoryPO> getInventories() {
		return inventories;
	}
}