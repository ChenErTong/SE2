package businesslogicservice.facilityblservice;

import java.util.ArrayList;

import businesslogicservice.BLService;
import state.ResultMessage;
import vo.accountvo.DriverVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:41:04
 */
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
	public DriverVO findDriver(String ID);
	public ArrayList<DriverVO> findDriver ();
	public String getID(String branchID);
}
