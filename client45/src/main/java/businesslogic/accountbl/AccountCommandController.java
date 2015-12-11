package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import command.CommandController;
import po.accountpo.AccountPO;
import vo.Command;

public class AccountCommandController extends CommandController<AccountPO>{

	public AccountCommandController(String commandFile) {
		super(commandFile);
	}
	
	 
	@Override
	public void redoCommand() throws RemoteException{
		AccountController controller = null;
		try {
			controller = ControllerFactory.getAccountController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<AccountPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			controller.addAccount(AccountTrans.convertPOToVO(redoCommand.po));
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
