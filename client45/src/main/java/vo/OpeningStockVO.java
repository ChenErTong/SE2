package vo;

import java.util.ArrayList;

import po.FacilityPO;
import po.InventoryPO;
import po.OrganizationPO;
import po.accountpo.AccountPO;

public class OpeningStockVO {
	private String ID;
	private String date;
	private ArrayList<OrganizationPO> organizations;

	private ArrayList<AccountPO> accounts;

	private ArrayList<FacilityPO> facilities;

	private ArrayList<InventoryPO> inventories;

	public OpeningStockVO(String ID, String date, ArrayList<OrganizationPO> organizations,
			ArrayList<AccountPO> accounts, ArrayList<FacilityPO> facilities, ArrayList<InventoryPO> inventories) {
		this.ID=ID;
		this.date=date;
		this.organizations = organizations;
		this.accounts = accounts;
		this.facilities = facilities;
		this.inventories = inventories;
	}

	public ArrayList<OrganizationPO> getOrganizations() {
		return organizations;
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
}
