package dataservice.inventorydataservice;

import java.util.ArrayList;
import po.InventoryPO;
import state.ResultMessage;

public interface InventoryDataService {
	/**初始化持久数据**/
	public void init();
	/**得到入库单ID**/
	public String getImportID ();
	/**得到出库单ID**/
	public String getExportID ();
	/**得到调整单ID**/
	public String getAlarmID ();
	/**返回所有库存单据的数据**/
	public ArrayList<InventoryPO> show();
	/**增加一条po数据即生成单据**/
	public ResultMessage insert(InventoryPO po);
}
