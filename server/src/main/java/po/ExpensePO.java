package po;

import java.math.BigDecimal;

/**
 * 财务人员进行收款信息汇总时所需要的收款信息,包括收款日期、收款单位、收款人、收款方、收款金额、收款地点
 * @author zsq
 * 
 */
public class ExpensePO extends PersistentObject{

	/** seritlVersionUID*/
	private static final long serialVersionUID = 1L;
	/**收款业务员ID*/
	private String ID;
	/**收款单位*/
	private String workshop;
	/**收款金额*/
	private BigDecimal money;
	/**收款地点*/
	private String address;
	
	public ExpensePO(String ID,String workshop,BigDecimal money,String address){
		super(ID);
		this.ID = ID;
		this.workshop = workshop;
		this.money = money;
		this.address = address;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getWorkshop() {
		return workshop;
	}
	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
