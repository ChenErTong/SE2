package vo.receiptvo;

import state.ReceiptState;
import state.ReceiptType;

public class DebitAndPayBillVO  extends ReceiptVO{
	public String ID;
	public double money;
	/**收款或者收款日期，系统自动生成*/
	public String date;
	/**区分收款单和付款单*/
	public ReceiptType type;
	/**单据状态*/
	public ReceiptState state;
	
	public DebitAndPayBillVO(String id, ReceiptType type, double money) {
		super(id, type);
		this.money = money;
	}
	
}
