package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class User {
	private UserDataService<UserPO> userData;

	@SuppressWarnings("unchecked")
	public User() {
		try {
			userData = (UserDataService<UserPO>) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + UserDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
