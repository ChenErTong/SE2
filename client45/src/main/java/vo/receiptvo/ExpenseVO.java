package vo.receiptvo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import vo.ValueObject;

public class ExpenseVO extends ValueObject{
	
	/**收款业务员ID*/
	public String ID;
	/**收款单位*/
	public String workshop;
	/**收款金额*/
	public BigDecimal money;
	/**收款地点*/
	public String address;
	/**收款日期,系统自动生成*/
	public String date;
	
	public ExpenseVO(String ID,String workshop,BigDecimal money,String address){
		this.ID = ID;
		this.workshop = workshop;
		this.money = money;
		this.address = address;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	
	}

}
