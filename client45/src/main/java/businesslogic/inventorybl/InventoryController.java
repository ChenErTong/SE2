package businesslogic.inventorybl;
import java.rmi.RemoteException;
import java.util.ArrayList;

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
	public String getImportID()  {
		try {
			return InventoryBL.getImportID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getExportID() {
		try {
			return InventoryBL.getExportID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAdjustID()  {
		try {
			return InventoryBL.getAdjustID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InventoryImportReceiptVO addCommodities(String transferID,CommodityVO commodity, int area ,int row,int frame,int position)  {
		try {
			return InventoryBL.addCommodities(transferID, commodity, area, row, frame, position);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public InventoryExportReceiptVO minusCommodities(String transferID, int area,int row,int frame,int position) {
		try {
			return InventoryBL.minusCommodities(transferID, area, row, frame, position);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage adjust(String transferID, int exArea,int exRow,int exFrame,int exPosition, int afArea,int afRow,int afFrame,int afPosition) {
		try {
			return InventoryBL.adjust(transferID, exArea, exRow, exFrame, exPosition, afArea, afRow, afFrame, afPosition);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InventoryViewVO viewInventory(String transferID,String beginDate, String endDate)  {
		try {
			return InventoryBL.viewInventory(transferID,beginDate, endDate);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InventoryCheckVO checkRecord(String transferID,String date){
		try {
			return InventoryBL.checkRecord(transferID,date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage saveImport(InventoryImportReceiptVO importReceipt) {
		 try {
			InventoryBL.saveImport(importReceipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage saveExport(InventoryExportReceiptVO exportReceipt) {
		 try {
			InventoryBL.saveExport(exportReceipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		try {
			return InventoryBL.submitImport(importReceipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		try {
			return InventoryBL.submitExport(exportReceipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<InventoryPositionVO> getCommoditiesInInventory(String transferID) {
		try {
			return InventoryBL.getCommoditiesInInventory(transferID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<InventoryPositionVO> getEmptyPositionsInList(String transferID) {
		try {
			return InventoryBL.getEmptyPositionsInList(transferID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CommodityPO[][][][] getEmptyPositionsInArray(String transferID) {
		try {
			return InventoryBL.getEmptyPositionsInArray(transferID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double inventoryAlarmRate(String transferID) {
		try {
			return InventoryBL.inventoryUseRate(transferID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void exportToExcel(InventoryCheckVO vo) {
		InventoryBL.exportToExcel(vo);
	}
}
