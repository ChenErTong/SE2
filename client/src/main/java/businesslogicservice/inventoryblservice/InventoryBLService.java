package businesslogicservice.inventoryblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import state.ResultMessage;
import vo.CommodityVO;
import vo.InventoryCheckVO;
import vo.InventoryPositionVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月2日 下午3:42:51
 */
public interface InventoryBLService {
	/**
	 * 库存查看 查看一段时间内某个中转中心的入库单数量 出库单数量
	 * 
	 * @param transferID
	 *            中转中心ID
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return 库存查看VO(里面有库存)
	 */
	public InventoryViewVO viewInventory(String transferID, String beginDate, String endDate) throws RemoteException;

	/**
	 * 显示截至盘点当日时间的库存快照
	 * 
	 * @throws RemoteException
	 */
	public InventoryCheckVO checkRecord(String transferId, String date) throws RemoteException;

	/* 入库 */
	/**
	 * 得到该入库单的编号
	 * 
	 * @throws RemoteException
	 **/
	public String getImportID() throws RemoteException;

	/**
	 * 选择进行入库的货物添加信息到进货单
	 * 
	 * @throws RemoteException
	 **/
	public InventoryImportReceiptVO addCommodities(String transferID, CommodityVO commodity, int area, int row,
			int frame, int position) throws RemoteException;

	/** 选择并添加相应的数据（订单托运编号、入库日期、目的地、区号、排号、架号、位号）到进货单中生成进货单PO **/

//	public ResultMessage saveImport(InventoryImportReceiptVO importReceipt) throws RemoteException;

	/** 单据被提交发送给经理进行审批 **/
//	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) throws RemoteException;

	/* 出库 */
	/**
	 * 得到该出库单的编号
	 * 
	 * @throws RemoteException
	 **/
	public String getExportID() throws RemoteException;

	/**
	 * 选择进行出库的货物添加信息到出库单
	 * 
	 * @throws RemoteException
	 **/
	public InventoryExportReceiptVO minusCommodities(String transferID, int area, int row, int frame, int position)
			throws RemoteException;

	/* 调整 */
	/**
	 * 得到该调整单的编号
	 * 
	 * @throws RemoteException
	 **/
	public String getAdjustID() throws RemoteException;

	/**
	 * 输入被调整货物的订单托运编号、原先区号、排号、架号、位号及调整后的区号、排号、架号、位号
	 * 
	 * @throws RemoteException
	 **/
	public ResultMessage adjust(String transferID, int exArea, int exRow, int exFrame, int exPosition, int afArea,
			int afRow, int afFrame, int afPosition) throws RemoteException;

	/**
	 * 仓库使用比例
	 * 
	 * @param transferID
	 *            中转中心编号
	 * @return 使用比例百分比
	 */
	public double inventoryAlarmRate(String transferID) throws RemoteException;

	/**
	 * 将库存盘点的结果导出到excel表格
	 * 
	 * @param vo
	 */
	public void exportToExcel(InventoryCheckVO vo) throws RemoteException;

	/**
	 * 获得仓库中已有的商品及其位置
	 * 
	 * @param transferID
	 *            中转中心编号
	 * @return
	 */
	public ArrayList<InventoryPositionVO> getCommoditiesInInventory(String transferID) throws RemoteException;

	/**
	 * 获得仓库中的空位置
	 * 
	 * 我两个返回值的都写了 你想用哪个就用哪个吧
	 * 
	 * @param transferID
	 *            中转中心编号
	 * @return 空位置
	 */
	public ArrayList<InventoryPositionVO> getEmptyPositionsInList(String transferID) throws RemoteException;

	public CommodityPO[][][][] getEmptyPositionsInArray(String transferID) throws RemoteException;
}
