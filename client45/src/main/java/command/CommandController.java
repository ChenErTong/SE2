package command;

import po.PersistentObject;
import util.SerSaveAndLoad;
import vo.Command;

public class CommandController<PO extends PersistentObject> {
	private SerSaveAndLoad<Command<PO>> serDoer;
	@SuppressWarnings("unused")
	private SerSaveAndLoad<Command<PO>> serRedoer;
	private static String PRIFIX = "commandHistory";
	private static String POFIX = ".ser";
	public CommandController(String commandFile){
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
	}
	
	public void addCommand(Command<PO> command){
		serDoer.add(command);
	}
	
	public void redoCommand(){
		
	}
}
