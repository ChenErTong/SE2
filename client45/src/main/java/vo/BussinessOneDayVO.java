package vo;

import java.util.ArrayList;

import businesslogic.fundbl.DebitAndPayBill;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

public class BussinessOneDayVO {
	
	public ArrayList<DebitAndPayBillVO> DebitBills;
	double earnings;
	public BussinessOneDayVO(ArrayList<DebitAndPayBillVO> debitBills, double earnings) {
		super();
		DebitBills = debitBills;
		this.earnings = earnings;
	}
	
	
}
