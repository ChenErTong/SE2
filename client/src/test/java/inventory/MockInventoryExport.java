package inventory;

import po.receiptpo.InventoryExportReceiptPO;
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
		return null;
	}

	public String getTransfer() {
		return "car";
	}

	public String getTransferID() {
		return "TransID";
	}

	public InventoryExportReceiptPO buildImport() {
		return null;
/*		InventoryVO iv = null;
//		int area = iv.area;
//		int row= iv.row;
//		int frame = iv.frame;
//		int position = iv.position;
		String ID = "1";
		String destination = "nanjing";
		String CommoditiesID = "nanjing520";
		ExpressType Transfer = ExpressType.Car;
		String TransferID = "TransID";
		String depture = null;
		InventoryExportReceiptPO ier = new InventoryExportReceiptPO(ID, null, destination, depture, Transfer,
				TransferID, CommoditiesID, area, row, frame, position);
		return ier;
*/
	}

	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		return SUCCESS;
	}
}