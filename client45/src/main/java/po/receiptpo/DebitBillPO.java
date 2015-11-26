package po.receiptpo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 收款单：收款金额
 * @author czw
 * @version Oct 23, 2015
 */
public class DebitBillPO extends DebitAndPayBillPO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DebitBillPO(String id,ReceiptType type,String courierID,double money,String Name,ArrayList<String> orderNumbers) {
		super(id, money, courierID, type, orderNumbers);
	}

}
