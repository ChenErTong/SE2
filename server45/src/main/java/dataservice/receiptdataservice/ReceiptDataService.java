package dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.receiptpo.ReceiptPO;
import po.receiptpo.TransferArrivalListPO;
import state.ReceiptState;
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
	
	public ArrayList<ReceiptPO> showReceipt(ReceiptState receiptStates) throws RemoteException;
	
	public ReceiptPO find(String ID) throws RemoteException;
	
	public TransferArrivalListPO  findTransferArrivalList(String id) throws RemoteException;
}
