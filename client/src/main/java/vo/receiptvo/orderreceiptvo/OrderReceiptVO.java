package vo.receiptvo.orderreceiptvo;

import java.util.ArrayList;

import state.ReceiptType;
import vo.receiptvo.ReceiptVO;

public class OrderReceiptVO extends ReceiptVO{
	public ArrayList<String> orders;

	public OrderReceiptVO(String id, ReceiptType type, ArrayList<String> orders) {
		super(id, type);
		this.orders = orders;
	}
}
