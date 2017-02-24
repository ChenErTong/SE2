package command;

import java.io.File;
import java.rmi.RemoteException;

import po.PersistentObject;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class CommandController<PO extends PersistentObject> {
	protected SerSaveAndLoad<Command<PO>> serDoer;
	protected SerSaveAndLoad<Command<PO>> serRedoer;
	protected static String PRIFIX = "commandHistory";
	protected static String POFIX = ".ser";
	public CommandController(String commandFile){
		serDoer = new SerSaveAndLoad<Command<PO>>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<Command<PO>>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void addCommand(Command<PO> command){
		serDoer.add(command);
		serRedoer.clear();
	}
	
	public ResultMessage undoCommand() throws RemoteException{
		Command<PO> redoCommand = serDoer.getLast();
		serDoer.removeLast();
		serRedoer.add(redoCommand);
		return redoCommand.undo();
	}

	public ResultMessage redoCommand() throws RemoteException{
		Command<PO> redoCommand = serRedoer.getLast();
		serRedoer.removeLast();
		serDoer.add(redoCommand);
		return redoCommand.execute();
	}
	
	public boolean canUndo(){
		return serDoer.isEmpty();
	}
	
	public boolean canRedo(){
		return serRedoer.isEmpty();
	}
}
