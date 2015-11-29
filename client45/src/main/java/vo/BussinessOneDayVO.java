package vo;

import java.util.ArrayList;

import vo.receiptvo.DebitBillVO;

public class BussinessOneDayVO {
	
	public ArrayList<DebitBillVO> DebitBills;
	double earnings;
	public BussinessOneDayVO(ArrayList<DebitBillVO> debitBills, double earnings) {
		super();
		DebitBills = debitBills;
		this.earnings = earnings;
	}
	
	
}
