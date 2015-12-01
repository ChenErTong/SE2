package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.accountpo.AccountPO;

public interface AccountInfo_OpeningStock {
	public ArrayList<AccountPO> find() throws RemoteException;
}
