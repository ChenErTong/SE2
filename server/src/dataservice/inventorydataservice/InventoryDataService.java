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
	/**³õÊ¼»¯³Ö¾ÃÊı¾İ**/
	public void init();
	/**µÃµ½Èë¿âµ¥ID**/
	public String getImportID ();
	/**µÃµ½³ö¿âµ¥ID**/
	public String getExportID ();
	/**µÃµ½µ÷Õûµ¥ID**/
	public String getAlarmID ();
	/**µÃµ½ÇøºÅ**/
	public String getA();
	/**µÃµ½ÅÅºÅ**/
	public String getB();
	/**µÃµ½¼ÜºÅ**/
	public String getC();
	/**µÃµ½Î»ºÅ**/
	public String getD();
	
	/**µÃµ½ÇøÈİÁ¿**/
	public String getASize();
	/**µÃµ½ÅÅºÅÈİÁ¿**/
	public String getBSize();
	/**µÃµ½¼ÜºÅÈİÁ¿**/
	public String getCSize();
	/**µÃµ½Î»ºÅÈİÁ¿**/
	public String getDSize();
	
	/**µÃµ½Çø´ËÊ±ÈİÁ¿**/
	public String getANum();
	/**µÃµ½ÅÅ´ËÊ±ÈİÁ¿**/
	public String getBNum();
	/**µÃµ½¼Ü´ËÊ±ÈİÁ¿**/
	public String getCNum();
	/**µÃµ½Î»´ËÊ±ÈİÁ¿**/
	public String getDNum();
	
	
	/**·µ»ØËùÓĞÈë¿âµ¥¾İµÄÊı¾İ**/
	public ArrayList<InventoryImportReceiptPO> showImport();
	/**·µ»ØËùÓĞ³ö¿âµ¥¾İµÄÊı¾İ**/
	public ArrayList<InventoryExportReceiptPO> showExport();
	/**·µ»ØËùÓĞµ÷Õûµ¥¾İµÄÊı¾İ**/
	public ArrayList<AdjustReceiptPO> showAdjust();
	
	/**Ôö¼ÓÒ»ÌõpoÊı¾İ¼´Éú³ÉÈë¿âµ¥¾İ**/
	public ResultMessage insertImport(InventoryImportReceiptPO po);
	/**Ôö¼ÓÒ»ÌõpoÊı¾İ¼´Éú³É³ö¿âµ¥¾İ**/
	public ResultMessage insertExport(InventoryExportReceiptPO po);
	/**Ôö¼ÓÒ»ÌõpoÊı¾İ¼´Éú³Éµ÷Õûµ¥¾İ**/
=======
	/**åˆå§‹åŒ–æŒä¹…æ•°æ®**/
	public void init();
	/**å¾—åˆ°å…¥åº“å•ID**/
	public String getImportID ();
	/**å¾—åˆ°å‡ºåº“å•ID**/
	public String getExportID ();
	/**å¾—åˆ°è°ƒæ•´å•ID**/
	public String getAlarmID ();
	/**å¾—åˆ°åŒºå·**/
	public String getA();
	/**å¾—åˆ°æ’å·**/
	public String getB();
	/**å¾—åˆ°æ¶å·**/
	public String getC();
	/**å¾—åˆ°ä½å·**/
	public String getD();
	
	/**å¾—åˆ°åŒºå®¹é‡**/
	public String getASize();
	/**å¾—åˆ°æ’å·å®¹é‡**/
	public String getBSize();
	/**å¾—åˆ°æ¶å·å®¹é‡**/
	public String getCSize();
	/**å¾—åˆ°ä½å·å®¹é‡**/
	public String getDSize();
	
	/**å¾—åˆ°åŒºæ­¤æ—¶å®¹é‡**/
	public String getANum();
	/**å¾—åˆ°æ’æ­¤æ—¶å®¹é‡**/
	public String getBNum();
	/**å¾—åˆ°æ¶æ­¤æ—¶å®¹é‡**/
	public String getCNum();
	/**å¾—åˆ°ä½æ­¤æ—¶å®¹é‡**/
	public String getDNum();
	
	
	/**è¿”å›æ‰€æœ‰å…¥åº“å•æ®çš„æ•°æ®**/
	public ArrayList<InventoryImportReceiptPO> showImport();
	/**è¿”å›æ‰€æœ‰å‡ºåº“å•æ®çš„æ•°æ®**/
	public ArrayList<InventoryExportReceiptPO> showExport();
	/**è¿”å›æ‰€æœ‰è°ƒæ•´å•æ®çš„æ•°æ®**/
	public ArrayList<AdjustReceiptPO> showAdjust();
	
	/**å¢åŠ ä¸€æ¡poæ•°æ®å³ç”Ÿæˆå…¥åº“å•æ®**/
	public ResultMessage insertImport(InventoryImportReceiptPO po);
	/**å¢åŠ ä¸€æ¡poæ•°æ®å³ç”Ÿæˆå‡ºåº“å•æ®**/
	public ResultMessage insertExport(InventoryExportReceiptPO po);
	/**å¢åŠ ä¸€æ¡poæ•°æ®å³ç”Ÿæˆè°ƒæ•´å•æ®**/
>>>>>>> origin/master
	public ResultMessage insertAdjust(AdjustReceiptPO po);

}
