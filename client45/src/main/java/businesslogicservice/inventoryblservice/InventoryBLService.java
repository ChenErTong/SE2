package businesslogicservice.inventoryblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.receiptbl.Receipt;
import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import state.ResultMessage;
import vo.CommodityVO;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.TransferArrivalListVO;

public interface InventoryBLService {
	 /**@author lxl
	 *  @version Oct 23,2015
	 *      **/
	
	


	/**系统显示此时间段内的出入库数量、金额、库存位置
	 * @throws RemoteException **/
	public InventoryViewVO viewInventory(String beginDate, String endDate) throws RemoteException;
	
	/**显示截至盘点时间的库存快照
	 * @throws RemoteException **/
	public InventoryCheckVO checkRecord( String enddate) throws RemoteException;
	
	/*入库*/
	/**得到该入库单的编号
	 * @throws RemoteException **/
	public String getImportID () throws RemoteException;
	
	/**选择进行入库的货物添加信息到进货单
	 * @throws RemoteException **/
	public ResultMessage addCommodities(String ArrivalListID,InventoryVO vo) throws RemoteException;
	/**选择并添加相应的数据（订单托运编号、入库日期、目的地、区号、排号、架号、位号）到进货单中生成进货单PO**/
  
    
	
	/**单据被提交发送给经理进行审批**/
	public  ResultMessage submitImport(InventoryImportReceiptVO importReceipt);
	
	/*出库*/
	/**得到该出库单的编号
	 * @throws RemoteException **/
	public String getExportID () throws RemoteException;
	
	
	/**选择进行出库的货物添加信息到出库单
	 * @throws RemoteException **/
	public ResultMessage  minusCommodities(String ImportID,String Transfer) throws RemoteException;
	/**选择并添加相应的数据（订单托运编号、出库日期、目的地、装运形式、中转单编号）到出库单中生成出库单PO**/
	
	/**单据被提交发送给经理进行审**/
	public  ResultMessage submitExport(InventoryExportReceiptVO exportReceipt);
	
	/*调整*/
	/**得到该调整单的编号
	 * @throws RemoteException **/
	public String getAdjustID () throws RemoteException;
	
	/**输入被调整货物的订单托运编号、原先区号、排号、架号、位号及调整后的区号、排号、架号、位号
	 * @throws RemoteException **/
    public ResultMessage adjust(InventoryVO before, InventoryVO now) throws RemoteException;

	



	

}
