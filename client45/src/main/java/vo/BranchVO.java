package vo;

import java.util.ArrayList;

import state.OrganizationType;
import vo.accountvo.AccountVO;

public class BranchVO extends OrganizationVO{
	/**
	 * 员工信息
	 */
	public ArrayList<AccountVO> accounts;
	
	/**
	 * 所属车辆信息
	 */
	public ArrayList<FacilityVO> facilities;
	
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
