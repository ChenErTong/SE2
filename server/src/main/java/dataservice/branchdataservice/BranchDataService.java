package dataservice.branchdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.BranchPO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:45:11
 */
public interface BranchDataService extends ManageDataService<BranchPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BranchData";

	public String getID(String cityCode) throws RemoteException;
	public BranchPO find(String branchID) throws RemoteException;

}
