package businesslogicservice.facilityblservice;

import java.rmi.RemoteException;

import businesslogicservice.BLService;
import state.ResultMessage;
import vo.FacilityVO;

/**
 * 实现营业厅运输工具管理界面所需要的服务
 * @author czw
 * @version Oct 22,2015
 */
public interface FacilityBLService extends BLService{	
	/**
	 * 新增车辆
	 * @param facility 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ResultMessage addFacility(FacilityVO facility);
	
	/**
	 * 删除车辆
	 * @param facility 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage deleteFacility (FacilityVO facility);
	
	/**
	 * 修改车辆信息
	 * @param facility 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage modifyFacility (FacilityVO facility);

	/**
	 * 根据车辆编号查找车辆信息
	 * @param facilityId 车辆编号
	 * @return 车辆可视化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public FacilityVO findFacility (String facilityId);
	
}
