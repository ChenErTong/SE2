package dataservice.funddataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.ExpensePO;

/**
 * 提供收款信息数据的集体载入、保存和增删改查操作
 * @author zsq
 * @version Oct 23,2015
 */
@Deprecated
public interface ExpenseDataService extends ManageDataService<ExpensePO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "ExpenseData";
	
	public String getID()throws RemoteException;
}
