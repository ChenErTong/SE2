package businesslogicservice.inventoryblservice;

import java.rmi.RemoteException;

import state.ResultMessage;
import vo.CommodityVO;
import vo.InventoryCheckVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
/**
 * @version Dec 2,2015
 * @author Ann
 *
 */
public interface InventoryBLService {
	/**
	 * 库存查看
	 * 查看一段时间内某个中转中心的入库单数量 出库单数量
	 * @param transferID 中转中心ID
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return 库存查看VO(里面有库存)
	 */
	public InventoryViewVO viewInventory(String transferID,String beginDate, String endDate);

	/**
	 * 显示截至盘点当日时间的库存快照
	 * 
	 * @throws RemoteException
	 */
	public InventoryCheckVO checkRecord(String transferId,String date);

	/* 入库 */
	/**
	 * 得到该入库单的编号
	 * 
	 * @throws RemoteException
	 **/
	public String getImportID();

	/**
	 * 选择进行入库的货物添加信息到进货单
	 * 
	 * @throws RemoteException
	 **/
	public InventoryImportReceiptVO addCommodities(String transferID,CommodityVO commodity, int area ,int row,int frame,int position);

	/** 选择并添加相应的数据（订单托运编号、入库日期、目的地、区号、排号、架号、位号）到进货单中生成进货单PO **/

	public ResultMessage saveImport(InventoryImportReceiptVO importReceipt);

	/** 单据被提交发送给经理进行审批 **/
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt);

	/* 出库 */
	/**
	 * 得到该出库单的编号
	 * 
	 * @throws RemoteException
	 **/
	public String getExportID();

	/**
	 * 选择进行出库的货物添加信息到出库单
	 * 
	 * @throws RemoteException
	 **/
	public InventoryExportReceiptVO minusCommodities(String transferID, int area,int row,int frame,int position);

	/** 选择并添加相应的数据（订单托运编号、出库日期、目的地、装运形式、中转单编号）到出库单中生成出库单PO **/
	public ResultMessage saveExport(InventoryExportReceiptVO exportReceipt);

	/** 单据被提交发送给经理进行审 **/
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt);

	/* 调整 */
	/**
	 * 得到该调整单的编号
	 * 
	 * @throws RemoteException
	 **/
	public String getAdjustID();

	/**
	 * 输入被调整货物的订单托运编号、原先区号、排号、架号、位号及调整后的区号、排号、架号、位号
	 * 
	 * @throws RemoteException
	 **/
	public ResultMessage adjust(String transferID, int exArea,int exRow,int exFrame,int exPosition, int afArea,int afRow,int afFrame,int afPosition);

	public double inventoryAlarm(String transferID);
	
	public void exportToExcel(InventoryCheckVO vo);
}
