package ui.specialui.inventory;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.inventory.check.InventoryCheck;
import ui.specialui.inventory.export.CargoExport;
import ui.specialui.inventory.import_.CargoImport;
import ui.specialui.inventory.stocking.Stocking;
import ui.specialui.inventory.zone_adjust.InventoryZoneAdjust;

public class Frame_Inventory extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Panel_Inventory_Total totalPanel;
	private MyJPanel subPanel;	
	
	public Frame_Inventory(String userID) {
		super(userID);
		this.totalPanel = new Panel_Inventory_Total(this);
		this.add(totalPanel);
		
		this.returnButton.addActionListener(this);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
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
			}
		}else if(e.getActionCommand().equals("InventoryCheck")){
			//进入库存查看界面
			totalPanel.setVisible(false);
			subPanel = new InventoryCheck(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("Stocking")){
			//进入库存盘点界面
			totalPanel.setVisible(false);
			subPanel = new Stocking(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("InventoryZoneAdjust")){
			//进入库存分区调整界面
			totalPanel.setVisible(false);
			subPanel = new InventoryZoneAdjust(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("CargoImport")){
			//进入入库界面
			totalPanel.setVisible(false);
			subPanel = new CargoImport(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("CargoExport")){
			//进入出库界面
			totalPanel.setVisible(false);
			subPanel = new CargoExport(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("InventoryInitialization")){
			MyNotification notification = new MyNotification(this, "库存信息初始化后不可恢复！确认请点击提示板", Color.RED);
			notification.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					if(Frame_Inventory.this.initInventory()){
						new MyNotification(Frame_Inventory.this, "库存信息初始化成功", Color.GREEN);
						notification.dispose();
					}
				}
			});
		}
	}
	
	/**
	 * TODO 库存信息初始化操作
	 * @return
	 */
	protected boolean initInventory() {
		// TODO
		return true;
	}
	
	/**
	 * 当提示仓库库存高于预警值后
	 * 从库存盘点界面直接进入库存分区调整界面
	 */
	public void toAdjustZone() {
		subPanel.setVisible(false);
		this.remove(subPanel);
		subPanel =  new InventoryZoneAdjust(this);
		this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
	}
}