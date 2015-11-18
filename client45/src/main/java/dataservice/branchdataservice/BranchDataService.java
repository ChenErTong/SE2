package dataservice.branchdataservice;

import java.rmi.RemoteException;

import po.BranchPO;
import state.ResultMessage;
/**
 * 先不写注释了，之后再补
 * @author Ann
 *
 */
public interface BranchDataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BranchData";
	public ResultMessage insert(BranchPO po) throws RemoteException;
	public BranchPO find(String id) throws RemoteException;
	public ResultMessage update(BranchPO po) throws RemoteException;
}
