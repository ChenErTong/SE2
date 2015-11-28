package po;

import java.util.ArrayList;

import po.receiptpo.DebitAndPayBillPO;


public class BussinessOneDayPO {
	public ArrayList<DebitAndPayBillPO> DebitBills;
	double earnings;
	public BussinessOneDayPO(ArrayList<DebitAndPayBillPO> debitBills, double earnings) {
		super();
		DebitBills = debitBills;
		this.earnings = earnings;
	}
}
