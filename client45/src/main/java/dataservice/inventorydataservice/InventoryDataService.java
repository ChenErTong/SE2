package dataservice.inventorydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
      /** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface InventoryDataService extends DataService<InventoryPO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "InventoryData";
	
	/**初始化持久数据**/
	public void init() throws RemoteException;
	/**得到入库单ID**/
	public String getImportID () throws RemoteException;
	/**得到出库单ID**/
	public String getExportID () throws RemoteException;
	/**得到调整单ID**/
	public String getAdjustID () throws RemoteException;
	/**得到inventoryid**/
	public  String getInventoryID() throws RemoteException;
	
	/**查找单据**/
	public InventoryImportReceiptPO  findImport(String importID) throws RemoteException;
	public InventoryExportReceiptPO  findExport(String exportID) throws RemoteException;
	public AdjustReceiptPO findAdjust(String adjustID) throws RemoteException;
	
	/**生成transferid**/
	public String getTransferID()throws RemoteException;
	
	/**获得位置信息**/
	public InventoryPO getInventoryPO(String id)throws RemoteException;
	
	public InventoryPO getInventoryPO(int a,int b,int c,int d)throws RemoteException;
	
	public ArrayList<InventoryPO> getInventoryPOList(String date)throws RemoteException;
	/**返回所有入库单据的数据**/
	public ArrayList<InventoryImportReceiptPO> showImport(String enddate) throws RemoteException;
	/**返回所有出库单据的数据**/
	public ArrayList<InventoryExportReceiptPO> showExport(String enddate) throws RemoteException;
	/**返回所有调整单据的数据**/
	public ArrayList<AdjustReceiptPO> showAdjust(String enddate) throws RemoteException;
	
	/** 出库数量 **/
	public int  getexportNumber(String beginDate, String endDate)throws RemoteException;
	/** 入库数量）**/
	public int getimportNumber(String beginDate, String endDate)throws RemoteException;
	/**总数量**/
	public int getNum(String beginDate, String endDate)throws RemoteException;
	
	/**增加一条po数据即生成入库单据**/
	public ResultMessage insertImport(InventoryImportReceiptPO po) throws RemoteException;
	/**增加一条po数据即生成出库单据**/
	public ResultMessage insertExport(InventoryExportReceiptPO po) throws RemoteException;
	/**增加一条po数据即生成调整单据**/
	public ResultMessage insertAdjust(AdjustReceiptPO po) throws RemoteException;

	/**增加一条po数据即生成位置单据**/
	public ResultMessage insertInventory(InventoryPO po) throws RemoteException;
	
	public ResultMessage modifyInventory(InventoryPO po,int a,int b,int c,int d,String EmptyOrFull) throws RemoteException;
	
	public ResultMessage delete(String id) throws RemoteException;
	
	public ArrayList<InventoryPO> find() throws RemoteException;
	
}
