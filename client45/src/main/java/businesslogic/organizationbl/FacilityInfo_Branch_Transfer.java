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
	/**
	 * 根据营业厅编号获取该营业厅所有的车辆
	 * 
	 * @param branchID
	 *            String型，营业厅编号
	 * @return ArrayList<FacilityVO>型，该营业厅所有的车辆
	 * @throws RemoteException
	 */
	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) throws RemoteException;
}
