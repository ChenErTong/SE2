package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import command.CommandController;
import po.BankAccountPO;
import vo.Command;

public class BankAccountCommandController extends CommandController<BankAccountPO> {
	
	public BankAccountCommandController(String commandFile) {
		super(commandFile);
	}

	@Override
	public void redoCommand() throws RemoteException {
		BankAccountController controller = null;
		try {
			controller = ControllerFactory.getBankAccountController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Command<BankAccountPO> redoCommand = serDoer.getLast();
		switch (redoCommand.command) {
		case "delete":
			controller.add(FundTrans.convertPOtoVO(redoCommand.po));
			serDoer.removeLast();
			serRedoer.add(redoCommand);
			break;
		default:
			break;
		}
	}
}
