package businesslogicservice.facilityblservice;

import businesslogicservice.BLService;
import state.ResultMessage;
import vo.AccountVO;
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
	
	/**
	 * 新增车辆
	 * @param driver 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage addDriver(AccountVO driver);
	
	/**
	 * 删除车辆
	 * @param driver 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage deleteDriver (AccountVO driver);
	
	/**
	 * 修改车辆信息
	 * @param driver 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage modifyDriver (AccountVO driver);

	/**
	 * 根据车辆编号查找车辆信息
	 * @param driverId 车辆编号
	 * @return 车辆可视化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public AccountVO findDriver (String driverId);
}