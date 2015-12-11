package command;

import java.io.File;

import state.OrganizationType;
import util.SerSaveAndLoad;

public class OrganizationCommandDoubleStack {
	public SerSaveAndLoad<OrganizationType> serDoer;
	public SerSaveAndLoad<OrganizationType> serRedoer;
	public static String PRIFIX = "commandHistory";
	public static String POFIX = ".ser";
	public OrganizationCommandDoubleStack(String commandFile){
		serDoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+POFIX);
		serRedoer = new SerSaveAndLoad<>(PRIFIX, PRIFIX+"/"+commandFile+"Re"+POFIX);
		File serDoerFile = new File(PRIFIX+"/"+commandFile+POFIX);
		File serRedoerFile = new File(PRIFIX+"/"+commandFile+"Re"+POFIX);
		serDoerFile.deleteOnExit();
		serRedoerFile.deleteOnExit();
	}
	
	public void add(OrganizationType type){
		serDoer.add(type);
		serRedoer.clear();
	}
	
	public OrganizationType undo(){
		OrganizationType type = serDoer.getLast();
		serDoer.removeLast();
		serRedoer.add(type);
		return type;
	}
	public OrganizationType redo(){
		OrganizationType type = serRedoer.getLast();
		serRedoer.removeLast();
		serDoer.add(type);
		return type;
	}
	
	public boolean canUndo(){
		return serDoer.isEmpty();
	}
	
	public boolean canRedo(){
		return serRedoer.isEmpty();
	}
}
