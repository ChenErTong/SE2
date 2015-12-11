package businesslogic.fundbl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import po.BankAccountPO;
import util.SerSaveAndLoad;
import vo.Command;

public class BankAccountCommandController{
	private SerSaveAndLoad<Command<BankAccountPO>> serDoer;
	private SerSaveAndLoad<Command<BankAccountPO>> serRedoer;
	private static String PRIFIX = "commandHistory";
	private static String POFIX = ".ser";
	public BankAccountCommandController(String commandFile) throws MalformedURLException, RemoteException, NotBoundException{
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<BankAccountPO> command){
		serDoer.add(command);
	}
	
	public void redoCommand() throws RemoteException{
		BankAccountController controller = null;
		try {
			controller = ControllerFactory.getBankAccountController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<BankAccountPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			controller.add(FundTrans.convertPOtoVO(redoCommand.po));
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
