package po.receiptpo.orderreceiptpo;

import po.receiptpo.ReceiptPO;
import state.ReceiptType;

/**
 * 派件单：订单订单号、派送员
 * @author czw
 * @version Oct 23, 2015
 */
public class DeliveryListPO extends  ReceiptPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String courierName;
	private String orders;
	
	public DeliveryListPO(String ID, ReceiptType type, String orders, String courierName) {
		super(ID, type );
		this.setCourierName(courierName);
		this.orders=orders;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public String getOrders() {
		return orders;
	}


	public void setOrders(String orders) {
		this.orders = orders;
	}

}
