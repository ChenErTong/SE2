package inventory;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.InventoryCheckVO;




public class TestCheck {
	@Test
	public void testCheck ()throws RemoteException{
		ArrayList<vo.receiptvo.InventoryImportReceiptVO> iirv=new ArrayList<vo.receiptvo.InventoryImportReceiptVO>();
		new InventoryCheckVO(iirv,"010");
		MockCheck test=new MockCheck();
		test.getLotNum();
		test.checkRecord();
		assertEquals("010",test.getLotNum());
	}
	
}
