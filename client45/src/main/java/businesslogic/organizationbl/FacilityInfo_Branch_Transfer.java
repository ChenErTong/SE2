package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.FacilityVO;

public interface FacilityInfo_Branch_Transfer {
	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) throws RemoteException;
}
