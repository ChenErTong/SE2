package vo.receiptvo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 收款单：收款金额
 * @author czw
 * @version Oct 23, 2015
 */
public class DebitBillVO extends DebitAndPayBillVO {
	public String courierID;
	public ArrayList<String> orderNumbers;
	public String date;
	
	public DebitBillVO(String id, ReceiptType type,String courierID,double money,ArrayList<String> orderNumbers, String date) {
		super(id,type,money);
		this.courierID=courierID;
		this.orderNumbers=orderNumbers;
		this.date = date;
	}	
}