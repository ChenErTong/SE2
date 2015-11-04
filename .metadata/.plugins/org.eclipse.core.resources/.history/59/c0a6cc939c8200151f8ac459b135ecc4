package businesslogicservice.inventoryblservice;

import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.TransferArrivalListVO;

public interface InventoryBLService {
	 /**@author lxl
	 *  @version Oct 23,2015
	 *      **/
	
	/**系统显示此时间段内的出入库数量、金额、库存位置**/
	public InventoryViewVO viewInventory(String beginDate, String endDate);
	
	/**显示截至盘点时间的库存快照**/
	public InventoryCheckVO checkRecord( );
	
	/*入库*/
	/**得到该入库单的编号**/
	public String getImportID ();
	
	/**选择进行入库的货物添加信息到进货单**/
	public ResultMessage addCommodities(TransferArrivalListVO receipt);
	
	/**选择并添加相应的数据（订单托运编号、入库日期、目的地、区号、排号、架号、位号）到进货单中生成进货单PO**/
	public InventoryImportReceiptPO   buildImport();
	
	/**单据被提交发送给经理进行审批**/
	public  ResultMessage submitImport(InventoryImportReceiptVO importReceipt);
	
	/*出库*/
	/**得到该出库单的编号**/
	public String getExportID ();
	
	/**选择进行出库的货物添加信息到出库单**/
	public ResultMessage minusCommodities(TransferArrivalListVO receipt);
	
	/**选择并添加相应的数据（订单托运编号、出库日期、目的地、装运形式、中转单编号）到出库单中生成出库单PO**/
	public  InventoryExportReceiptPO buildExport();
	
	/**单据被提交发送给经理进行审**/
	public  ResultMessage submitExport(InventoryExportReceiptVO exportReceipt);
	
	/*调整*/
	/**得到该调整单的编号**/
	public String getAdjustID ();
	
	/**输入被调整货物的订单托运编号、原先区号、排号、架号、位号及调整后的区号、排号、架号、位号**/
	public AdjustReceiptPO adjust( );

}
