package businesslogicservice.recordblservice;

import java.util.ArrayList;

import businesslogicservice.recordblservice.RecordBLService;
import businesslogicservice.openingstockblservice.OpeningStockBLService_Stub;
import businesslogicservice.recordblservice.RecordBLService_Stub;
import businesslogicservice.openingstockblservice.OpeningStockBLService_Driver;
import vo.BussinessConditionVO;
import vo.BussinessProcessVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

public class RecordBLService_Driver {
	public void drive(RecordBLService recordBLService){
		double totalIncome =10000000.0;
		double profit = 20000000;
		double totalExpen = 10000000;
		ArrayList<DebitBillVO> incomeReceipt = null;
		ArrayList<PaymentBillVO> expenReceipt = null;
		String begin = "20151010";
		String end = "20151028";
		BussinessProcessVO bpvo=new BussinessProcessVO(incomeReceipt, expenReceipt);
	
		BussinessConditionVO bcvo=new BussinessConditionVO(begin, end, totalIncome, totalExpen,profit);
		
		
		bpvo=recordBLService.bussinessProcess(begin, end);
		System.out.println(begin+"到"+end+"所有收款入款单据");
		bcvo=recordBLService.bussinessCondition(end);
		System.out.println(end+"前所有收入情况");
		totalIncome=recordBLService.income(end);
		System.out.println("截止"+end+"总收入"+totalIncome);
		totalExpen=recordBLService.expense(end);
		System.out.println(	"截止"+end+"总花费"+totalExpen);
		profit=recordBLService.earning(end);
		System.out.println("截止"+end+"总利润"+profit);

	}
	 public static void main(String[] args){
			double totalIncome = 10000000.0;
			double profit =20000000;
			double totalExpen = 10000000;
			ArrayList<DebitBillVO> incomeReceipt = null;
			ArrayList<PaymentBillVO> expenReceipt = null;
			String begin = "20151010";
			String end = "20151028";
		 RecordBLService_Stub recordBLService_stub=new RecordBLService_Stub(incomeReceipt,  expenReceipt,
			 begin, end,totalIncome, totalExpen, profit);
		 RecordBLService_Driver recordBLService_driver=new RecordBLService_Driver();
		 recordBLService_driver.drive(recordBLService_stub);
}
}
