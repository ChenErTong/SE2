package dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import state.ResultMessage;
/**
 * 提供单据信息的查看、单据修改和单据审批的服务
 * @author zsq
 * @version Oct 22,2015
 * @param <ReceiptPO>
 */
public interface ReceiptDataService extends ManageDataService<ReceiptPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "ReceiptData";
	public String getID() throws RemoteException;
	
	public ReceiptPO find(String ID) throws RemoteException;
	
	public TransferArrivalListPO  findTransferArrivalList(String id) throws RemoteException;
	
	/**得到入库单ID**/
	public String getImportID () throws RemoteException;
	/**得到出库单ID**/
	public String getExportID () throws RemoteException;
	/**得到调整单ID**/
	public String getAdjustID () throws RemoteException;
	
	
	/**查找单据**/
	public InventoryImportReceiptPO  findImport(String importID) throws RemoteException;
	public InventoryExportReceiptPO  findExport(String exportID) throws RemoteException;
	public AdjustReceiptPO findAdjust(String adjustID) throws RemoteException;
	
	/**生成transferid**/
	public String getTransferID()throws RemoteException;
	
	
	
	/**返回所有入库单据的数据**/
	public ArrayList<InventoryImportReceiptPO> showImport(String enddate) throws RemoteException;
	/**返回所有出库单据的数据**/
	public ArrayList<InventoryExportReceiptPO> showExport(String enddate) throws RemoteException;
	/**返回所有调整单据的数据**/
	public ArrayList<AdjustReceiptPO> showAdjust(String enddate) throws RemoteException;
	
	/**增加一条po数据即生成入库单据**/
	public ResultMessage insertImport(InventoryImportReceiptPO po) throws RemoteException;
	/**增加一条po数据即生成出库单据**/
	public ResultMessage insertExport(InventoryExportReceiptPO po) throws RemoteException;
	/**增加一条po数据即生成调整单据**/
	public ResultMessage insertAdjust(AdjustReceiptPO po) throws RemoteException;
	
	/** 出库数量 **/
	public int  getexportNumber(String beginDate, String endDate)throws RemoteException;
	/** 入库数量）**/
	public int getimportNumber(String beginDate, String endDate)throws RemoteException;
	/**总数量**/
	public int getNum(String beginDate, String endDate)throws RemoteException;
	
	
}
