package vo.receiptvo;

import state.ReceiptType;

public class DebitAndPayBillVO  extends ReceiptVO{
	public double money;
	/**单据状态*/
	
	public DebitAndPayBillVO(String id, ReceiptType type, double money) {
		super(id, type);
		this.money = money;
	}
	
}
