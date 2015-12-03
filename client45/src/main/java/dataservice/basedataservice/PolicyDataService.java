package dataservice.basedataservice;

import dataservice.ManageDataService;
import po.PolicyPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:45:05
 */
public interface PolicyDataService  extends ManageDataService<PolicyPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "PolicyData";
}
