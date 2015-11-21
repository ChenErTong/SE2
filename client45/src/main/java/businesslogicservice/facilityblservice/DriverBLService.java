package businesslogicservice.facilityblservice;

import java.util.ArrayList;

import businesslogicservice.BLService;
import state.ResultMessage;
import vo.FacilityVO;
import vo.accountvo.DriverVO;

public interface DriverBLService  extends BLService{

	/**
	 * 新增车辆
	 * @param driver 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage addDriver(DriverVO driver);
	
	/**
	 * 删除车辆
	 * @param driver 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage deleteDriver (DriverVO driver);
	
	/**
	 * 修改车辆信息
	 * @param driver 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage modifyDriver (DriverVO driver);

	/**
	 * 根据车辆编号查找车辆信息
	 * @param driverId 车辆编号
	 * @return 车辆可视化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ArrayList<DriverVO> findDriver ();
}
