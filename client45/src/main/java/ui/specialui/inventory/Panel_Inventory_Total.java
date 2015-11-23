package ui.specialui.inventory;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;

public class Panel_Inventory_Total extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Inventory_Total(Frame_Inventory frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.initComponent(frame);
	}

	private void initComponent(Frame_Inventory frame) {
		MyJButton InventoryCheck = new MyJButton(200, 300, 150, 40, "库存查看", 15);
		InventoryCheck.setActionCommand("InventoryCheck");
		InventoryCheck.addActionListener(frame);
		this.add(InventoryCheck);
		
		MyJButton Stocking = new MyJButton(200, 350, 150, 40, "库存盘点", 15);
		Stocking.setActionCommand("Stocking");
		Stocking.addActionListener(frame);
		this.add(Stocking);
		
		MyJButton InventoryZoneAdjust = new MyJButton(200, 400, 150, 40, "库存分区调整", 15);
		InventoryZoneAdjust.setActionCommand("InventoryZoneAdjust");
		InventoryZoneAdjust.addActionListener(frame);
		this.add(InventoryZoneAdjust);
		
		MyJButton CargoExport = new MyJButton(200, 450, 150, 40, "出库", 15);
		CargoExport.setActionCommand("CargoExport");
		CargoExport.addActionListener(frame);
		this.add(CargoExport);
		
		MyJButton InventoryInitialization = new MyJButton(200, 500, 150, 40, "库存信息初始化", 15);
		InventoryInitialization.setActionCommand("InventoryInitialization");
		InventoryInitialization.addActionListener(frame);
		this.add(InventoryInitialization);
	}
}