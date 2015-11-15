package dataservice.transferdataservice;

import po.TransferPO;
import state.ResultMessage;

public interface TransferDataService {
	public ResultMessage insert(TransferPO po);
	public TransferPO find(String id);
	public ResultMessage update(TransferPO po);
}
