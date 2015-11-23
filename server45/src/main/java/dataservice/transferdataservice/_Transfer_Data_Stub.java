package dataservice.transferdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;
import po.TransferPO;
import po.accountpo.AccountPO;
import state.ResultMessage;

public class _Transfer_Data_Stub implements TransferDataService {

	@Override
	public ResultMessage add(TransferPO po) {
		System.out.println("You have inserted a transfer");
		return ResultMessage.SUCCESS;
	}

	/*@Override
	public TransferPO find(String id) {
		TransferPO transferPO = new TransferPO(id, "2015-3-4", "Nanjing", new ArrayList<AccountPO>(), new ArrayList<InventoryPO>());
		System.out.println("You have found a transfer!");
		return transferPO;
	}*/

	@Override
	public ResultMessage modify(TransferPO po) {
		System.out.println("You have updated a transfer");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		System.out.println("You have deleted a transfer");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<TransferPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
