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


	public DebitAndPayBillPO(String ID, ReceiptType type) {
		super(ID, type);
	}

	public DebitAndPayBillPO(String ID, ReceiptType type, BigDecimal money) {
		super(ID, type);
		this.money = money;
	}

	public BigDecimal getMoney() {
		return money;
	}

}