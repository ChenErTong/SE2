package po;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 银行账户的持久化对象
 * 账户属性有：名称和余额、创建时间、账户属性。余额是不可以修改的，此数据项取决于收款单和付款单
 * @author zsq
 * @version Oct 22,2015
 */

public class BankPO extends PersistentObject{

	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	/**账户名称*/
	private String name;
	/**账户余额*/
	private double money;
	/**账户属性*/
	private String level;
	/**账户创建时间,系统自动计算得到*/
	private String date;
	
	public BankPO(String ID,String name,double money,String level){
		super(ID);
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

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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
