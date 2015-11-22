package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpenseVO {
	
	/**收款业务员ID*/
	private String ID;
	/**收款单位*/
	private String workshop;
	/**收款金额*/
	private double money;
	/**收款地点*/
	private String address;
	/**收款日期,系统自动生成*/
	private String date;
	
	public ExpenseVO(String ID,String workshop,double money,String address){
		this.ID = ID;
		this.workshop = workshop;
		this.money = money;
		this.address = address;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
		
	
	}

	public String getID() {
		return ID;
	}

	
	public String getWorkshop() {
		return workshop;
	}

	
	public double getMoney() {
		return money;
	}


	public String getAddress() {
		return address;
	}

	

	public String getDate() {
		return date;
	}

}
