package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import businesslogic.branchbl.BranchTrans;
import command.CommandController;
import po.BranchPO;
import vo.Command;

public class BranchCommandController extends CommandController<BranchPO>{
	
	public BranchCommandController(String commandFile){
		super(commandFile);
	}
	
	@Override
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
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
