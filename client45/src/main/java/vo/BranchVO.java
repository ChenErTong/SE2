package vo;

import java.util.ArrayList;

import po.FacilityPO;
import po.accountpo.AccountPO;
import state.OrganizationType;

public class BranchVO extends OrganizationVO{
	/**
	 * 编号
	 */
	public String id;
	/**
	 * 成立时间
	 */
	public String date;
	/**
	 * 营业厅地址
	 */
	public String address;
	
	/**
	 * 员工信息
	 */
	public ArrayList<AccountPO> accounts;
	
	/**
	 * 所属车辆信息
	 */
	public ArrayList<FacilityPO> facilities;
	
	public String branchID;

	public BranchVO(String id, String date, String address, ArrayList<AccountPO> accounts,
			ArrayList<FacilityPO> facilities) {
		super(id, address, accounts.size(),OrganizationType.BRANCH);
		this.id = id;
		this.date = date;
		this.address = address;
		//this.accounts = accounts;
		//this.facilities = facilities;
		accounts = new ArrayList<AccountPO> ();
		facilities = new ArrayList<FacilityPO>();
	}

	
}
