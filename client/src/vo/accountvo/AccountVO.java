package vo.accountvo;

public class AccountVO {
	/**员工编号**/
	public String ID;
	/**职务权限**/ 
	public String Duty;
	/**姓名**/
	public String Name;
	/**出生日期**/ 
	public String BirthDay;
	/**身份证号**/
	public String IDCard;
	/**手机号**/ 
	public String Phone;
	/**工资情况**/
	public double Salary;
	/**任职时间**/
	public String WorkTime;
	/**每日订单完成**/
	public int ReceiptNum;
	
	public AccountVO(String ID,String duty, String name, String birthDay, String IDCard, String phone, double salary,
			String workTime, int receiptNum) {
		
		super();
		this.ID=ID;
		this.Duty = duty;
		this.Name = name;
		this.BirthDay = birthDay;
		this.IDCard = IDCard;
		this.Phone = phone;
		this.Salary = salary;
		this.WorkTime = workTime;
		this.ReceiptNum = receiptNum;
	}

}
