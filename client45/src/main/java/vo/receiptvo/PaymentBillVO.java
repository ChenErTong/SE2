package vo.receiptvo;

import java.math.BigDecimal;

import state.PayBillItem;
import state.ReceiptType;

/**
 * 
 * @author Ann
 *
 */
public class PaymentBillVO extends DebitAndPayBillVO {
	/**
	 * 付款人姓名
	 */
	public String payerName;
	/**
	 * 付款条目
	 */
	public PayBillItem items;
	/**
	 * 备注（租金年份、运单号、标注工资月份）
	 */
	public String remarks;

	public PaymentBillVO(String iD, String date, ReceiptType type, BigDecimal money, String payerName, String bankAccountID,
			PayBillItem items, String remarks) {
		super(iD, type, money,bankAccountID);
		this.payerName = payerName;
		this.items = items;
		this.remarks = remarks;
	}

}
