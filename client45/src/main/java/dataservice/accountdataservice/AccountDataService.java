package dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.accountpo.AccountPO;
	

public interface AccountDataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "AccountData";
	/**初始化持久数据**/
	public void init() throws RemoteException;
	public ArrayList<AccountPO> find() throws RemoteException;
	
}
