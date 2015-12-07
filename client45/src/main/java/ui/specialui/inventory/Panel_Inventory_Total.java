package ui.specialui.inventory;

import ui.image.InventoryImage;
import ui.myui.MyButton;
import ui.myui.MyJPanel;
import ui.myui.MyLogo;
import ui.myui.MyTitle;

public class Panel_Inventory_Total extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Inventory_Total(Frame_Inventory frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.initComponent(frame);
		
		MyLogo.setLogo(this);
		MyTitle.setTitle(this, "中转中心仓库管理员界面", 450, 100, 387, 148);
		
		this.repaint();
	}

	private void initComponent(Frame_Inventory frame) {
		MyButton InventoryCheck = new MyButton(511, 340, 257, 46, InventoryImage.getBUTTON_CHAKAN());
		InventoryCheck.setActionCommand("InventoryCheck");
		InventoryCheck.addActionListener(frame);
		this.add(InventoryCheck);
		
		MyButton Stocking = new MyButton(511, 410, 257, 46, InventoryImage.getBUTTON_PANDIAN());
		Stocking.setActionCommand("Stocking");
		Stocking.addActionListener(frame);
		this.add(Stocking);
		
		MyButton InventoryZoneAdjust = new MyButton(511, 480, 257, 46, InventoryImage.getBUTTON_FENQUTIAOZHENG());
		InventoryZoneAdjust.setActionCommand("InventoryZoneAdjust");
		InventoryZoneAdjust.addActionListener(frame);
		this.add(InventoryZoneAdjust);
		
		MyButton CargoImport = new MyButton(511, 550, 257, 46, InventoryImage.getBUTTON_RUKU());
		CargoImport.setActionCommand("CargoImport");
		CargoImport.addActionListener(frame);
		this.add(CargoImport);
		
		MyButton CargoExport = new MyButton(511, 620, 257, 46, InventoryImage.getBUTTON_CHUKU());
		CargoExport.setActionCommand("CargoExport");
		CargoExport.addActionListener(frame);
		this.add(CargoExport);
	}
}