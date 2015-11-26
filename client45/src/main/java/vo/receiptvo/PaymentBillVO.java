package vo.receiptvo;

import state.PayBillItem;
import state.ReceiptType;
/**
 * 
 * @author Ann
 *
 */
public class PaymentBillVO extends ReceiptVO{
	/**
	 * ID
	 */
	public String ID;
	/**
	 * 日期
	 */
	public String date;
	/**
	 * 单据类型
	 */
	public ReceiptType type;
	/**
	 * 付款金额
	 */
	public double money;
	/**
	 * 付款人姓名
	 */
	public String payerName;
	/**
	 * 付款账号的ID
	 */
	public String accountID;
	/**
	 * 付款条目
	 */
	public PayBillItem items;
	/**
	 * 备注（租金年份、运单号、标注工资月份）
	 */
	public String remarks;
	
	public PaymentBillVO(String iD, String date, ReceiptType type, double money, String payerName, String accountID,
			PayBillItem items, String remarks) {
		super(iD, type);
		this.date = date;
		this.money = money;
		this.payerName = payerName;
		this.accountID = accountID;
		this.items = items;
		this.remarks = remarks;
	}
	
	
}
