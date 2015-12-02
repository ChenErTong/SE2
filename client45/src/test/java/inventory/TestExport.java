package inventory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import state.ResultMessage;
import vo.receiptvo.InventoryExportReceiptVO;




public class TestExport {
	private ResultMessage SUCCESS = null;

	@Test
	public void testExport(){
		MockInventoryExport test=new MockInventoryExport();
		InventoryExportReceiptVO exportReceipt=new InventoryExportReceiptVO(null, null, null, null, 0, 0, 0, 0);
	    assertEquals("1",test.getExportID());
	    assertEquals("nanjing520",test.getCommodities());
	    assertEquals("nanjing",test.getDestination());
//	    assertEquals(1,(test.minusPlace()).getA());
//	    assertEquals(1,(test.minusPlace()).getB());
//	    assertEquals(1,(test.minusPlace()).getC());
//	    assertEquals(1,(test.minusPlace()).getD());
	    assertEquals("car",test.getTransfer());
	    assertEquals("TransID",test.getTransferID());
	    assertEquals(SUCCESS,test.submitExport(exportReceipt));
	}
	
}
