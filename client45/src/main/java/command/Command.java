package command;

import java.io.Serializable;

import po.PersistentObject;

public class Command<PO extends PersistentObject> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String command;
	public PO po;
	public Command(String command, PO po) {
		this.command = command;
		this.po = po;
	}
	
//	public abstract void execute();
}
