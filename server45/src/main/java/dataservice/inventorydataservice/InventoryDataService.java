package dataservice.inventorydataservice;

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
	
public interface InventoryDataService  extends DataService{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "InventoryData";
	
	public void init();
	public String getImportID ();
	public String getExportID ();
	public String getAlarmID ();
	public String getA();
	public String getB();
	public String getC();
	public String getD();
	
	public String getASize();
	public String getBSize();
	public String getCSize();
	public String getDSize();
	
	public String getANum();
	public String getBNum();
	public String getCNum();
	public String getDNum();
	
	
	public ArrayList<InventoryImportReceiptPO> showImport();
	public ArrayList<InventoryExportReceiptPO> showExport();
	public ArrayList<AdjustReceiptPO> showAdjust();
	
	public ResultMessage insertImport(InventoryImportReceiptPO po);
	public ResultMessage insertExport(InventoryExportReceiptPO po);
	public ResultMessage insertAdjust(AdjustReceiptPO po);

}
