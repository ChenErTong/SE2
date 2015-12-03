package dataservice.basedataservice;

import dataservice.ManageDataService;
import po.BasePO;

/**
 * 提供公司基本运营数据的集体载入、保存和增删改查服务
 * @author zsq
 * @author Ann
 * @version Oct 22,2015
 */
public interface BaseDataService  extends ManageDataService<BasePO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BaseData";

}
