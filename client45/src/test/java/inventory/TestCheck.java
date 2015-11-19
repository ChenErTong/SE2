package inventory;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.InventoryCheckVO;
import vo.InventoryImportReceiptVO;



public class TestCheck {
	@Test
	public void testCheck ()throws RemoteException{
		ArrayList<InventoryImportReceiptVO> iirv=new ArrayList<InventoryImportReceiptVO>();
		InventoryCheckVO icv=new InventoryCheckVO(iirv,"010");
		MockCheck test=new MockCheck();
		test.getLotNum();
		test.checkRecord();
		assertEquals("010",test.getLotNum());
	}
	
}
