package businesslogicservice.facilityblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.BLService;
import state.ResultMessage;
import vo.FacilityVO;

/**
 * 实现营业厅运输工具管理界面所需要的服务
 * @author czw
 * @author Ann
 * @version 创建时间：2015年10月22日 下午3:41:11
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
	public ResultMessage addFacility(FacilityVO facility) throws RemoteException;
	
	/**
	 * 删除车辆
	 * @param facility 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage deleteFacility (FacilityVO facility) throws RemoteException;
	
	/**
	 * 修改车辆信息
	 * @param facility 车辆可视化对象
	 * @return 处理结果
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage modifyFacility (FacilityVO facility) throws RemoteException;

	/**
	 * 根据车辆编号查找车辆信息
	 * @param facilityId 车辆编号
	 * @return 车辆可视化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public FacilityVO findFacility(String ID) throws RemoteException;
	public ArrayList<FacilityVO> findFacility () throws RemoteException;
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
