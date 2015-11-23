package dataservice.branchdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.BranchPO;
/**
 * 先不写注释了，之后再补
 * @author Ann
 *
 */
public interface BranchDataService extends ManageDataService<BranchPO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BranchData";
	public String getID() throws RemoteException;

	
}
