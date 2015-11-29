package inventory;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;




public class TestCheck {
	@Test
	public void testCheck ()throws RemoteException{
		new ArrayList<vo.receiptvo.InventoryImportReceiptVO>();
		MockCheck test=new MockCheck();
		test.getLotNum();
		test.checkRecord();
		assertEquals("010",test.getLotNum());
	}
	
}
