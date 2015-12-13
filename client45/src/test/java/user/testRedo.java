package user;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.organizationbl.OrganizationController;

public class testRedo {
	public static void main(String[] args) {
//		CommandController<AccountPO> commandManager= new CommandController<AccountPO>("user");
		try {
//			AccountController accountController = ControllerFactory.getAccountController();
//			System.out.println(accountController.canUndo());
//			accountController.undo();
			OrganizationController organizationController = new OrganizationController();
			organizationController.undo();
			organizationController.undo();
			organizationController.redo();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
	}
}
