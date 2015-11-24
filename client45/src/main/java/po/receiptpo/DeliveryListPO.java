package po.receiptpo;

import state.ReceiptType;

/**
 * 派件单：订单订单号、派送员
 * @author czw
 * @version Oct 23, 2015
 */
public class DeliveryListPO extends ReceiptPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeliveryListPO(String ID,ReceiptType type) {
		super(ID,type);
	}

}
