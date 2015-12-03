package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;

public interface BankAccountInfo_OpeningStock {
	public ArrayList<BankAccountPO> find() throws RemoteException;
}
