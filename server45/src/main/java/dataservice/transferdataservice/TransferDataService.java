package dataservice.transferdataservice;

import java.rmi.RemoteException;

import dataservice.DataService;
import po.TransferPO;
import state.ResultMessage;

public interface TransferDataService extends DataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "TransferData";

	public ResultMessage insert(TransferPO po) throws RemoteException;

	public TransferPO find(String id) throws RemoteException;

	public ResultMessage update(TransferPO po) throws RemoteException;
}
