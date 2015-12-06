package dataservice.organizationdataservice;

import dataservice.DataService;

/**
 * 提供普遍的公司机构进行增删改查的操作【所以我把它直接放在dataservice的包下面了orz】
 * @author zsq
 * @author Ann
 * @version Oct 23,2015
 */
public interface OrganizationDataService extends  DataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OrganizationData";
	//这个接口好像用不到了
}
