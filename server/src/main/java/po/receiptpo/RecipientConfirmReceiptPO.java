package po.receiptpo;

import state.ReceiptType;

public class RecipientConfirmReceiptPO extends ReceiptPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderID;
	//收件编号是父类的ID
	//收件日期是父类的date
	private String recipientName;
	public RecipientConfirmReceiptPO(String ID, ReceiptType type, String orderID, String recipientName) {
		super(ID, type);
		this.orderID = orderID;
		this.recipientName = recipientName;
	}
	public String getOrderID() {
		return orderID;
	}
	public String getRecipientName() {
		return recipientName;
	}
	
}
