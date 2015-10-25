package businesslogicservice.inventoryblservice;

import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.TransferArrivalListVO;

public class _Inventory_Stub implements InventoryBLService{
	@Override
	public InventoryViewVO viewInventory(String beginDate, String endDate) {
		InventoryViewVO ivVO = new InventoryViewVO(100, 50, 5, 3, 5, 3);
		System.out.println("Succeed in showing the condition of the inventory!");
		return ivVO;
	}

	@Override
	public InventoryCheckVO checkRecord() {
		InventoryCheckVO icVO = new InventoryCheckVO(null, null, null);
		System.out.println("Succeed in showing the shortcut of the inventory!");
		return icVO;
	}

	@Override
	public String getImportID() {
		System.out.println("Succeed in getting the import receipt id!");
		return "000000000";
	}

	@Override
	public ResultMessage addCommodities(TransferArrivalListVO receipt) {
		System.out.println("Succeed in adding the commodities to the import receipt!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public InventoryImportReceiptPO buildImport() {
		InventoryImportReceiptPO iirPO = new InventoryImportReceiptPO(null, null, 0, 0, 0, 0);
		System.out.println("Succeed in producing the import receipt!");
		return iirPO;
	}

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		System.out.println("Succeed in submitting the import receipt to the top manager!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getExportID() {
		System.out.println("Succeed in getting the export receipt id!");
		return "000000000";
	}

	@Override
	public ResultMessage minusCommodities(TransferArrivalListVO receipt) {
		System.out.println("Succeed in adding the commodities to the export receipt!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public InventoryExportReceiptPO buildExport() {
		InventoryExportReceiptPO ierPO = new InventoryExportReceiptPO(null, null, null);
		System.out.println("Succeed in producing the export receipt!");
		return ierPO;
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		System.out.println("Succeed in submitting the export receipt to the top manager!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getAdjustID() {
		System.out.println("Succeed in getting the adjusting receipt id!");
		return "000000000";
	}

	@Override
	public AdjustReceiptPO adjust() {
		AdjustReceiptPO arPO =  new AdjustReceiptPO(null, null, null, null, null, null, null, null, null);
		System.out.println("Succeed in producing the adjusting receipt!");
		return arPO;
	}
}