package vo.receiptvo;

import state.ReceiptState;
import state.ReceiptType;

public class DebitAndPayBillVO  extends ReceiptVO{
	public double money;
	/**单据状态*/
	public ReceiptState state;
	
	public DebitAndPayBillVO(String id, ReceiptType type, double money) {
		super(id, type);
		this.money = money;
	}
	
}
