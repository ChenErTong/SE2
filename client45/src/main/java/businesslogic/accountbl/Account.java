package businesslogic.accountbl;
/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import dataservice.accountdataservice.AccountDataService;
import vo.accountvo.AccountVO;

public class Account implements AccountBLService{
	private AccountDataService accountData;
	public Account() {
		try {
			accountData = (AccountDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+AccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<AccountVO> show() throws RemoteException {
		return AccountTrans.POstoVOs(accountData.find());
	}
	
	


}
