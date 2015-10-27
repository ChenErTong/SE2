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
	
<<<<<<< HEAD
	/**��ʼ���־�����**/
	public void init();
	/**�õ���ⵥID**/
	public String getImportID ();
	/**�õ����ⵥID**/
	public String getExportID ();
	/**�õ�������ID**/
	public String getAlarmID ();
	/**�õ�����**/
	public String getA();
	/**�õ��ź�**/
	public String getB();
	/**�õ��ܺ�**/
	public String getC();
	/**�õ�λ��**/
	public String getD();
	
	/**�õ�������**/
	public String getASize();
	/**�õ��ź�����**/
	public String getBSize();
	/**�õ��ܺ�����**/
	public String getCSize();
	/**�õ�λ������**/
	public String getDSize();
	
	/**�õ�����ʱ����**/
	public String getANum();
	/**�õ��Ŵ�ʱ����**/
	public String getBNum();
	/**�õ��ܴ�ʱ����**/
	public String getCNum();
	/**�õ�λ��ʱ����**/
	public String getDNum();
	
	
	/**����������ⵥ�ݵ�����**/
	public ArrayList<InventoryImportReceiptPO> showImport();
	/**�������г��ⵥ�ݵ�����**/
	public ArrayList<InventoryExportReceiptPO> showExport();
	/**�������е������ݵ�����**/
	public ArrayList<AdjustReceiptPO> showAdjust();
	
	/**����һ��po���ݼ�������ⵥ��**/
	public ResultMessage insertImport(InventoryImportReceiptPO po);
	/**����һ��po���ݼ����ɳ��ⵥ��**/
	public ResultMessage insertExport(InventoryExportReceiptPO po);
	/**����һ��po���ݼ����ɵ�������**/
=======
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
>>>>>>> origin/master
	public ResultMessage insertAdjust(AdjustReceiptPO po);

}
