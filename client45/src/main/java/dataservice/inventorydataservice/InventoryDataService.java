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
	/**初始化持久数据**/
	public void init() throws RemoteException;
	/**得到入库单ID**/
	public String getImportID () throws RemoteException;
	/**得到出库单ID**/
	public String getExportID () throws RemoteException;
	/**得到调整单ID**/
	public String getAdjustID () throws RemoteException;
	/**得到区号**/
	public int getA() throws RemoteException;
	/**得到排号**/
	public int getB() throws RemoteException;
	/**得到架号**/
	public int getC() throws RemoteException;
	/**得到位号**/
	public int getD() throws RemoteException;
	
	/**得到区容量**/
	public int getASize() throws RemoteException;
	/**得到排号容量**/
	public int getBSize() throws RemoteException;
	/**得到架号容量**/
	public int getCSize() throws RemoteException;
	/**得到位号容量**/
	public int getDSize() throws RemoteException;
	
	/**得到区此时容量**/
	public int getANum() throws RemoteException;
	/**得到排此时容量**/
	public int getBNum() throws RemoteException;
	/**得到架此时容量**/
	public int getCNum() throws RemoteException;
	/**得到位此时容量**/
	public int getDNum() throws RemoteException;
	
	
	/**返回所有入库单据的数据**/
	public ArrayList<InventoryImportReceiptPO> showImport() throws RemoteException;
	/**返回所有出库单据的数据**/
	public ArrayList<InventoryExportReceiptPO> showExport() throws RemoteException;
	/**返回所有调整单据的数据**/
	public ArrayList<AdjustReceiptPO> showAdjust() throws RemoteException;
	
	/**增加一条po数据即生成入库单据**/
	public ResultMessage insertImport(InventoryImportReceiptPO po) throws RemoteException;
	/**增加一条po数据即生成出库单据**/
	public ResultMessage insertExport(InventoryExportReceiptPO po) throws RemoteException;
	/**增加一条po数据即生成调整单据**/
	public ResultMessage insertAdjust(AdjustReceiptPO po) throws RemoteException;
}
