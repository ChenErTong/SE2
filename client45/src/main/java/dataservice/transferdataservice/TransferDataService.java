package dataservice.transferdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.TransferPO;

public interface TransferDataService extends ManageDataService<TransferPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "TransferData";
	//TODO
//	public TransferArrivalListPO  findList(String id) throws RemoteException ;
	public String getID(String cityCode) throws RemoteException;
}
