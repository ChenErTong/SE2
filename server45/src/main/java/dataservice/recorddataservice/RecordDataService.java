package dataservice.recorddataservice;

import java.util.ArrayList;

import dataservice.DataService;
import po.BussinessConditionPO;
import po.BussinessProcessPO;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public interface RecordDataService extends DataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "RecordData";

	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate, String enddate);

	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate);
}
