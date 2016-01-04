package vo.receiptvo;

import state.ReceiptType;

public class RecipientConfirmReceiptVO extends ReceiptVO {
	public String orderID;
	//收件编号是父类的ID
	//收件日期是父类的date
	public String recipientName;
	public RecipientConfirmReceiptVO(String id, ReceiptType type, String orderID, String recipientName) {
		super(id, type);
		this.orderID = orderID;
		this.recipientName = recipientName;
	}
}
