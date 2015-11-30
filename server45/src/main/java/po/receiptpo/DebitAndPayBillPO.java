package po.receiptpo;

import state.ReceiptState;
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

	private double money;

	private ReceiptType type;
	private ReceiptState state;


	public DebitAndPayBillPO(String ID, ReceiptType type) {
		super(ID, type);
	}

	public DebitAndPayBillPO(String ID, ReceiptType type, double money) {
		super(ID, type);
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public ReceiptType getType() {
		return type;
	}

	public ReceiptState getState() {
		return state;
	}

}