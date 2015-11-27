package po.receiptpo.orderreceiptpo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 派件单：订单订单号、派送员
 * @author czw
 * @version Oct 23, 2015
 */
public class DeliveryListPO extends OrderReceiptPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String courierName;

	public DeliveryListPO(String ID, ReceiptType type, ArrayList<String> orders, String courierName) {
		super(ID, type, orders);
		this.setCourierName(courierName);
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	

}
