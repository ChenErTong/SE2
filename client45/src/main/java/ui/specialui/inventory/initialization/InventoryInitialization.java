package ui.specialui.inventory.initialization;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.inventory.Frame_Inventory;

public class InventoryInitialization extends MyJPanel {
	private static final long serialVersionUID = 1L;

	public InventoryInitialization(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(528, 30, 224, 32, "库存信息初始化", 30, true));
	}
}