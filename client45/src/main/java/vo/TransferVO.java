package vo;

import java.util.ArrayList;

import po.InventoryPO;
import po.accountpo.AccountPO;
import state.OrganizationType;

public class TransferVO extends OrganizationVO {
	

	/**
	 * 中转中心地址
	 */
	public String address;
	
	/**
	 * 员工信息
	 */
	public ArrayList<AccountPO> accounts;
	
	/**
	 * 仓库信息
	 */
	public ArrayList<InventoryPO> inventories;

	public TransferVO(String organizationID, String address,String date, ArrayList<AccountPO> accounts,
			ArrayList<InventoryPO> inventories) {
		super(organizationID, address, accounts.size(),OrganizationType.TRANSFER);
		//this.accounts = accounts;
	//	this.inventories = inventories;
		accounts = new ArrayList<AccountPO>();
		inventories = new ArrayList<InventoryPO>();
	}

	
}
