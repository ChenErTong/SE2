package businesslogic.facilitybl;

import java.rmi.RemoteException;

import businesslogic.accountbl.OranizationInfo_Account;
import po.FacilityPO;
import state.ResultMessage;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月6日 上午11:43:13 
*/
public interface BranchInfo_Facility extends OranizationInfo_Account {
	public ResultMessage addCar(FacilityPO driver) throws RemoteException;
	public ResultMessage modifyCar(FacilityPO driver) throws RemoteException;
	public ResultMessage deleteCar(String branchID,String ID) throws RemoteException;
}