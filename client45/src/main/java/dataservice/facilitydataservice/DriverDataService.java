package dataservice.facilitydataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.accountpo.DriverPO;

public interface DriverDataService extends ManageDataService<DriverPO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "DriverData";
	public DriverPO find(String id) throws RemoteException;
}
