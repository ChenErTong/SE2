package vo;

import java.math.BigDecimal;
import java.util.ArrayList;

import vo.receiptvo.DebitBillVO;

public class BussinessOneDayVO {
	
	public ArrayList<DebitBillVO> DebitBills;
	public BigDecimal earnings;
	public BussinessOneDayVO(ArrayList<DebitBillVO> debitBills, BigDecimal earnings) {
		super();
		this.DebitBills = debitBills;
		this.earnings = earnings;
	}
}
