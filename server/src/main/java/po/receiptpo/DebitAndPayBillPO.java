package po.receiptpo;

import java.math.BigDecimal;

import state.ReceiptType;

/**
 * @author zsq
 * @version Oct 22,2015
 */
public class DebitAndPayBillPO extends ReceiptPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5827233260131683793L;

	private BigDecimal money;
	private String bankAccountID;


	public DebitAndPayBillPO(String ID, ReceiptType type, BigDecimal money,String bankAccountID) {
		super(ID, type);
		this.money = money;
		this.bankAccountID = bankAccountID;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public String getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(String bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}