package vo.receiptvo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 收款单：收款金额
 * @author czw
 * @version Oct 23, 2015
 */
public class DebitBillVO extends ReceiptVO {
	public String id;
	public double money;
	public String courierID;
	public ReceiptType receiptType;
	ArrayList<String> orderNumbers;
	
	public DebitBillVO(String id, ReceiptType type,String courierID,double money,ArrayList<String> orderNumbers) {
		super(id,type);
		this.courierID=courierID;
		this.money=money;
		this.orderNumbers=orderNumbers;
	}

}
