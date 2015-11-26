package po.receiptpo;

import state.PayBillItem;
import state.ReceiptType;

/**
 * 成本管理 付款日期、付款金额、付款人、付款账号、 条目（租金（按年收）运费（按次计算）人员工资（按月统计）奖励（一次性）
 * 
 * 备注（租金年份、运单号、标注工资月份） （快递员提成、司机计次、业务员月薪）
 * 
 * @author Ann
 *
 */
public class PaymentBillPO extends DebitAndPayBillPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 付款账号的ID
	 */
	private String accountID;
	/**
	 * 备注（租金年份、运单号、标注工资月份）
	 */
	private String remarks;

	public PaymentBillPO(String ID, ReceiptType type, double money, String payerName, PayBillItem items,
			String accountID, String remarks) {
		super(ID, type, money, payerName, items);
		this.accountID=accountID;
		this.remarks=remarks;
	}

	public String getAccountID() {
		return accountID;
	}

	public String getRemarks() {
		return remarks;
	}

	// public PaymentBillPO(String ID, double money, String payerName,
	// ArrayList<String> bankAccouts, ReceiptType type,
	// String rentYear, String salaryMonth, PayBillItem items, ArrayList<String>
	// transListNumber) {
	// super(ID, money, payerName, bankAccouts, type, rentYear, salaryMonth,
	// items, transListNumber);
	// // TODO Auto-generated constructor stub
	// }

}
