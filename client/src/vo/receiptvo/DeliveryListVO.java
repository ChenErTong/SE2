package vo.receiptvo;

import java.util.ArrayList;

/**
 * 派件单：订单订单号、派送员
 * @author czw
 * @version Oct 23, 2015
 */
public class DeliveryListVO extends ReceiptVO{
	private ArrayList<String> orders;
	private String courierName;
	
	public DeliveryListVO(String id, ArrayList<String> orders, String courierName) {
		super(id);
		this.orders = orders;
		this.courierName = courierName;
	}

	public DeliveryListVO(String ID) {
		super(ID);
	}

	public ArrayList<String> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

}
