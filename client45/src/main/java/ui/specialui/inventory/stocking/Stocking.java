package ui.specialui.inventory.stocking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import businesslogic.ControllerFactory;
import businesslogicservice.inventoryblservice.InventoryBLService;
import ui.GetDate;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;
import vo.InventoryCheckVO;
import vo.InventoryPositionVO;

public class Stocking extends MyJPanel {
	private static final long serialVersionUID = 1L;
	
	//前一截止点
	private MyJLabel formerPoint;
	private MyJTable inventoryCondition;
	
	private InventoryCheckVO inventoryCheck = null;
	private InventoryBLService inventoryController;
	
	public Stocking(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		inventoryController = ControllerFactory.getInventoryController();
		
		this.add(new MyJLabel(576, 30, 128, 32, "库存盘点", 30, true));
		
		this.add(new MyJLabel(385, 128, 105, 19, "前一截止点:", 18, true));
		formerPoint = new MyJLabel(495, 128, 110, 19, null, 18, true);
		this.add(formerPoint);
		inventoryCondition = new MyJTable(new String[]{"订单编号", "货物种类", "仓库存放位置"}, false);
		this.add(new MyJScrollPane(415, 150, 510, 410, inventoryCondition));
	
		this.refreshCondition(frame);
		
		MyJButton refresh = new MyJButton(765, 126, 100, 20, "刷新状态", 18);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stocking.this.refreshCondition(frame);
				new MyNotification(frame, "刷新成功", Color.GREEN);
			}
		});
		this.add(refresh);
		
		MyJButton stocking = new MyJButton(580, 600, 120, 30, "盘点", 20);
		stocking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Stocking.this.snapshot()){
					new MyNotification(frame, "盘点成功", Color.GREEN);
				}else{
					MyNotification notification = new MyNotification(frame, "仓库库存高于预警值\n点击提示板进行库存分区调整", Color.RED);
					notification.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e){
							frame.toAdjustZone();
							notification.dispose();
						}		
					});;
				}
			}
		});
		this.add(stocking);
	}
	
	/**
	 * 进行库存快照，若成功返回true，若库存高于预警值则返回false
	 * 需要导出到excel表
	 * @return
	 */
	private boolean snapshot() {
		if(inventoryCheck == null) return false;
		inventoryController.exportToExcel(inventoryCheck);
		inventoryCheck = null;
		return true;
	}
	
	//刷新库存信息
	private void refreshCondition(Frame_Inventory frame) {
		inventoryCheck = inventoryController.checkRecord(frame.getID().substring(0, 4), GetDate.getDate());
		String point = inventoryCheck.date + inventoryCheck.lotNum;
		formerPoint.setText(point);
		ArrayList<InventoryPositionVO> commodities = inventoryCheck.commos;
		if(commodities != null){
			for (InventoryPositionVO commodity : commodities) {
				String position = Integer.toString(commodity.area) + "区" + Integer.toString(commodity.row) + "排" + Integer.toString(commodity.frame) + "架" + Integer.toString(commodity.position) + "位";
				inventoryCondition.addRow(new String[]{commodity.commodity.ID, commodity.commodity.commodityType, position});
			}
		}
	}
}