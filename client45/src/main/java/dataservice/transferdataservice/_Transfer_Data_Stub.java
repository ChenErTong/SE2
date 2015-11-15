package dataservice.transferdataservice;

import java.util.ArrayList;

import po.InventoryPO;
import po.TransferPO;
import po.accountpo.AccountPO;
import state.ResultMessage;

public class _Transfer_Data_Stub implements TransferDataService {

	@Override
	public ResultMessage insert(TransferPO po) {
		System.out.println("You have inserted a transfer");
		return ResultMessage.SUCCESS;
	}

	@Override
	public TransferPO find(String id) {
		TransferPO transferPO = new TransferPO(id, "2015-3-4", "Nanjing", new ArrayList<AccountPO>(), new ArrayList<InventoryPO>());
		System.out.println("You have found a transfer!");
		return transferPO;
	}

	@Override
	public ResultMessage update(TransferPO po) {
		System.out.println("You have updated a transfer");
		return ResultMessage.SUCCESS;
	}

}
