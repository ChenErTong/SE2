package vo;

import java.util.ArrayList;

import vo.receiptvo.DebitAndPayBillVO;

public class BussinessOneDayVO {
	
	public ArrayList<DebitAndPayBillVO> DebitBills;
	double earnings;
	public BussinessOneDayVO(ArrayList<DebitAndPayBillVO> debitBills, double earnings) {
		super();
		DebitBills = debitBills;
		this.earnings = earnings;
	}
	
	
}
