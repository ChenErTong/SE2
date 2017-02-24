package po;

import state.SalaryPolicy;
import state.UserIdentity;

public class PolicyPO extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserIdentity userIdentity;
	private SalaryPolicy salaryPolicy;
	private String remark;
	
	public UserIdentity getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(UserIdentity userIdentity) {
		this.userIdentity = userIdentity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public PolicyPO(String id, UserIdentity userIdentity, SalaryPolicy salaryPolicy, String remark) {
		super(id);
		this.userIdentity = userIdentity;
		this.setSalaryPolicy(salaryPolicy);
		this.remark = remark;
	}

	public SalaryPolicy getSalaryPolicy() {
		return salaryPolicy;
	}

	public void setSalaryPolicy(SalaryPolicy salaryPolicy) {
		this.salaryPolicy = salaryPolicy;
	}
	
}
