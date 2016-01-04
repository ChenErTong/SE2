package vo.accountvo;

import java.math.BigDecimal;
import java.util.ArrayList;

import vo.ValueObject;

public class AccountVO extends ValueObject{
	/** 员工编号 **/
	public String ID;
	/** 职务权限 **/
	public String Duty;
	/** 姓名 **/
	public String Name;
	/** 出生日期 **/
	public String BirthDay;
	/** 身份证号 **/
	public String IDCard;
	/** 手机号 **/
	public String Phone;
	/**营业厅编号*/
	public String branchID;
	/** 工资情况 **/
	public BigDecimal Salary;
	/** 任职时间 **/
	public String WorkTime;
	/**每日完成的订单编号**/
	public ArrayList<String> ordersID;
	
	public String userID;

	public AccountVO(String ID, String duty, String name, String birthDay, String IDCard, String phone, BigDecimal salary,
			String workTime,String branchID,String userID,ArrayList<String> ordersID) {
		this.ID = ID;
		this.Duty = duty;
		this.Name = name;
		this.BirthDay = birthDay;
		this.IDCard = IDCard;
		this.Phone = phone;
		this.Salary = salary;
		this.WorkTime = workTime;
		this.branchID = branchID;
		this.ordersID = ordersID;	
		this.userID=userID;
	}
	@Override
	public String toString(){
		return this.Name+"|"+this.Duty+"|"+this.Salary+"|"+this.WorkTime;
		
		
		
		
	}
}