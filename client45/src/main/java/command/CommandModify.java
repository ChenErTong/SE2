package command;

import po.PersistentObject;

public class CommandModify<PO extends PersistentObject> extends Command<PO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandModify(String command, PO po) {
		super(command, po);
	}

}
