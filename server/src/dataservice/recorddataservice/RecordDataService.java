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
	/**·µ»Ø1. ÊÕ¿îµ¥2.¸¶¿îµ¥**/
	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate,String enddate);
	/**·µ»ØĞÅÏ¢£º	1. ÊÕÈë2. Ö§³ö¡£3. ÀûÈó£º×ÜÊÕÈë-×ÜÖ§³ö**/
	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate);
=======
	/**è¿”å›1. æ”¶æ¬¾å•2.ä»˜æ¬¾å•**/
	public ArrayList<ReceiptPO> getBusinessProcess(String item);
	/**è¿”å›ä¿¡æ¯ï¼š	1. æ”¶å…¥2. æ”¯å‡ºã€‚3. åˆ©æ¶¦ï¼šæ€»æ”¶å…¥-æ€»æ”¯å‡º**/
	public ArrayList<ReceiptPO> getBusinessCondition(String item);

>>>>>>> origin/master
}
