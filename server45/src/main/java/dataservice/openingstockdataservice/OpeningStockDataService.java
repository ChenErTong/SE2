package dataservice.openingstockdataservice;

import dataservice.DataService;
import po.OpeningStockPO;
import state.ResultMessage;

public interface OpeningStockDataService extends DataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OpeningStockData";
	public ResultMessage add(OpeningStockPO po);
	public void init();
	public OpeningStockPO find(String id);
}

