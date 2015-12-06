package businesslogic.accountbl;

import java.rmi.RemoteException;

import po.accountpo.AccountPO;
import state.ResultMessage;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月6日 下午1:46:55 
*/
public interface OranizationInfo_Account {
	public ResultMessage addAccount(AccountPO account) throws RemoteException;
	public ResultMessage modifyAccount(AccountPO account) throws RemoteException;
	public ResultMessage deleteAccount(String organizationID,String ID) throws RemoteException;
}
