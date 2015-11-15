package Test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import po.receiptpo.AdjustReceiptPO;



public class testAdjust {
	@Test
	public void test()throws RemoteException{
		MockAdjust Test=new MockAdjust();
		MockPlaceBefore before=new MockPlaceBefore(1, 1, 1, 1);
		MockPlaceAfter  after=new MockPlaceAfter(2, 2, 2, 2);
		Test.getAdjustID();
		Test.adjust(before, after);
		
		assertEquals("012345678",Test.getAdjustID());
		assertEquals(1,(Test.adjust(before, after)).exA);
		assertEquals(1,(Test.adjust(before, after)).exB);
		assertEquals(1,(Test.adjust(before, after)).exC);
		assertEquals(1,(Test.adjust(before, after)).exD);
		assertEquals(2,(Test.adjust(before, after)).aftA);
		assertEquals(2,(Test.adjust(before, after)).aftB);
		assertEquals(2,(Test.adjust(before, after)).aftC);
		assertEquals(2,(Test.adjust(before, after)).aftD);
		
	}
	
}
