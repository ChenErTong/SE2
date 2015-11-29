package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public interface ReceiptInfo_Inventory {
	@Deprecated
	public <T extends ReceiptVO> ArrayList<T> showInDateByType(String begin,String end,ReceiptType type) throws RemoteException;
	public int getImportNumber(String begin,String end) throws RemoteException;
	public int getExportNumber(String begin,String end) throws RemoteException;
	/** 得到入库单ID **/
	public String getImportID() throws RemoteException;

	/** 得到出库单ID **/
	public String getExportID() throws RemoteException;

	/** 得到调整单ID **/
	public String getAdjustID() throws RemoteException;
	
	/** 生成transferid **/
	public String getTransferID() throws RemoteException;
	
	public ResultMessage add(ReceiptVO po) throws RemoteException;
	public ResultMessage modify(ReceiptVO po) throws RemoteException;
	
	public TransferArrivalListPO findTransferArrivalList(String id) throws RemoteException;
	public InventoryImportReceiptPO findImport(String importID) throws RemoteException;
}
