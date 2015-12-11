package businesslogic.organizationbl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import businesslogic.transferbl.TransferTrans;
import po.TransferPO;
import util.SerSaveAndLoad;
import vo.Command;

public class TransferCommandController{
	private SerSaveAndLoad<Command<TransferPO>> serDoer;
	private SerSaveAndLoad<Command<TransferPO>> serRedoer;
	private static String PRIFIX = "commandHistory";
	private static String POFIX = ".ser";
	public TransferCommandController(String commandFile) throws MalformedURLException, RemoteException, NotBoundException{
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<TransferPO> command){
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
		Command<TransferPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			controller.addTransfer(TransferTrans.convertPOtoVO(redoCommand.po));
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
