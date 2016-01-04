package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import state.ReceiptType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.ReceiptVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:42
 */
public interface ReceiptInfo_Inventory {
	/**
	 * 获得指定日期之间的单据
	 * 
	 * @param begin
	 *            String型，开始日期
	 * @param end
	 *            String型，结束日期
	 * @param type
	 *            ReceiptType型，单据类型
	 * @return <T extends ReceiptVO> ArrayList<T>型，符合条件的单据列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public <T extends ReceiptVO> ArrayList<T> showInDateByType(String begin, String end, ReceiptType type)
			throws RemoteException;

	/**
	 * 获得指定日期之间的入库数量
	 * 
	 * @param begin
	 *            String型，开始日期
	 * @param end
	 *            String型，结束日期
	 * @return int型，入库数量
	 * @throws RemoteException
	 *             远程异常
	 */
	public int getImportNumber(String begin, String end) throws RemoteException;

	/**
	 * 获得指定日期之间的出库数量
	 * 
	 * @param begin
	 *            String型，开始日期
	 * @param end
	 *            String型，结束日期
	 * @return int型，出库数量
	 * @throws RemoteException
	 *             远程异常
	 */
	public int getExportNumber(String begin, String end) throws RemoteException;

	/**
	 * 获得入库单新编号
	 * 
	 * @return String型，入库单新编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getImportID() throws RemoteException;

	/**
	 * 获得出库单新编号
	 * 
	 * @return String型，入库单新编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getExportID() throws RemoteException;

	/**
	 * 获得调整单新编号
	 * 
	 * @return String型，入库单新编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getAdjustID() throws RemoteException;

	/**
	 * 获得中转中心到达单新编号
	 * 
	 * @return String型，中转中心到达单新编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getTransferID() throws RemoteException;

	/**
	 * 添加新单据
	 * 
	 * @param vo
	 *            ReceiptVO型，新单据
	 * @return ResultMessage型，添加是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage add(ReceiptVO vo) throws RemoteException;

	/**
	 * 修改原有单据
	 * 
	 * @param vo
	 *            ReceiptVO型，原有单据
	 * @return ResultMessage型，修改是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage modify(ReceiptVO vo) throws RemoteException;

	/**
	 * 添加入库单
	 * 
	 * @param vo
	 *            CommodityVO型，商品值对象
	 * @param area
	 *            int型，区号
	 * @param row
	 *            int型，排号
	 * @param frame
	 *            int型，架号
	 * @param position
	 *            int型，位号
	 * @return InventoryImportReceiptVO型，入库单值对象
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryImportReceiptVO addImportReceipt(CommodityVO vo, int area, int row, int frame, int position,String transferID)
			throws RemoteException;

	/**
	 * 查找中转中心到达单
	 * 
	 * @param id
	 *            String型，中转中心到达单编号
	 * @return TransferArrivalListPO型，中转中心到达单持久化对象
	 * @throws RemoteException
	 *             远程异常
	 */
	public TransferArrivalListPO findTransferArrivalList(String id) throws RemoteException;

	/**
	 * 查找入库单
	 * 
	 * @param importIDString型，入库单编号
	 * @return InventoryImportReceiptPO型，入库单持久化对象
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryImportReceiptPO findImport(String importID) throws RemoteException;

	/**
	 * 检查当日是否已经盘点过
	 * 
	 * @return boolean型，返回值为true时，表明当日已经盘点过，为false时反之
	 * @throws RemoteException
	 *             远程异常
	 */
	public boolean hasChecked() throws RemoteException;
}
