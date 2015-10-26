package dataservice.inventorydataservice;

import java.util.ArrayList;

import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;

public class _Inventory_Data_Stub implements InventoryDataService{

	@Override
	public void init() {
		System.out.println("Succeed in initing the inventory data.");
	}

	@Override
	public String getImportID() {
		System.out.println("Succeed in getting the import receipt id.");
		return "0123456789";
	}

	@Override
	public String getExportID() {
		System.out.println("Succeed in getting the export receipt id.");
		return "0123456789";
	}

	@Override
	public String getAdjustID() {
		System.out.println("Succeed in getting the adjusting receipt id.");
		return "0123456789";
	}


	@Override
	public int getASize() {
		System.out.println("Succeed in getting the size of row.");
		return 100;
	}

	@Override
	public int getBSize() {
		System.out.println("Succeed in getting the size of block.");
		return 100;
	}

	@Override
	public int getCSize() {
		System.out.println("Succeed in getting the size of frame.");
		return 100;
	}

	@Override
	public int getDSize() {
		System.out.println("Succeed in getting the size of position.");
		return 100;
	}

	@Override
	public int getANum() {
		System.out.println("Succeed in getting the capacity of row.");
		return 50;
	}

	@Override
	public int getBNum() {
		System.out.println("Succeed in getting the capacity of block.");
		return 50;
	}

	@Override
	public int getCNum() {
		System.out.println("Succeed in getting the capacity of frame.");
		return 50;
	}

	@Override
	public int getDNum() {
		System.out.println("Succeed in getting the capacity of position.");
		return 50;
	}

	@Override
	public ArrayList<InventoryImportReceiptPO> showImport() {
		ArrayList<InventoryImportReceiptPO> iirPOs = new ArrayList<InventoryImportReceiptPO>();
		InventoryImportReceiptPO iirPO = new InventoryImportReceiptPO("0159100143", "Nanjing", 1, 1, 1, 1);
		iirPOs.add(iirPO);
		System.out.println("Succeed in showing the import receipts.");
		return iirPOs;
	}

	@Override
	public ArrayList<InventoryExportReceiptPO> showExport() {
		ArrayList<InventoryExportReceiptPO> ierPOs = new ArrayList<InventoryExportReceiptPO>();
		InventoryExportReceiptPO ierPO = new InventoryExportReceiptPO("0159100143", "Shanghai", "plane");
		ierPOs.add(ierPO);
		System.out.println("Succeed in showing the export receipts.");
		return ierPOs;
	}

	@Override
	public ArrayList<AdjustReceiptPO> showAdjust() {
		ArrayList<AdjustReceiptPO> arPOs = new ArrayList<AdjustReceiptPO>();
		AdjustReceiptPO arPO = new AdjustReceiptPO("1234567890", 1, 1, 1, 1, 2, 2, 2, 2);
		arPOs.add(arPO);
		System.out.println("Succeed in showing the adjusting receipts.");
		return arPOs;
	}

	@Override
	public ResultMessage insertImport(InventoryImportReceiptPO po) {
		System.out.println("Succeed in inserting the import receipts.");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertExport(InventoryExportReceiptPO po) {
		System.out.println("Succeed in inserting the export receipts.");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertAdjust(AdjustReceiptPO po) {
		System.out.println("Succeed in inserting the adjusting receipts.");
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getA() {
		System.out.println("Succeed in getting the block number.");
		return 1;
	}

	@Override
	public int getB() {
		System.out.println("Succeed in getting the row number.");
		return 1;
	}

	@Override
	public int getC() {
		System.out.println("Succeed in getting the frame number.");
		return 1;
	}

	@Override
	public int getD() {
		System.out.println("Succeed in getting the position number.");
		return 1;
	}
}