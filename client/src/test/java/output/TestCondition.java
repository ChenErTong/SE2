package output;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import businesslogic.ControllerFactory;
import businesslogic.fundbl.DebitAndPayBillController;
import businesslogic.recordbl.RecordController;
import state.PayBillItem;
import state.ReceiptType;
import util.GetDate;
import vo.BussinessConditionVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

public class TestCondition {

//	@Test
	public void testCondition() {

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
		DebitBillVO vo1 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers,	GetDate.getDate(), "009");
		DebitBillVO vo2 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.1"), orderNumbers,	GetDate.getDate(), "009");
		DebitBillVO vo3 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.0"), orderNumbers,	GetDate.getDate(), "009");
		DebitBillVO vo4 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("57.9"), orderNumbers,	GetDate.getDate(), "009");
		DebitBillVO vo5 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("57.8"), orderNumbers,	GetDate.getDate(), "009");
		DebitBillVO vo6 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers,	GetDate.getDate(), "009");
		DebitBillVO vo7 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers,GetDate.getDate(), "009");
		DebitBillVO vo8 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers,	GetDate.getDate(), "009");
		DebitBillVO vo9 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers,	GetDate.getDate(), "009");
		DebitBillVO vo10 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers,GetDate.getDate(), "009");
		DebitBillVO vo11 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers,GetDate.getDate(), "009");
		DebitBillVO vo12 = new DebitBillVO("0", ReceiptType.DEBIT, "153456", new BigDecimal("58.2"), orderNumbers,GetDate.getDate(), "009");
		PaymentBillVO vo13 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang",	"007", PayBillItem.BONUS, "超额完成任务奖金");
		PaymentBillVO vo14 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang",	"007", PayBillItem.BONUS, "超额完成任务奖金");
		PaymentBillVO vo15 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang","007", PayBillItem.BONUS, "超额完成任务奖金");
		PaymentBillVO vo16 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang",	"007", PayBillItem.BONUS, "超额完成任务奖金");
		PaymentBillVO vo17 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang",	"007", PayBillItem.BONUS, "超额完成任务奖金");
		PaymentBillVO vo18 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang",	"007", PayBillItem.BONUS, "超额完成任务奖金");
		PaymentBillVO vo19 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang","007", PayBillItem.BONUS, "超额完成任务奖金");
		PaymentBillVO vo20 = new PaymentBillVO("0", GetDate.getDate(), ReceiptType.PAY, new BigDecimal("25.32"), "wang","007", PayBillItem.BONUS, "超额完成任务奖金");
		try {
		DebitAndPayBillController receipt = ControllerFactory.getDebitAndPayBillController();
		receipt.addDebitBill(vo1);
		receipt.addDebitBill(vo2);
		receipt.addDebitBill(vo3);
		receipt.addDebitBill(vo4);
		receipt.addDebitBill(vo5);
		receipt.addDebitBill(vo6);
		receipt.addDebitBill(vo7);
		receipt.addDebitBill(vo8);
		receipt.addDebitBill(vo9);
		receipt.addDebitBill(vo10);
		receipt.addDebitBill(vo11);
		receipt.addDebitBill(vo12);
		receipt.addPayBill(vo13);
		receipt.addPayBill(vo14);
		receipt.addPayBill(vo15);
		receipt.addPayBill(vo16);
		receipt.addPayBill(vo17);
		receipt.addPayBill(vo18);
		receipt.addPayBill(vo19);
		receipt.addPayBill(vo20);
			BussinessConditionVO condition = controller.bussinessCondition(GetDate.getDate());
			System.out.println(condition.totalIncome.toString());
			assertTrue(condition.totalIncome.toString().equals("697.4"));
			System.out.println(condition.totalExpen.toString());
			assertTrue(condition.totalExpen.toString().equals("202.56"));
			System.out.println(condition.profit.toString());
			assertTrue(condition.profit.toString().equals("494.84"));
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}

}
