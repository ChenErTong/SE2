package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.FacilityPO;

public interface FacilityInfo_OpeningStock {
	public ArrayList<FacilityPO> find() throws RemoteException;
}
