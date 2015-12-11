package command;

import java.io.File;
import java.rmi.RemoteException;

import po.PersistentObject;
import util.SerSaveAndLoad;

public class CommandController<PO extends PersistentObject> {
	protected SerSaveAndLoad<Command<PO>> serDoer;
	protected SerSaveAndLoad<Command<PO>> serRedoer;
	protected static String PRIFIX = "commandHistory";
	protected static String POFIX = ".ser";
	public CommandController(String commandFile){
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<PO> command){
		serDoer.add(command);
	}
	
	public void redoCommand() throws RemoteException{
		Command<PO> redoCommand = serRedoer.getLast();
		redoCommand.execute();
		serRedoer.removeLast();
		serDoer.add(redoCommand);
	}
	
	public void undoCommand() throws RemoteException{
		Command<PO> redoCommand = serDoer.getLast();
		redoCommand.undo();
		serDoer.removeLast();
		serRedoer.add(redoCommand);
	}
}
