package dataservice.openingstockdataservice;

<<<<<<< HEAD
import po.OpeningStockPO;
import state.ResultMessage;

public interface OpeningStockDataService {
	/**����һ��po����**/
	public ResultMessage add(OpeningStockPO po);
	/**��ʼ���־�����**/
	public void init();
	/**����OpeningStockPO�־�����**/
	public OpeningStockPO find(String id);
}

=======
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
import po.OpeningStockPO;
import state.ResultMessage;

public class OpeningStockDataService {
	/**增加一条po数据**/
	public ResultMessage add(OpeningStockPO po) {
		return null;
	}
	/**初始化持久数据**/
	public void init() {
	}
	/**返回OpeningStockPO持久数据**/
	public OpeningStockPO find(String id) {
		return null;
	}
}
>>>>>>> origin/master
