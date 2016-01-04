package vo.receiptvo;

import java.math.BigDecimal;
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
	
	public DebitBillVO(String id, ReceiptType type,String courierID,BigDecimal money,ArrayList<String> orderNumbers, String date,String bankAccountID) {
		super(id,type,money,bankAccountID);
		this.courierID=courierID;
		this.orderNumbers=orderNumbers;
	}	
}