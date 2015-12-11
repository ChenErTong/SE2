package user;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.userbl.UserCommandController;

public class testRedo {
	public static void main(String[] args) {
		UserCommandController commandManager= new UserCommandController("user");
		try {
			commandManager.redoCommand();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
