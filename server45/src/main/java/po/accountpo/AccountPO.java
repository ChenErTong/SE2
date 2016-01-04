package po.accountpo;

import java.math.BigDecimal;
import java.util.ArrayList;

import po.PersistentObject;



public class AccountPO extends PersistentObject{
	 /**员工账户的的持久化对象
     * AccontPO: 公司职员的PO类
     * 包括员工编号、职务权限、姓名、出生日期、身份证号、手机号、
     * 工资情况、任职时间、每日订单完成情况**/
	
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	/**职务权限**/ 
	private String Duty;
	/**姓名**/
	private String Name;
	/**出生日期**/ 
	private String BirthDay;
	/**身份证号**/
	private String IDCard;
	/**手机号**/ 
	private String Phone;
	/**工资情况**/
	private BigDecimal Salary;
	/**任职时间**/
	private String WorkTime;
	/**营业厅or中转中心编号*/
	private String organizationID;
	/**每日完成的订单编号**/
	private ArrayList<String> ordersID;
	
	private String userID;
	
	public AccountPO(String ID,String duty, String name, String birthDay, String IDCard, String phone, BigDecimal salary,
			String workTime,String organizationID,String userID,ArrayList<String> ordersID) {
		super(ID);
		this.Duty = duty;
		this.Name = name;
		this.BirthDay = birthDay;
		this.IDCard = IDCard;
		this.Phone = phone;
		this.Salary = salary;
		this.WorkTime = workTime;
		this.organizationID=organizationID;
		this.ordersID = ordersID;
		this.userID=userID;
	}


	public String getUserID() {
		return userID;
	}

	public String getDuty() {
		return Duty;
	}

	public void setDuty(String duty) {
		Duty = duty;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public BigDecimal getSalary() {
		return Salary;
	}

	public void setSalary(BigDecimal salary) {
		Salary = salary;
	}

	public String getWorkTime() {
		return WorkTime;
	}

	public void setWorkTime(String workTime) {
		WorkTime = workTime;
	}

	
	public String getOrganizationID() {
		return organizationID;
	}


	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}


	public void addOrderID(String id){
		ordersID.add(id);
	}


	public ArrayList<String> getOrdersID() {
		return ordersID;
	}
}