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

}