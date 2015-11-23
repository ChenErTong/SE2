package dataservice.inventorydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.PersistentObject;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface InventoryDataService  extends DataService<PersistentObject>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "InventoryData";
	
	public void init() throws RemoteException;
	public String getImportID () throws RemoteException;
	public String getExportID () throws RemoteException;
	public String getAlarmID () throws RemoteException;
	public String getA() throws RemoteException;
	public String getB() throws RemoteException;
	public String getC() throws RemoteException;
	public String getD() throws RemoteException;
	
	public String getASize() throws RemoteException;
	public String getBSize() throws RemoteException;
	public String getCSize() throws RemoteException;
	public String getDSize() throws RemoteException;
	
	public String getANum() throws RemoteException;
	public String getBNum() throws RemoteException;
	public String getCNum() throws RemoteException;
	public String getDNum() throws RemoteException;
	
	public int getImportNum()throws RemoteException;
	public int getExportNum()throws RemoteException;
	public int getNum()throws RemoteException;
	
	public ArrayList<InventoryImportReceiptPO> showImport() throws RemoteException;
	public ArrayList<InventoryExportReceiptPO> showExport() throws RemoteException;
	public ArrayList<AdjustReceiptPO> showAdjust() throws RemoteException;
	
	public ResultMessage insertImport(InventoryImportReceiptPO po) throws RemoteException;
	public ResultMessage insertExport(InventoryExportReceiptPO po) throws RemoteException;
	public ResultMessage insertAdjust(AdjustReceiptPO po) throws RemoteException;

}
