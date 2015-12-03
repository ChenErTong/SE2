package dataservice.recorddataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.BussinessProcessPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:46:26
 */
public interface BusinessProcessDataService extends ManageDataService<BussinessProcessPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BusinessProcessData";
	/**返回1. 收款单2.付款单**/
	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate, String enddate) throws RemoteException;
}
