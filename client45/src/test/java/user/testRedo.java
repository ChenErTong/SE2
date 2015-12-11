package user;

import java.rmi.RemoteException;

import command.UserCommandController;

public class testRedo {
	public static void main(String[] args) {
		UserCommandController commandManager= new UserCommandController("user");
		try {
			commandManager.redoCommand();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
