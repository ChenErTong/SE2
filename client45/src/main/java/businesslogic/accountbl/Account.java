package businesslogic.accountbl;
/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;
import vo.accountvo.AccountVO;

public class Account{
	private AccountDataService accountData;
	public Account() {
		accountData=getData();
	}
	
	public AccountDataService getData(){
		try {
			return accountData = (AccountDataService)Naming.lookup(RMIConfig.PREFIX+AccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AccountVO> show() throws RemoteException {
		return AccountTrans.convertPOstoVOs(accountData.find());
	}
	public ArrayList<AccountVO> show(String duty) throws RemoteException {
		ArrayList<AccountPO> pos = accountData.find();
		return AccountTrans.convertPOstoVOsByDuty(pos, duty);
	}

}
