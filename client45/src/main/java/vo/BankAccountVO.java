package vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
public class BankAccountVO{
	
	public String ID;
	/**账户名称*/
	public String name;
	/**账户余额*/
	
	public BigDecimal money;
	/**账户属性*/
	public String level;
	/**账户创建时间,系统自动计算得到*/
	public String date;
	
	public BankAccountVO(String ID,String name,BigDecimal money,String level){
		this.ID=ID;
		this.name = name;
		this.money = money;
		this.level = level;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd HH:mm");
		date = sdf.format(new Date());
	}
	/**
	 * 模糊查询
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return this.ID+"|"+this.name+"|"+this.money;
	}
}