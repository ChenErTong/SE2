package dataservice.recorddataservice;

import java.util.ArrayList;
import po.BussinessConditionPO;
import po.BussinessProcessPO;

/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface RecordDataService {
	/**返回1. 收款单2.付款单**/
	public ArrayList<BussinessProcessPO> getBusinessProcess(String begindate,String enddate);
	/**返回信息：	1. 收入2. 支出。3. 利润：总收入-总支出**/
	public ArrayList<BussinessConditionPO> getBusinessCondition(String enddate);
}
