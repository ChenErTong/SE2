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
	/**
	 * 在营业厅车辆信息中添加车辆
	 * @param driver FacilityPO型，新增车辆
	 * @return 添加是否成功
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage addCar(FacilityPO driver) throws RemoteException;
	/**
	 * 在营业厅车辆信息中修改车辆信息
	 * @param driver FacilityPO型，修改车辆信息
	 * @return 修改是否成功
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage modifyCar(FacilityPO driver) throws RemoteException;
	/**
	 * 在营业厅车辆信息中删除车辆
	 * @param branchID String型，营业厅编号
	 * @param ID String型，车辆编号
	 * @return 删除是否成功
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage deleteCar(String branchID,String ID) throws RemoteException;
}