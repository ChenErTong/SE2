package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import command.CommandController;
import po.BasePO;
import vo.Command;

public class BaseCommandController extends CommandController<BasePO> {

	public BaseCommandController(String commandFile) {
		super(commandFile);
	}

	@Override
	public void redoCommand() throws RemoteException {
		BaseController usercontroller = null;
		try {
			usercontroller = ControllerFactory.getBaseController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<BasePO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			usercontroller.addBase(BaseTrans.convertPOtoVO(redoCommand.po));
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
