package inventory;

import po.receiptpo.InventoryExportReceiptPO;
import state.ExpressType;
import state.ResultMessage;
import vo.InventoryVO;
import vo.receiptvo.InventoryExportReceiptVO;

public class MockInventoryExport {
	private ResultMessage SUCCESS = null;

	public String getExportID() {

		return "1";
	}

	public String getCommodities() {

		return "nanjing520";
	}

	public String getDestination() {

		return "nanjing";
	}

	public InventoryVO minusPlace() {
		InventoryVO iv = new InventoryVO(null, 1, 1, 1, 1, "full");
		return iv;
	}

	public String getTransfer() {
		return "car";
	}

	public String getTransferID() {
		return "TransID";
	}

	public InventoryExportReceiptPO buildImport() {
		InventoryVO iv = new InventoryVO(null, 1, 1, 1, 1, "full");
		int area = iv.a;
		int row= iv.b;
		int frame = iv.c;
		int position = iv.d;
		String ID = "1";
		String destination = "nanjing";
		String CommoditiesID = "nanjing520";
		ExpressType Transfer = ExpressType.Car;
		String TransferID = "TransID";
		String depture = null;
		InventoryExportReceiptPO ier = new InventoryExportReceiptPO(ID, null, destination, depture, Transfer,
				TransferID, CommoditiesID, area, row, frame, position);
		return ier;

	}

	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		return SUCCESS;
	}
}