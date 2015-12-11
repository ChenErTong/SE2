package command;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import businesslogic.organizationbl.OrganizationController;
import businesslogic.organizationbl.transferbl.TransferTrans;
import po.TransferPO;

public class TransferCommandController extends CommandController<TransferPO> {
	
	public TransferCommandController(String commandFile){
		super(commandFile);
	}

	@Override
	public void redoCommand() throws RemoteException {
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
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}

	@Override
	public void undoCommand() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
