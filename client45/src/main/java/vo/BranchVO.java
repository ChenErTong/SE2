package vo;

import java.util.ArrayList;

import po.FacilityPO;
import po.accountpo.AccountPO;

public class BranchVO {
	/**
	 * 编号
	 */
	private String id;
	/**
	 * 成立时间
	 */
	private String date;
	/**
	 * 营业厅地址
	 */
	private String address;
	
	/**
	 * 员工信息
	 */
	private ArrayList<AccountPO> accounts;
	
	/**
	 * 所属车辆信息
	 */
	private ArrayList<FacilityPO> facilities;

	public BranchVO(String id, String date, String address, ArrayList<AccountPO> accounts,
			ArrayList<FacilityPO> facilities) {
		this.id = id;
		this.date = date;
		this.address = address;
		this.accounts = accounts;
		this.facilities = facilities;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public ArrayList<FacilityPO> getFacilities() {
		return facilities;
	}

	public void setFacilities(ArrayList<FacilityPO> facilities) {
		this.facilities = facilities;
	}
	
}
