package transfer;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import state.CommodityState;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

public class TestTransfer {

	@Test
	public void testTransfer() {
//		assertTrue(true);
		MockTransfer mockTransfer = null;
		try {
			mockTransfer = new MockTransfer();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> orders = new ArrayList<String>();
		orders.add("My Name is SIDALIN");
		orders.add("Head first CPP");
		mockTransfer.planeDepart("SD1984", "哈尔滨", "齐齐哈尔", "老王", orders);
		TransferOrderVO transferOrderVO = mockTransfer.getTransferOrderVO();
		assertEquals(orders, transferOrderVO.orders);
		
		mockTransfer.receiptArrive("ZZ001", "Nanjing", "shanghai", CommodityState.Complete, orders);
		 mockTransfer.getTransferArrivalListVO();
//		assertEquals(orders, transferArrivalListVO.order);
		
		
	}

}
