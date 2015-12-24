package businesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import config.RMIConfig;
import dataservice.DataService;
import dataservice.accountdataservice.AccountDataService;
import dataservice.basedataservice.BaseDataService;
import dataservice.basedataservice.PolicyDataService;

public class DataFactory {
	private static AccountDataService accountDataService=null;
	public static DataService getData(String NAME){
			try {
				switch(NAME){
				case AccountDataService.NAME: 
					if(accountDataService==null){
						accountDataService=(AccountDataService) Naming.lookup(RMIConfig.PREFIX + AccountDataService.NAME);
					}
					return accountDataService;
				case BaseDataService.NAME:return (BaseDataService) Naming.lookup(RMIConfig.PREFIX + BaseDataService.NAME);
				case PolicyDataService.NAME:	return(PolicyDataService) Naming.lookup(RMIConfig.PREFIX + PolicyDataService.NAME);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		
		return null;
	}
	/*public static AccountDataService getAccountDataService() {
		return accountDataService;
	}*/
	

	public static void init() {
		try {
			System.out.println(accountDataService);
			accountDataService=(AccountDataService) Naming.lookup(RMIConfig.PREFIX + AccountDataService.NAME);
			System.out.println(accountDataService);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
