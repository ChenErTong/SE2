package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import command.CommandController;
import po.accountpo.DriverPO;
import vo.Command;

public class DriverCommandController extends CommandController<DriverPO> {

	public DriverCommandController(String commandFile) {
		super(commandFile);
	}

	@Override
	public void redoCommand() throws RemoteException {
		DriverController controller = null;
		try {
			controller = ControllerFactory.getDriverController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<DriverPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			controller.addDriver(FacilityTrans.convertPOtoVO(redoCommand.po));
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
