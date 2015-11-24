package po;

import java.util.ArrayList;

import po.accountpo.AccountPO;
import state.OrganizationType;
import state.ReceiptType;





/**
 * 中转中心单一可持续化对象
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferPO extends OrganizationPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		super(id,  address,accounts.size(),OrganizationType.TRANSFER);
		//Date在OrganizationPO里能自动生成
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