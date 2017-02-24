package ui.specialui.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.image.CommonImage;
import ui.image.InventoryImage;
import ui.myui.MyButton;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.specialui.inventory.check.InventoryCheck;
import ui.specialui.inventory.export.CargoExport;
import ui.specialui.inventory.import_.CargoImport;
import ui.specialui.inventory.stocking.Stocking;
import ui.specialui.inventory.zone_adjust.InventoryZoneAdjust;

public class Frame_Inventory extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Panel_Inventory_Total totalPanel;
	private MyJPanel subPanel;	
	// 导航栏
	private MyButton check;
	private MyButton stocking;
	private MyButton zoneAdjust;
	private MyButton importInventory;
	private MyButton exportInventory;
		
	public Frame_Inventory(String userID) {
		super(userID);
		this.totalPanel = new Panel_Inventory_Total(this);
		this.add(totalPanel);
		
		this.returnButton.addActionListener(this);
		
		check = new MyButton(870, 690, 80, 20, InventoryImage.getBUTTON_CHAKAN_GUIDE());
		check.setActionCommand("InventoryCheck");
		check.addActionListener(this);
		stocking = new MyButton(960, 690, 80, 20, InventoryImage.getBUTTON_PANDIAN_GUIDE());
		stocking.setActionCommand("Stocking");
		stocking.addActionListener(this);
		zoneAdjust = new MyButton(1050, 690, 120, 20, InventoryImage.getBUTTON_FENQUTIAOZHENG_GUIDE());
		zoneAdjust.setActionCommand("InventoryZoneAdjust");
		zoneAdjust.addActionListener(this);
		importInventory = new MyButton(1180, 690, 40, 20, InventoryImage.getBUTTON_RUKU_GUIDE());
		importInventory.setActionCommand("CargoImport");
		importInventory.addActionListener(this);
		exportInventory = new MyButton(1230, 690, 40, 20, InventoryImage.getBUTTON_CHUKU_GUIDE());
		exportInventory.setActionCommand("CargoExport");
		exportInventory.addActionListener(this);
		this.add(check);
		this.add(stocking);
		this.add(zoneAdjust);
		this.add(importInventory);
		this.add(exportInventory);
		this.setNavigation(false);
		
		this.setBackground(CommonImage.BACKGROUND);
		
		this.repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			//回退到主界面
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
				this.setNavigation(false);
			}else{
				this.logout();
			}
		}else if(e.getActionCommand().equals("InventoryCheck")){
			//进入库存查看界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new InventoryCheck(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("Stocking")){
			//进入库存盘点界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new Stocking(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("InventoryZoneAdjust")){
			//进入库存分区调整界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new InventoryZoneAdjust(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("CargoImport")){
			//进入入库界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new CargoImport(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("CargoExport")){
			//进入出库界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new CargoExport(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}
	}
	
	// 设置导航栏是否隐藏
	private void setNavigation(boolean isVisible) {
		check.setVisible(isVisible);
		stocking.setVisible(isVisible);
		zoneAdjust.setVisible(isVisible);
		importInventory.setVisible(isVisible);
		exportInventory.setVisible(isVisible);
		subscript.setVisible(isVisible);
	}
}