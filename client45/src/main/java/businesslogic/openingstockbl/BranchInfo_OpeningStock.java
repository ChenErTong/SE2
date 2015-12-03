package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BranchPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:58
 */
public interface BranchInfo_OpeningStock {
	public ArrayList<BranchPO> find() throws RemoteException;
}
