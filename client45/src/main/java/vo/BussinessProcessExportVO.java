package vo;

import java.util.ArrayList;

import state.PayBillItem;
import state.ReceiptType;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

public class BussinessProcessExportVO {
	public String ID;
	public String date;
	public double money;
	public ReceiptType type;
	//debit
	public String courierID;
	public ArrayList<String> orderNumbers;
	//pay
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
	
	public BussinessProcessExportVO(DebitAndPayBillVO vo) {
		ReceiptType type = vo.type;
		System.out.println(type);
		this.ID=vo.ID;
		this.date=vo.date;
		this.money=vo.money;
		this.type=type;
		if(type==ReceiptType.DEBIT){
			this.courierID=((DebitBillVO)vo).courierID;
			this.orderNumbers=((DebitBillVO)vo).orderNumbers;
		}
		else {
			this.payerName=((PaymentBillVO)vo).payerName;
			this.accountID=((PaymentBillVO)vo).accountID;
			this.items=((PaymentBillVO)vo).items;
			this.remarks=((PaymentBillVO)vo).remarks;
		}
	}
	
}
