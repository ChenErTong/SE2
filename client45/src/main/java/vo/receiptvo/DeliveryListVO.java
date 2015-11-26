package vo.receiptvo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 派件单：订单订单号、派送员
 * @author czw
 * @version Oct 23, 2015
 */
public class DeliveryListVO extends ReceiptVO{
	public ArrayList<String> orders;
	public String courierName;
	
	public DeliveryListVO(String id,  ReceiptType type,ArrayList<String> orders, String courierName) {
		super(id,type);
		this.orders = orders;
		this.courierName = courierName;
	}

	public DeliveryListVO(String ID,ReceiptType type) {
		super(ID, type);
	}


}
