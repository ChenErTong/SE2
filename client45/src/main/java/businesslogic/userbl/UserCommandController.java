package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import command.CommandController;
import po.UserPO;
import vo.Command;

public class UserCommandController extends CommandController<UserPO>{
	
	public UserCommandController(String commandFile){
		super(commandFile);
	}
	
	@Override
	public void redoCommand() throws  RemoteException {
		UserController usercontroller = null;
		try {
			usercontroller = ControllerFactory.getUserController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<UserPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			usercontroller.addUser(UserTrans.transPOtoVO(redoCommand.po));
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
