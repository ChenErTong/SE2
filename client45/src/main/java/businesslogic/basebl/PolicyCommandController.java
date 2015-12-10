package businesslogic.basebl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import po.PolicyPO;
import util.SerSaveAndLoad;
import vo.Command;

public class PolicyCommandController{
	private SerSaveAndLoad<Command<PolicyPO>> serDoer;
	private SerSaveAndLoad<Command<PolicyPO>> serRedoer;
	private static String PRIFIX = "commandHistory";
	private static String POFIX = ".ser";
	public PolicyCommandController(String commandFile){
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<PolicyPO> command){
		serDoer.add(command);
	}
	
	public void redoCommand() throws  RemoteException {
		PolicyController usercontroller = null;
		try {
			usercontroller = ControllerFactory.getPolicyController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<PolicyPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			usercontroller.addPolicy(BaseTrans.convertPOtoVO(redoCommand.po));
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
