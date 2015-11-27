package vo.receiptvo.orderreceiptvo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 派件单：订单订单号、派送员
 * @author czw
 * @version Oct 23, 2015
 */
public class DeliveryListVO extends OrderReceiptVO{
	public String courierName;
	
	public DeliveryListVO(String id,  ReceiptType type,ArrayList<String> orders, String courierName) {
		super(id,type,orders);
		this.courierName = courierName;
	}



}
