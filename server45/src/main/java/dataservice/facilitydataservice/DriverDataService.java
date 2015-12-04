package dataservice.facilitydataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.accountpo.DriverPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:45:15
 */
public interface DriverDataService extends ManageDataService<DriverPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "DriverData";

	public DriverPO find(String id) throws RemoteException;
}
