package dataservice.recorddataservice;

import java.util.ArrayList;

import po.BussinessConditionPO;
import po.BussinessProcessPO;

/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface RecordDataService {
	/**����1. �տ2.���**/
	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate,String enddate);
	/**������Ϣ��	1. ����2. ֧����3. ����������-��֧��**/
	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate);
}
