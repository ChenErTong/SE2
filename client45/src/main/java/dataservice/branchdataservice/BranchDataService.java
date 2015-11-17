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
	public ResultMessage insert(BranchPO po) throws RemoteException;
	public BranchPO find(String id) throws RemoteException;
	public ResultMessage update(BranchPO po) throws RemoteException;
}
