package dataservice.inventorydataservice;

import java.util.ArrayList;

import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface InventoryDataService {
	
	/**初始化持久数据**/
	public void init();
	/**得到入库单ID**/
	public String getImportID ();
	/**得到出库单ID**/
	public String getExportID ();
	/**得到调整单ID**/
	public String getAlarmID ();
	/**得到区号**/
	public String getA();
	/**得到排号**/
	public String getB();
	/**得到架号**/
	public String getC();
	/**得到位号**/
	public String getD();
	
	/**得到区容量**/
	public String getASize();
	/**得到排号容量**/
	public String getBSize();
	/**得到架号容量**/
	public String getCSize();
	/**得到位号容量**/
	public String getDSize();
	
	/**得到区此时容量**/
	public String getANum();
	/**得到排此时容量**/
	public String getBNum();
	/**得到架此时容量**/
	public String getCNum();
	/**得到位此时容量**/
	public String getDNum();
	
	
	/**返回所有入库单据的数据**/
	public ArrayList<InventoryImportReceiptPO> showImport();
	/**返回所有出库单据的数据**/
	public ArrayList<InventoryExportReceiptPO> showExport();
	/**返回所有调整单据的数据**/
	public ArrayList<AdjustReceiptPO> showAdjust();
	
	/**增加一条po数据即生成入库单据**/
	public ResultMessage insertImport(InventoryImportReceiptPO po);
	/**增加一条po数据即生成出库单据**/
	public ResultMessage insertExport(InventoryExportReceiptPO po);
	/**增加一条po数据即生成调整单据**/
	public ResultMessage insertAdjust(AdjustReceiptPO po);

}
