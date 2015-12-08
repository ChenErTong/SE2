package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.FacilityPO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:02
 */
public interface FacilityInfo_OpeningStock {
	/**
	 * 查找当前所有车辆
	 * 
	 * @return ArrayList<FacilityPO>型，车辆列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<FacilityPO> find() throws RemoteException;
}
