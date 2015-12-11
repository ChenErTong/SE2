package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import command.CommandController;
import po.FacilityPO;
import vo.Command;

public class FacilityCommandController extends CommandController<FacilityPO>{
	
	public FacilityCommandController(String commandFile) {
		super(commandFile);
	}
	
	@Override
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
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
