package data.inventorydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.inventorydataservice.InventoryDataService;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;

public class InventoryData extends Data implements InventoryDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getImportID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExportID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlarmID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getASize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getANum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryImportReceiptPO> showImport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryExportReceiptPO> showExport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AdjustReceiptPO> showAdjust() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertImport(InventoryImportReceiptPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertExport(InventoryExportReceiptPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertAdjust(AdjustReceiptPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
