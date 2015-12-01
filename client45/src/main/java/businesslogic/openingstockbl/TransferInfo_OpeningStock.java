package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransferPO;

public interface TransferInfo_OpeningStock {
	public ArrayList<TransferPO> find() throws RemoteException;
}
