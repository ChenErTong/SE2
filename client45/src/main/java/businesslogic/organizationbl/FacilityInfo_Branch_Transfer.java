package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.FacilityVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:56
 */
public interface FacilityInfo_Branch_Transfer {
	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) throws RemoteException;
}
