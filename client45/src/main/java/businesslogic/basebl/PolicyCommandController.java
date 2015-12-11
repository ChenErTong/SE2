package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import command.CommandController;
import po.PolicyPO;
import vo.Command;

public class PolicyCommandController extends CommandController<PolicyPO>{
	 
	public PolicyCommandController(String commandFile){
		super(commandFile);
	}
	
	 
	@Override
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
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
