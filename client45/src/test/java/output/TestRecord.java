package output;

import java.util.ArrayList;

import businesslogic.recordbl.RecordController;
import state.PayBillItem;
import state.ReceiptType;
import util.GetDate;
import vo.BussinessProcessVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

public class TestRecord {
	public static void main(String[] args) {
		RecordController controller = new RecordController();
		ArrayList<String> orderNumbers = new ArrayList<>();
		orderNumbers.add("123");
		orderNumbers.add("124");
		orderNumbers.add("125");
		DebitBillVO vo1 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", 58.2, orderNumbers, GetDate.getDate());
		PaymentBillVO vo2 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, 25.3, "wang", "007", PayBillItem.BONUS, "超额完成任务奖金");
		ArrayList<DebitAndPayBillVO> receipt = new ArrayList<>();
		receipt.add(vo1);
		receipt.add(vo2);
		BussinessProcessVO vo = new BussinessProcessVO(receipt, GetDate.getDate(), GetDate.getDate());
		controller.exportBussinessProcessToExcel(vo);
	}
}
