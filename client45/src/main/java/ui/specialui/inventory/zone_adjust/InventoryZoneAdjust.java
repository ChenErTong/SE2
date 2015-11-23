package ui.specialui.inventory.zone_adjust;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.inventory.Frame_Inventory;

public class InventoryZoneAdjust extends MyJPanel {
	private static final long serialVersionUID = 1L;

	public InventoryZoneAdjust(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(544, 30, 192, 32, "库存分区调整", 30, true));
	}
}