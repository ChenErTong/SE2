package vo;

import java.util.ArrayList;

import state.OrganizationType;
import vo.accountvo.AccountVO;

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
	public ArrayList<AccountVO> accounts;
	
	/**
	 * 所属车辆信息
	 */
	public ArrayList<FacilityVO> facilities;
	
	public String branchID;

	public BranchVO(String id, String date, String address, ArrayList<AccountVO> accounts,
			ArrayList<FacilityVO> facilities) {
		super(id, address, accounts.size(),OrganizationType.BRANCH);
		this.accounts = accounts;
		this.facilities = facilities;
	}

	public BranchVO(String organizationID, String address, OrganizationType organizationType) {
		super(organizationID, address, 0, OrganizationType.BRANCH);
		this.accounts = new ArrayList<AccountVO> ();
		this.facilities = new ArrayList<FacilityVO>();
	}
	
	
}
