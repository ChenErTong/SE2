package dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.TransferArrivalListPO;
import state.ReceiptState;
import state.ResultMessage;

public class ReceiptDataService_Stub implements ReceiptDataService{
	private ArrayList<ReceiptPO> receiptPOs;
	private ReceiptPO receiptPO_1;
	private ReceiptPO receiptPO_2;
	public ReceiptDataService_Stub(){
		receiptPOs = new ArrayList<ReceiptPO>();
//		receiptPO_1 = new ReceiptPO("123");
//		receiptPO_2 = new ReceiptPO("456");
		receiptPOs.add(receiptPO_1);
		receiptPOs.add(receiptPO_2);
	}
	@Override
	public ResultMessage modify(ReceiptPO PO) {
		System.out.println("Modify the receipt succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptPO> find() {
		System.out.println("Find all the receiptPO succeed!");
		return new ArrayList<ReceiptPO>();
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage add(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ReceiptPO> showReceipt(ReceiptState receiptStates) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ReceiptPO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TransferArrivalListPO findTransferArrivalList(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getImportID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getExportID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAdjustID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getInventoryID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public InventoryImportReceiptPO findImport(String importID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public InventoryExportReceiptPO findExport(String exportID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AdjustReceiptPO findAdjust(String adjustID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getTransferID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getLotNum() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<InventoryImportReceiptPO> showImport(String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<InventoryExportReceiptPO> showExport(String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<AdjustReceiptPO> showAdjust(String enddate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage insertImport(InventoryImportReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage insertExport(InventoryExportReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage insertAdjust(AdjustReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getexportNumber(String beginDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getimportNumber(String beginDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getNum(String beginDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
