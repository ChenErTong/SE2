package vo;

import java.text.SimpleDateFormat;
import java.util.Date;
public class BankVO{
	
	private String ID;
	/**账户名称*/
	private String name;
	/**账户余额*/
	private double money;
	/**账户属性*/
	private String level;
	/**账户创建时间,系统自动计算得到*/
	private String date;
	
	public BankVO(String ID,String name,double money,String level){
		//super(ID);
		this.name = name;
		this.money = money;
		this.level = level;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}

	public String getName() {
		return name;
	}

	

	public String getLevel() {
		return level;
	}

	

	

	public double getMoney() {
		return money;
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