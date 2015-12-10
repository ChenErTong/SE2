package businesslogic.userbl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import po.UserPO;
import util.SerSaveAndLoad;
import vo.Command;

public class UserCommandController{
	private SerSaveAndLoad<Command<UserPO>> serDoer;
	private SerSaveAndLoad<Command<UserPO>> serRedoer;
	private static String PRIFIX = "commandHistory";
	private static String POFIX = ".ser";
	public UserCommandController(String commandFile){
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<UserPO> command){
		serDoer.add(command);
	}
	
	public void redoCommand() throws MalformedURLException, RemoteException, NotBoundException{
		UserController usercontroller = ControllerFactory.getUserController();
		Command<UserPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			usercontroller.addUser(UserTrans.transPOtoVO(redoCommand.po));
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
