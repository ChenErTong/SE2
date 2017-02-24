package inventory;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

public class TestView {
	@Test
	public void testView() throws RemoteException {
		MockView test = new MockView();
		test.getImportNum();
		test.getExportNum();
		test.getNum();
		test.viewInventory("20151003", "20151103");
		assertEquals(1, test.getImportNum());
		assertEquals(1, test.getExportNum());
		assertEquals(1, test.getNum());
		test.viewInventory("20151003", "20151103");
		// assertEquals(1,ivv.getImportNumber());
		// assertEquals(1,ivv.getExportNumber());
		// assertEquals(1,ivv.num);

	}

}
