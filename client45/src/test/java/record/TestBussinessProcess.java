package record;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;


public class TestBussinessProcess {
	@Test
	public void testBP()throws RemoteException{
		ArrayList<DebitBillVO> incomeReceipt = null;
		ArrayList<PaymentBillVO> expenReceipt = null;
//		BusinessProcessList bpl=new BusinessProcessList("20151003","20151103");
//		BussinessProcessVO vo=bpl.BussinessProcess("20151003","20151103");
//		assertEquals(vo.getExpenReceipt(),expenReceipt);
//		assertEquals(vo.getIncomeReceipt(),incomeReceipt);
		
		
	}
	
}
