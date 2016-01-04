package businesslogicservice.facilityblservice;

import java.rmi.RemoteException;
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
	public ResultMessage addDriver(DriverVO driver) throws RemoteException;
	
	/**
	 * 删除车辆
	 * @param driver 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage deleteDriver (DriverVO driver) throws RemoteException;
	
	/**
	 * 修改车辆信息
	 * @param driver 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage modifyDriver (DriverVO driver) throws RemoteException;

	/**
	 * 根据车辆编号查找车辆信息
	 * @param driverId 车辆编号
	 * @return 车辆可视化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public DriverVO findDriver(String ID) throws RemoteException;
	public ArrayList<DriverVO> findDriver () throws RemoteException;
	public String getID(String branchID) throws RemoteException;
	/**
	 * 是否可以进行撤销操作
	 * 
	 * @return boolean型，返回true，表示可以进行撤销操作，此时撤销按钮应设为可以按下
	 *         返回false，表示不可以进行撤销操作，此时撤销按钮应设为不可以按下
	 */
	public boolean canUndo();
	/**
	 * 是否可以进行回撤操作
	 * 
	 * @return boolean型，返回true，表示可以进行回撤操作，此时回撤按钮应设为可以按下
	 *         返回false，表示不可以进行回撤操作，此时回撤按钮应设为不可以按下
	 */
	public boolean canRedo();
	/**
	 * 执行撤销操作
	 * @return 操作结果
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage undo() throws RemoteException;
	/**
	 * 执行回撤操作
	 * @return 操作结果
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage redo() throws RemoteException;
}
