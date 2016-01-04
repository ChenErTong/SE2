package vo.receiptvo.orderreceiptvo;

import state.ReceiptType;
import vo.receiptvo.ReceiptVO;

/**
 * 派件单：订单订单号、派送员
 * 
 * @author czw
 * @version Oct 23, 2015
 */
public class DeliveryListVO extends ReceiptVO {
	public String courierName;
	public String order;

	public DeliveryListVO(String id, ReceiptType type, String order, String courierName) {
		super(id, type);
		this.courierName = courierName;
		this.order = order;
	}

}
