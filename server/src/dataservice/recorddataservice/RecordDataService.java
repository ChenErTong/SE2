package dataservice.recorddataservice;

import java.util.ArrayList;

<<<<<<< HEAD
import po.BussinessConditionPO;
import po.BussinessProcessPO;

=======
import po.receiptpo.ReceiptPO;
>>>>>>> origin/master
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface RecordDataService {
<<<<<<< HEAD
	/**����1. �տ2.���**/
	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate,String enddate);
	/**������Ϣ��	1. ����2. ֧����3. ����������-��֧��**/
	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate);
=======
	/**返回1. 收款单2.付款单**/
	public ArrayList<ReceiptPO> getBusinessProcess(String item);
	/**返回信息：	1. 收入2. 支出。3. 利润：总收入-总支出**/
	public ArrayList<ReceiptPO> getBusinessCondition(String item);

>>>>>>> origin/master
}
