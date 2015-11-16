package dataservice.accountdataservice;

import java.util.ArrayList;

import po.InventoryPO;
import state.ResultMessage;
     /** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	

public interface AccountDataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "AccountData";
	/**初始化持久数据**/
	public void init();
	
}
