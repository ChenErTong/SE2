package businesslogic.facilitybl;

import java.rmi.RemoteException;

import state.ResultMessage;
import vo.FacilityVO;
import vo.accountvo.AccountVO;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月6日 上午11:43:13 
*/
public interface BranchInfo_Facility {
	public ResultMessage addCar(FacilityVO driver) throws RemoteException;
	public ResultMessage modifyCar(FacilityVO driver) throws RemoteException;
	public ResultMessage deleteCar(FacilityVO driver) throws RemoteException;
	public ResultMessage addAccount(AccountVO account) throws RemoteException;
	public ResultMessage modifyAccount(AccountVO account) throws RemoteException;
	public ResultMessage deleteAccount(AccountVO account) throws RemoteException;
}
