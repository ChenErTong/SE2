package command;

import po.PersistentObject;

public class CommandAdd<PO extends PersistentObject> extends Command<PO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandAdd(String command, PO po) {
		super(command, po);
	}

}
