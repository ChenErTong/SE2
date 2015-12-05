package dataservice.receiptdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;

/**
 * 提供单据信息的查看、单据修改和单据审批的服务
 * 
 * @author zsq
 * @author Ann
 * @version Oct 22,2015
 */
public interface ReceiptDataService extends ManageDataService<ReceiptPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "ReceiptData";

	public ReceiptPO find(String ID) throws RemoteException;

	public TransferArrivalListPO findTransferArrivalList(String id) throws RemoteException;

	/** 得到入库单ID **/
	public String getImportID() throws RemoteException;

	/** 得到出库单ID **/
	public String getExportID() throws RemoteException;

	/** 得到调整单ID **/
	public String getAdjustID() throws RemoteException;

	/** 查找单据 **/
	public InventoryImportReceiptPO findImport(String importID) throws RemoteException;

	public InventoryExportReceiptPO findExport(String exportID) throws RemoteException;

	public AdjustReceiptPO findAdjust(String adjustID) throws RemoteException;

	/** 生成transferid **/
	public String getTransferArrialID() throws RemoteException;
	
	public String getBranchTruckID() throws RemoteException;
	
	public String getTransferDeliverID() throws RemoteException;

}
