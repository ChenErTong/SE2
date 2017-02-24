package dataservice.funddataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.BankAccountPO;

/**
 * 提供银行账户数据的集体载入、保存和增删改查服务
 * 
 * @author zsq
 * @author Ann
 * @version Oct 22,2015
 */
public interface BankAccountDataService extends ManageDataService<BankAccountPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BankAccountData";


	/**
	 * 提出创建/新增银行账户时返回账户ID
	 *
	 */
	public String getID() throws RemoteException;
	public BankAccountPO find(String bankAccountID) throws RemoteException;
}