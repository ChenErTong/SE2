package dataservice.facilitydataservice;

import dataservice.DataService;
import po.FacilityPO;
import po.PersistentObject;
import po.accountpo.AccountPO;
import state.ResultMessage;

/**
 *提供营业厅运输工具集体载入、增改改查的服务
 *@author czw
 *@version Oct 22,2015 
 */
public interface FacilityDataService <FacilityPO extends PersistentObject>extends DataService<FacilityPO>{
	/**
	 * 根据车辆编号查找车辆
	 * @param id 车辆编号
	 * @return 车辆持久化对象，若没有找到则返回null
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public FacilityPO findFacility(String id);
	
	/**
	 * 添加车辆
	 * @param facility 车辆持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage addFacility(FacilityPO facility);
	
	/**
	 * 删除车辆
	 * @param facility 车辆持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage deleteFacility(FacilityPO facility);
	
	/**
	 * 修改车辆
	 * @param facility 车辆持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage modifyFacility(FacilityPO facility);
	
	/**
	 * 得到车辆持久化对象引用
	 * @return 车辆持久化对象
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public FacilityPO getFacility();
	
	/**
	 * 根据司机编号查找司机
	 * @param id 司机编号
	 * @return 司机持久化对象，若没有找到则返回null
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public AccountPO findDriver(String id);
	
	/**
	 * 新增司机
	 * @param driver 司机持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage addDriver(AccountPO driver);
	
	/**
	 * 删除司机
	 * @param driver 司机持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage deleteDriver(AccountPO driver);
	
	/**
	 * 修改司机
	 * @param driver 司机持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage modifyDriver(AccountPO driver);
	
	/**
	 * 得到司机持久化对象引用
	 * @return 司机持久化对象
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public AccountPO getDriver();
}