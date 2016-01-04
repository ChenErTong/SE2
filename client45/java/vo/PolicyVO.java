package vo;

import state.SalaryPolicy;
import state.UserIdentity;

public class PolicyVO extends ValueObject{
	public UserIdentity userIdentity;
	public SalaryPolicy salaryPolicy;
	public String remark;
	
	
	public PolicyVO(String iD, UserIdentity userIdentity, SalaryPolicy salaryPolicy, String remark) {
		super(iD);
		this.userIdentity = userIdentity;
		this.salaryPolicy = salaryPolicy;
		this.remark = remark;
	}
	
	
}
