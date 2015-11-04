package dataservice.openingstockdataservice;

import po.OpeningStockPO;
import state.ResultMessage;
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface OpeningStockDataService {
	/**增加一条po数据**/
	public ResultMessage add(OpeningStockPO po);
	/**初始化持久数据**/
	public void init();
	/**返回OpeningStockPO持久数据**/
	public OpeningStockPO find(String id);
}

