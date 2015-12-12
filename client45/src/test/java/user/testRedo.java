package user;

import java.rmi.RemoteException;

import command.CommandController;
import po.accountpo.AccountPO;

public class testRedo {
	public static void main(String[] args) {
		CommandController<AccountPO> commandManager= new CommandController<AccountPO>("user");
		try {
			commandManager.redoCommand();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
