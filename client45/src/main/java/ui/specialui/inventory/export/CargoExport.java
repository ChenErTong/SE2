package ui.specialui.inventory.export;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.inventory.Frame_Inventory;

public class CargoExport extends MyJPanel {
	private static final long serialVersionUID = 1L;

	public CargoExport(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(608, 30, 64, 32, "出库", 30, true));
	}
}