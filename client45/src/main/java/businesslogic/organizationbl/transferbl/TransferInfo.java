package businesslogic.organizationbl.transferbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.accountbl.TransferInfo_Account;
import businesslogic.inventorybl.TransferInfo_Inventory;
import businesslogic.openingstockbl.TransferInfo_OpeningStock;
import config.RMIConfig;
import dataservice.transferdataservice.TransferDataService;
import po.TransferPO;
import po.accountpo.AccountPO;
import state.ResultMessage;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:44
 */
public class TransferInfo implements TransferInfo_OpeningStock, TransferInfo_Inventory, TransferInfo_Account {
	TransferDataService transferData;

	public TransferInfo() throws MalformedURLException, RemoteException, NotBoundException {
		transferData = (TransferDataService) Naming.lookup(RMIConfig.PREFIX + TransferDataService.NAME);
	}

	/**
	 * @see TransferInfo_OpeningStock#find()
	 */
	public ArrayList<TransferPO> find() throws RemoteException {
		return transferData.find();
	}

	/**
	 * @see TransferInfo_Inventory#getTransfer(String)
	 */
	public TransferPO getTransfer(String transferID) throws RemoteException {
		return transferData.find(transferID);
	}

	/**
	 * @see TransferInfo_Account#addAccount(AccountPO)
	 */
	public ResultMessage addAccount(AccountPO account) throws RemoteException {
		TransferPO transfer = transferData.find(account.getOrganizationID());
		ArrayList<AccountPO> accounts = transfer.getAccounts();
		accounts.add(account);
		transfer.setAccounts(accounts);
		return transferData.modify(transfer)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
	}		

	/**
	 * @see TransferInfo_Account#modifyAccount(AccountPO)
	 */
	public ResultMessage modifyAccount(AccountPO account) throws RemoteException {
		TransferPO transfer = transferData.find(account.getOrganizationID());
		ArrayList<AccountPO> accounts = transfer.getAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getID().equals(account.getID())) {
				accounts.set(i, account);
			}
		}
		transfer.setAccounts(accounts);
		return transferData.modify(transfer)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
	}

	/**
	 * @see TransferInfo_Account#deleteAccount(String, String)
	 */
	public ResultMessage deleteAccount(String transferID, String ID) throws RemoteException {
		TransferPO transfer = transferData.find(transferID);
		ArrayList<AccountPO> accounts = transfer.getAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getID().equals(ID)) {
				accounts.remove(i);
			}
		}
		transfer.setAccounts(accounts);
		return transferData.modify(transfer)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
	}
	public TransferPO modify(TransferPO transferPO) throws RemoteException {
		return transferData.modify(transferPO);
	}

}
