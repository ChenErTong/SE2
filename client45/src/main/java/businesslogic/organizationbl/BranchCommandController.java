package businesslogic.organizationbl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import businesslogic.branchbl.BranchTrans;
import po.BranchPO;
import util.SerSaveAndLoad;
import vo.Command;

public class BranchCommandController{
	private SerSaveAndLoad<Command<BranchPO>> serDoer;
	private SerSaveAndLoad<Command<BranchPO>> serRedoer;
	private static String PRIFIX = "commandHistory";
	private static String POFIX = ".ser";
	public BranchCommandController(String commandFile) throws MalformedURLException, RemoteException, NotBoundException{
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<BranchPO> command){
		serDoer.add(command);
	}
	
	public void redoCommand() throws RemoteException{
		OrganizationController controller = null;
		try {
			controller = ControllerFactory.getOrganizationController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<BranchPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			controller.addBranch(BranchTrans.convertPOtoVO(redoCommand.po));
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
