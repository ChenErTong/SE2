package po;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 银行账户的持久化对象
 * 账户属性有：名称和余额、创建时间、账户属性。余额是不可以修改的，此数据项取决于收款单和付款单
 * @author zsq
 * @version Oct 22,2015
 */

public class BankAccountPO extends PersistentObject{

	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	/**账户名称*/
	private String name;
	/**账户余额*/
	private BigDecimal money;
	/**账户属性*/
	private String level;
 
	
	public BankAccountPO(String ID,String name,BigDecimal money,String level){
		super(ID);
		this.name = name;
		this.money = money;
		this.level = level;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd HH:mm");
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

	

	public BigDecimal getMoney() {
		return money;
	}
	
	public String getMoneyString(){
		return money+"";
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	/**
	 * 模糊查询
	 * @see java.lang.Object#toString()
	 * @author Ann
	 */
	@Override
	public String toString(){
		return this.ID+"|"+this.name+"|"+this.money;
	}

	@Override
	public String getID() {
		return super.getID();
	}

	
}
