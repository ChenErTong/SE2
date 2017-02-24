package dataservice.accountdataservice;


import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.accountpo.AccountPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:44:52
 */
public interface AccountDataService extends ManageDataService<AccountPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "AccountData";

	public AccountPO find(String accountID) throws RemoteException;

}
