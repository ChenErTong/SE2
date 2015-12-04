package po.receiptpo;

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
	
	public DebitBillPO(String id,ReceiptType type,String courierID,double money,ArrayList<String> orderNumbers, String date) {
		super(id, type, money);
		this.courierID=courierID;
		this.orderNumbers=orderNumbers;
	}

	public String getCourierID() {
		return courierID;
	}

	public ArrayList<String> getOrderNumbers() {
		return orderNumbers;
	}


	public void setDate(String date) {
		this.date = date;
	}
}
