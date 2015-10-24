package dataservice.recorddataservice;

import java.util.ArrayList;

import po.receiptpo.ReceiptPO;

public interface RecordDataService {
	/**返回1. 收款单2.付款单**/
	public ArrayList<ReceiptPO> getBusinessProcess(String item);
	/**返回信息：	1. 收入2. 支出。3. 利润：总收入-总支出**/
	public ArrayList<ReceiptPO> getBusinessCondition(String item);

}
