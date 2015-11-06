package dataservice.transferdataservice;

import dataservice.DataService;
import po.TransferPO;
import state.ResultMessage;

public interface TransferDataService extends DataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "TransferData";

	public ResultMessage insert(TransferPO po);

	public TransferPO find(String id);

	public ResultMessage update(TransferPO po);
}
