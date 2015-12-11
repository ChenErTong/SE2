package command;

import po.PersistentObject;

public class CommandDelete<PO extends PersistentObject> extends Command<PO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandDelete(String command, PO po) {
		super(command, po);
	}

}
