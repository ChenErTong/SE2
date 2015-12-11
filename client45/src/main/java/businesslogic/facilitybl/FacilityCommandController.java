package businesslogic.facilitybl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import po.FacilityPO;
import util.SerSaveAndLoad;
import vo.Command;

public class FacilityCommandController{
	private SerSaveAndLoad<Command<FacilityPO>> serDoer;
	private SerSaveAndLoad<Command<FacilityPO>> serRedoer;
	private static String PRIFIX = "commandHistory";
	private static String POFIX = ".ser";
	public FacilityCommandController(String commandFile) throws MalformedURLException, RemoteException, NotBoundException{
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<FacilityPO> command){
		serDoer.add(command);
	}
	
	public void redoCommand() throws RemoteException{
		FacilityController controller = null;
		try {
			controller = ControllerFactory.getFacilityController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<FacilityPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			controller.addFacility(FacilityTrans.convertPOtoVO(redoCommand.po));
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
