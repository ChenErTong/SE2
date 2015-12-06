package businesslogic.transferbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.accountbl.TransferInfo_Account;
import businesslogic.inventorybl.TransferInfo_Inventory;
import businesslogic.openingstockbl.TransferInfo_OpeningStock;
import dataservice.transferdataservice.TransferDataService;
import po.TransferPO;
import po.accountpo.AccountPO;
import state.ResultMessage;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:44
 */
public class TransferInfo implements TransferInfo_OpeningStock,TransferInfo_Inventory,TransferInfo_Account{
	Transfer transfer;
	TransferDataService transferData;
	public TransferInfo() {
		transfer = new Transfer();
		transferData = transfer.getData();
	}	

	@Override
	public ArrayList<TransferPO> find() throws RemoteException {
		return  transferData.find();
	}

	@Override
	public TransferPO getTransfer(String transferID) throws RemoteException {
		return transferData.find(transferID);
	}

	@Override
	public ResultMessage addAccount(AccountPO account) throws RemoteException {
		TransferPO transfer = transferData.find(account.getOrganizationID());
		ArrayList<AccountPO> accounts = transfer.getAccounts();
		accounts.add(account);
		transfer.setAccounts(accounts);
		return transferData.add(transfer);
	}

	@Override
	public ResultMessage modifyAccount(AccountPO account) throws RemoteException {
		TransferPO transfer = transferData.find(account.getOrganizationID());
		ArrayList<AccountPO> accounts = transfer.getAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getID().equals(account.getID())) {
				accounts.set(i, account);
			}
		}
		transfer.setAccounts(accounts);
		return transferData.add(transfer);
	}
	@Override
	public ResultMessage deleteAccount(String transferID, String ID) throws RemoteException {
		TransferPO transfer = transferData.find(transferID);
		ArrayList<AccountPO> accounts = transfer.getAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getID().equals(ID)) {
				accounts.remove(i);
			}
		}
		transfer.setAccounts(accounts);
		return transferData.add(transfer);
	}

}
