package po;

import java.util.ArrayList;

import po.accountpo.AccountPO;
import state.OrganizationType;

/**
 * 营业厅单一可持续化对象
 * @author czw
 * @version Oct 23, 2015
 */
public class BranchPO extends OrganizationPO{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 员工信息
	 */
	private ArrayList<AccountPO> accounts;
	
	/**
	 * 所属车辆信息
	 */
	private ArrayList<FacilityPO> facilities;
	
	/**
	 * 构造器
	 */
	public BranchPO(String id, String address, String date, ArrayList<AccountPO> accounts, ArrayList<FacilityPO> facilities) {
		super(id, address,accounts.size(),OrganizationType.BRANCH);
		this.accounts = new ArrayList<>();
		this.facilities = new ArrayList<>();
	}
	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}

	public ArrayList<FacilityPO> getFacilities() {
		return facilities;
	}
	public void setAccounts(ArrayList<AccountPO> accounts) {
		this.accounts = accounts;
	}
	public void setFacilities(ArrayList<FacilityPO> facilities) {
		this.facilities = facilities;
	}
	
}
