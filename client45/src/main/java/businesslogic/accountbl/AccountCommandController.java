package businesslogic.accountbl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import po.accountpo.AccountPO;
import util.SerSaveAndLoad;
import vo.Command;

public class AccountCommandController{
	private SerSaveAndLoad<Command<AccountPO>> serDoer;
	private SerSaveAndLoad<Command<AccountPO>> serRedoer;
	private static String PRIFIX = "commandHistory";
	private static String POFIX = ".ser";
	public AccountCommandController(String commandFile) throws MalformedURLException, RemoteException, NotBoundException{
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<AccountPO> command){
		serDoer.add(command);
	}
	
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
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
