package businesslogicservice.inventoryblservice;

import po.InventoryPO;
import po.receiptpo.ReceiptPO;
import vo.CommodityVO;
import vo.InventoryCheckVO;
import vo.InventoryExportReceiptVO;
import vo.InventoryImportReceiptVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptpo.ReceiptVO;

public interface InventoryBLService {
	/**绯荤粺鏄剧ず姝ゆ椂闂存鍐呯殑鍑哄叆搴撴暟閲忋�侀噾棰濄�佸簱瀛樹綅缃�**/
	public InventoryViewVO viewInventory(String beginDate, String endDate);
	
	/**鏄剧ず鎴嚦鐩樼偣鏃堕棿鐨勫簱瀛樺揩鐓�**/
	public InventoryCheckVO checkRecord( );
	
	/*鍏ュ簱*/
	/**寰楀埌璇ュ叆搴撳崟鐨勭紪鍙�**/
	public String getImportID ();
	
	/**閫夋嫨杩涜鍏ュ簱鐨勮揣鐗╂坊鍔犱俊鎭埌杩涜揣鍗�**/
	public void addCommodities(ReceiptVO receipt);
	
	/**閫夋嫨骞舵坊鍔犵浉搴旂殑鏁版嵁锛堣鍗曟墭杩愮紪鍙枫�佸叆搴撴棩鏈熴�佺洰鐨勫湴銆佸尯鍙枫�佹帓鍙枫�佹灦鍙枫�佷綅鍙凤級鍒拌繘璐у崟涓敓鎴愯繘璐у崟PO**/
	public ReceiptPO   buildImport();
	
	/**鍗曟嵁琚彁浜ゅ彂閫佺粰缁忕悊杩涜瀹℃壒**/
	public InventoryImportReceiptVO submitImport();
	
	/*鍑哄簱*/
	/**寰楀埌璇ュ嚭搴撳崟鐨勭紪鍙�**/
	public String getExportID ();
	
	/**閫夋嫨杩涜鍑哄簱鐨勮揣鐗╂坊鍔犱俊鎭埌鍑哄簱鍗�**/
	public void minusCommodities(ReceiptVO receipt);
	
	/**閫夋嫨骞舵坊鍔犵浉搴旂殑鏁版嵁锛堣鍗曟墭杩愮紪鍙枫�佸嚭搴撴棩鏈熴�佺洰鐨勫湴銆佽杩愬舰寮忋�佷腑杞崟缂栧彿锛夊埌鍑哄簱鍗曚腑鐢熸垚鍑哄簱鍗昉O**/
	public ReceiptPO buildExport();
	
	/**鍗曟嵁琚彁浜ゅ彂閫佺粰缁忕悊杩涜瀹�**/
	public InventoryExportReceiptVO submitExport();
	
	/*璋冩暣*/
	/**寰楀埌璇ヨ皟鏁村崟鐨勭紪鍙�**/
	public String getAdjustID ();
	
	/**杈撳叆琚皟鏁磋揣鐗╃殑璁㈠崟鎵樿繍缂栧彿銆佸師鍏堝尯鍙枫�佹帓鍙枫�佹灦鍙枫�佷綅鍙峰強璋冩暣鍚庣殑鍖哄彿銆佹帓鍙枫�佹灦鍙枫�佷綅鍙�**/
	public ReceiptPO adjust( );

}
