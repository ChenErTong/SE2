package vo.receiptvo;

import java.math.BigDecimal;

import state.ReceiptType;

public class DebitAndPayBillVO  extends ReceiptVO{
	public BigDecimal money;
	/**单据状态*/
	public String bankAccountID;
	public DebitAndPayBillVO(String id, ReceiptType type, BigDecimal money,String bankAccountID) {
		super(id, type);
		this.money = money;
		this.bankAccountID=bankAccountID;
	}
	
}
