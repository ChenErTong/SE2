package receipt;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.receiptvo.ReceiptVO;

public class TestReceipt {

	@Test
	public void testReceipt() {
		MockReceipt mockReceipt = null;
		try {
			mockReceipt = new MockReceipt();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		ArrayList<ReceiptVO> VOs = new ArrayList<>();
		VOs.add(new ReceiptVO("BRANCH001", null));
		VOs.add(new ReceiptVO("TRANSFER056", null));
		mockReceipt.passReceipt(VOs);
	}

}
