package po.receiptpo;

import java.math.BigDecimal;
import java.util.ArrayList;

import state.ReceiptType;

/**
 * 收款单：收款金额
 * @author czw
 * @version Oct 23, 2015
 */
public class DebitBillPO extends DebitAndPayBillPO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String courierID;
	private ArrayList<String> orderNumbers;
	private String date;
	
	public DebitBillPO(String id,ReceiptType type,String courierID,BigDecimal money,ArrayList<String> orderNumbers, String date,String bankAccountID) {
		super(id, type, money,bankAccountID);
		this.courierID=courierID;
		this.orderNumbers=orderNumbers;
		this.date = date;
	}

	public String getCourierID() {
		return courierID;
	}

	public ArrayList<String> getOrderNumbers() {
		return orderNumbers;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
