package ui.specialui.inventory.check;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.inventory.Frame_Inventory;

public class InventoryCheck extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public InventoryCheck(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(576, 30, 128, 32, "库存查看", 30, true));
	}
}