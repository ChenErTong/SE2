package businesslogicservice.recordblservice;

import java.util.ArrayList;

import businesslogicservice.recordblservice.RecordBLService;
import state.ResultMessage;
import vo.BussinessConditionVO;
import vo.BussinessProcessVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

public class RecordBLService_Stub implements RecordBLService{
	public ArrayList<DebitBillVO> incomeReceipt;
	public ArrayList<PaymentBillVO> expenReceipt;
	/** 起始时间 */
	public String begin;
	/** 结束时间 */
	public String end;
	/**收入**/
	public double totalIncome;
	/**支出**/
	public double totalExpen;
	/** 利润 */
	public double profit;
	public RecordBLService_Stub(ArrayList<DebitBillVO> incomeReceipt, ArrayList<PaymentBillVO> expenReceipt,
			String begin, String end, double totalIncome, double totalExpen, double profit) {
		super();
		this.incomeReceipt = incomeReceipt;
		this.expenReceipt = expenReceipt;
		this.begin = begin;
		this.end = end;
		this.totalIncome = totalIncome;
		this.totalExpen = totalExpen;
		this.profit = profit;
	}

	@Override
	public BussinessProcessVO bussinessProcess(String begin, String end) {
		// TODO Auto-generated method stub
		return new BussinessProcessVO(incomeReceipt,expenReceipt);
	}

	@Override
	public BussinessConditionVO  bussinessCondition(String end) {
		// TODO Auto-generated method stub
		return new BussinessConditionVO(begin, end, totalIncome, totalExpen,profit);
	}

	@Override
	public double income(String end) {
		// TODO Auto-generated method stub
		return totalIncome;
	}

	@Override
	public double earning(String end) {
		// TODO Auto-generated method stub
		return totalExpen;
	}

	@Override
	public double expense(String end) {
		// TODO Auto-generated method stub
		return profit;
	}

}
