package dataservice.transferdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.TransferPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:46:31
 */
public interface TransferDataService extends ManageDataService<TransferPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "TransferData";
	public String getID(String cityCode) throws RemoteException;
	public TransferPO find(String transferID) throws RemoteException;
}
