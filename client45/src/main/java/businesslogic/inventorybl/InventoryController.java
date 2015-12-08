package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.inventoryblservice.InventoryBLService;
import po.CommodityPO;
import state.ResultMessage;
import vo.CommodityVO;
import vo.InventoryCheckVO;
import vo.InventoryPositionVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:26
 */
public class InventoryController implements InventoryBLService {
	Inventory InventoryBL = new Inventory();

	@Override
	public String getImportID() throws RemoteException {
		return InventoryBL.getImportID();
	}

	@Override
	public String getExportID() throws RemoteException {
		return InventoryBL.getExportID();
	}

	@Override
	public String getAdjustID() throws RemoteException {
		return InventoryBL.getAdjustID();
	}

	@Override
	public InventoryImportReceiptVO addCommodities(String transferID, CommodityVO commodity, int area, int row,
			int frame, int position) throws RemoteException {
		LogController.getInstance().addLog("入库");
		return InventoryBL.addCommodities(transferID, commodity, area, row, frame, position);
	}

	@Override
	public InventoryExportReceiptVO minusCommodities(String transferID, int area, int row, int frame, int position)
			throws RemoteException {
		LogController.getInstance().addLog("出库");
		return InventoryBL.minusCommodities(transferID, area, row, frame, position);
	}

	@Override
	public ResultMessage adjust(String transferID, int exArea, int exRow, int exFrame, int exPosition, int afArea,
			int afRow, int afFrame, int afPosition) throws RemoteException {
		LogController.getInstance().addLog("库存调整");
		return InventoryBL.adjust(transferID, exArea, exRow, exFrame, exPosition, afArea, afRow, afFrame, afPosition);
	}

	@Override
	public InventoryViewVO viewInventory(String transferID, String beginDate, String endDate) throws RemoteException {
		LogController.getInstance().addLog("库存查看");
		return InventoryBL.viewInventory(transferID, beginDate, endDate);
	}

	@Override
	public InventoryCheckVO checkRecord(String transferID, String date) throws RemoteException {
		LogController.getInstance().addLog("库存盘点");
		return InventoryBL.checkRecord(transferID, date);
	}

	@Override
	public ResultMessage saveImport(InventoryImportReceiptVO importReceipt) throws RemoteException {
		return InventoryBL.saveImport(importReceipt);
	}

	@Override
	public ResultMessage saveExport(InventoryExportReceiptVO exportReceipt) throws RemoteException {
		return InventoryBL.saveExport(exportReceipt);
	}

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) throws RemoteException {
		return InventoryBL.submitImport(importReceipt);
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) throws RemoteException {
		return InventoryBL.submitExport(exportReceipt);
	}

	@Override
	public ArrayList<InventoryPositionVO> getCommoditiesInInventory(String transferID) throws RemoteException {
		return InventoryBL.getCommoditiesInInventory(transferID);
	}

	@Override
	public ArrayList<InventoryPositionVO> getEmptyPositionsInList(String transferID) throws RemoteException {
		return InventoryBL.getEmptyPositionsInList(transferID);
	}

	@Override
	public CommodityPO[][][][] getEmptyPositionsInArray(String transferID) throws RemoteException {
		return InventoryBL.getEmptyPositionsInArray(transferID);
	}

	@Override
	public double inventoryAlarmRate(String transferID) throws RemoteException {
		return InventoryBL.inventoryUseRate(transferID);
	}

	@Override
	public void exportToExcel(InventoryCheckVO vo) {
		InventoryBL.exportToExcel(vo);
	}
}
