package dataservice.recorddataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.BussinessConditionPO;

public interface BusinessConditionDataService extends ManageDataService<BussinessConditionPO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BusinessConditionData";
	/**返回信息：	1. 收入2. 支出。3. 利润：总收入-总支出**/
	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate) throws RemoteException;
}
