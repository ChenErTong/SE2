package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;
import state.ResultMessage;
import vo.accountvo.AccountVO;
/**
 * 存取account信息
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:31:26
 */
public class Account{
	
	private AccountDataService accountData;
	public Account() {
		accountData=getData();
	}
	
	public AccountDataService getData(){
		try {
			return (AccountDataService)Naming.lookup(RMIConfig.PREFIX+AccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AccountPO> show() throws RemoteException {
		return AccountTrans.convertPOstoVOs(accountData.find());
	}
	public ArrayList<AccountPO> show(String duty) throws RemoteException {
		ArrayList<AccountPO> pos = accountData.find();
		return AccountTrans.convertPOstoVOsByDuty(pos, duty);
	}
	
	public String getID() throws RemoteException{
		return accountData.getID();
	}
	public ResultMessage addAccount(AccountPO vo) throws RemoteException{
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		return accountData.add(po);
	}
	public ResultMessage deleteAccount(String ID) throws RemoteException{
		return accountData.delete(ID);
	}
	public ResultMessage updateAccount(AccountPO vo) throws RemoteException{
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		return accountData.modify(po);
	}
	public AccountPO find(String id) throws RemoteException{
		AccountPO po = accountData.find(id);
		return AccountTrans.convertPOToVO(po);
	}

}
