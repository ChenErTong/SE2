package transfer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import state.CommodityState;
import vo.receiptvo.TransferArrivalListVO;
import vo.receiptvo.TransferOrderVO;

public class TestTransfer {

	@Test
	public void testTransfer() {
//		assertTrue(true);
		MockTransfer mockTransfer = new MockTransfer();
		ArrayList<String> orders = new ArrayList<String>();
		orders.add("My Name is SIDALIN");
		orders.add("Head first CPP");
		mockTransfer.planeDepart("SD1984", "哈尔滨", "齐齐哈尔", "老王", orders);
		TransferOrderVO transferOrderVO = mockTransfer.getTransferOrderVO();
		assertEquals(orders, transferOrderVO.orders);
		
		mockTransfer.receiptArrive("ZZ001", "Nanjing", "shanghai", CommodityState.Success, orders);
		TransferArrivalListVO transferArrivalListVO = mockTransfer.getTransferArrivalListVO();
		assertEquals(orders, transferArrivalListVO.orders);
		
		
	}

}
