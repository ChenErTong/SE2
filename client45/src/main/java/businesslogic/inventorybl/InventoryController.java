package businesslogic.inventorybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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
	Inventory InventoryBL ;
	
	public InventoryController() throws MalformedURLException, RemoteException, NotBoundException {
		InventoryBL = new Inventory();
	}

	/**
	 * @see InventoryBLService#getImportID()
	 */
	public String getImportID() throws RemoteException {
		return InventoryBL.getImportID();
	}

	/**
	 * @see InventoryBLService#getExportID()
	 */
	public String getExportID() throws RemoteException {
		return InventoryBL.getExportID();
	}

	/**
	 * @see InventoryBLService#getAdjustID()
	 */
	public String getAdjustID() throws RemoteException {
		return InventoryBL.getAdjustID();
	}

	/**
	 * @see InventoryBLService#addCommodities(String, CommodityVO, int, int,
	 *      int, int)
	 */
	public InventoryImportReceiptVO addCommodities(String transferID, CommodityVO commodity, int area, int row,
			int frame, int position) throws RemoteException {
		LogController.getInstance().addLog("申请入库");
		return InventoryBL.addCommodities(transferID, commodity, area, row, frame, position);
	}

	/**
	 * @see InventoryBLService#minusCommodities(String, int, int, int, int)
	 */
	public InventoryExportReceiptVO minusCommodities(String transferID, int area, int row, int frame, int position)
			throws RemoteException {
		LogController.getInstance().addLog("申请出库");
		return InventoryBL.minusCommodities(transferID, area, row, frame, position);
	}

	/**
	 * @see InventoryBLService#adjust(String, int, int, int, int, int, int, int,
	 *      int)
	 */
	public ResultMessage adjust(String transferID, int exArea, int exRow, int exFrame, int exPosition, int afArea,
			int afRow, int afFrame, int afPosition) throws RemoteException {
		LogController.getInstance().addLog("库存调整");
		return InventoryBL.adjust(transferID, exArea, exRow, exFrame, exPosition, afArea, afRow, afFrame, afPosition);
	}

	/**
	 * @see InventoryBLService#viewInventory(String, String, String)
	 */
	public InventoryViewVO viewInventory(String transferID, String beginDate, String endDate) throws RemoteException {
		LogController.getInstance().addLog("库存查看");
		return InventoryBL.viewInventory(transferID, beginDate, endDate);
	}

	/**
	 * @see InventoryBLService#checkRecord(String, String)
	 */
	public InventoryCheckVO checkRecord(String transferID, String date) throws RemoteException {
		LogController.getInstance().addLog("库存盘点");
		return InventoryBL.checkRecord(transferID, date);
	}

//	/**
//	 * @see InventoryBLService#saveImport(InventoryImportReceiptVO)
//	 */
//	public ResultMessage saveImport(InventoryImportReceiptVO importReceipt) throws RemoteException {
//		return InventoryBL.saveImport(importReceipt);
//	}
//
//	/**
//	 * @see InventoryBLService#saveExport(InventoryExportReceiptVO)
//	 */
//	public ResultMessage saveExport(InventoryExportReceiptVO exportReceipt) throws RemoteException {
//		return InventoryBL.saveExport(exportReceipt);
//	}
//
//	/**
//	 * @see InventoryBLService#submitImport(InventoryImportReceiptVO)
//	 */
//	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) throws RemoteException {
//		return InventoryBL.submitImport(importReceipt);
//	}
//
//	/**
//	 * @see InventoryBLService#submitExport(InventoryExportReceiptVO)
//	 */
//	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) throws RemoteException {
//		return InventoryBL.submitExport(exportReceipt);
//	}

	/**
	 * @see InventoryBLService#getCommoditiesInInventory(String)
	 */
	public ArrayList<InventoryPositionVO> getCommoditiesInInventory(String transferID) throws RemoteException {
		return InventoryBL.getCommoditiesInInventory(transferID);
	}

	/**
	 * @see InventoryBLService#getEmptyPositionsInList(String)
	 */
	public ArrayList<InventoryPositionVO> getEmptyPositionsInList(String transferID) throws RemoteException {
		return InventoryBL.getEmptyPositionsInList(transferID);
	}

	/**
	 * @see InventoryBLService#getEmptyPositionsInArray(String)
	 */
	public CommodityPO[][][][] getEmptyPositionsInArray(String transferID) throws RemoteException {
		return InventoryBL.getPositionsInArray(transferID);
	}

	/**
	 * @see InventoryBLService#inventoryAlarmRate(String)
	 */
	public double inventoryAlarmRate(String transferID) throws RemoteException {
		return InventoryBL.inventoryUseRate(transferID);
	}

	/**
	 * @see InventoryBLService#exportToExcel(InventoryCheckVO)
	 */
	public void exportToExcel(InventoryCheckVO vo) {
		InventoryBL.exportToExcel(vo);
	}
}
