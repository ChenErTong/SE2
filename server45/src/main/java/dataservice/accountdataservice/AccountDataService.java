package dataservice.accountdataservice;



import java.rmi.RemoteException;

import dataservice.DataService;
import po.accountpo.AccountPO;

public interface AccountDataService extends DataService<AccountPO> {
	
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "AccountData";
	
	public void init() throws RemoteException;
	
}
