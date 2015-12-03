package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BranchPO;

public interface BranchInfo_OpeningStock {
	public ArrayList<BranchPO> find() throws RemoteException;
}
