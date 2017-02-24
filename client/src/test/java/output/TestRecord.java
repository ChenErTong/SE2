package output;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
		RecordController controller = null;
		try {
			controller = new RecordController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> orderNumbers = new ArrayList<>();
		orderNumbers.add("123");
		orderNumbers.add("124");
		orderNumbers.add("125");
		DebitBillVO vo1 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers, GetDate.getDate(),"009");
		PaymentBillVO vo2 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang", "007", PayBillItem.BONUS, "超额完成任务奖金");
		ArrayList<DebitAndPayBillVO> receipt = new ArrayList<>();
		receipt.add(vo1);
		receipt.add(vo2);
		BussinessProcessVO vo = new BussinessProcessVO(receipt, GetDate.getDate(), GetDate.getDate());
		controller.exportBussinessProcessToExcel(vo,"output");
	}
}
