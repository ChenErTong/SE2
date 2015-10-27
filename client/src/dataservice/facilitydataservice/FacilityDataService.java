package dataservice.facilitydataservice;

import dataservice.DataService;
import po.accountpo.AccountPO;
import po.FacilityPO;
import po.PersistentObject;
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
	
	public ResultMessage deleteFacility(FacilityPO facility);
	
	public ResultMessage modifyFacility(FacilityPO facility);
	
	public AccountPO findDriver(String id);
	
	public ResultMessage addDriver(AccountPO driver);
	
	public ResultMessage deleteDriver(AccountPO driver);
	
	public ResultMessage modifyDriver(AccountPO driver);
	
}