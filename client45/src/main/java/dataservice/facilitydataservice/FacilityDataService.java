package dataservice.facilitydataservice;

import dataservice.ManageDataService;
import po.FacilityPO;

/**
 * 提供营业厅运输工具集体载入、增改改查的服务
 * 
 * @author czw
 * @version Oct 22,2015
 */
public interface FacilityDataService extends ManageDataService<FacilityPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "FacilityData";

	/**
	 * 根据车辆编号查找车辆
	 * 
	 * @param id
	 *            车辆编号
	 * @return 车辆持久化对象，若没有找到则返回null
	 * @author czw
	 * @version Oct 22,2015
	 */
//	public FacilityPO findFacility(String id) throws RemoteException;

	/**
	 * 添加车辆
	 * 
	 * @param facility
	 *            车辆持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015
	 */
//	public ResultMessage addFacility(FacilityPO facility) throws RemoteException;

//	public ResultMessage deleteFacility(String id) throws RemoteException;

//	public ResultMessage modifyFacility(FacilityPO facility) throws RemoteException;


}