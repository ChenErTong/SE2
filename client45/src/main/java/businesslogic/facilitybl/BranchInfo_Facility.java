package businesslogic.facilitybl;

import java.rmi.RemoteException;

import po.FacilityPO;
import po.accountpo.AccountPO;
import state.ResultMessage;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月6日 上午11:43:13 
*/
public interface BranchInfo_Facility {
	public ResultMessage addCar(FacilityPO driver) throws RemoteException;
	public ResultMessage modifyCar(FacilityPO driver) throws RemoteException;
	public ResultMessage deleteCar(FacilityPO driver) throws RemoteException;
	public ResultMessage addAccount(AccountPO account) throws RemoteException;
	public ResultMessage modifyAccount(AccountPO account) throws RemoteException;
	public ResultMessage deleteAccount(AccountPO account) throws RemoteException;
}