package po.receiptpo.orderreceiptpo;

import java.util.ArrayList;

import po.receiptpo.ReceiptPO;
import state.ReceiptType;

public class OrderReceiptPO extends ReceiptPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> orders;
	public OrderReceiptPO(String ID, ReceiptType type, ArrayList<String> orders) {
		super(ID, type);
		this.orders = orders;
	}
	public ArrayList<String> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}

	
	
}
