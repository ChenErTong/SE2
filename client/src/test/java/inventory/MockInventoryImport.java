package inventory;

import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryVO;
import vo.receiptvo.InventoryImportReceiptVO;

public class MockInventoryImport {

	private ResultMessage SUCCESS;

	public String getImportID() {
		return "1";
	}

	public String getCommodities() {

		return "nanjing520";
	}

	public String getDestination() {
		return "nanjing";
	}

	public InventoryVO addPlace() {

		return null;
	}

	public InventoryImportReceiptPO buildImport() {
		return null;
//		int a = iv.getA();
//		int b = iv.getB();
//		int c = iv.getC();
//		int d = iv.getD();
//		String ID = "1";
//		String destination = "nanjing";
//		String depture = null;
//		String CommoditiesID = "nanjing520";
//		int a=0;
//		int b=0;
//		int c=0;
//		int d=0;
//		InventoryImportReceiptPO iir = new InventoryImportReceiptPO(ID, null, destination, depture, CommoditiesID, a, b,
//				c, d);
//		return iir;

	}

	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {

		return SUCCESS;
	}

}
