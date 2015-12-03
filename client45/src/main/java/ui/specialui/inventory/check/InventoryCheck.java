package ui.specialui.inventory.check;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businesslogic.ControllerFactory;
import businesslogicservice.inventoryblservice.InventoryBLService;
import ui.GetDate;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;
import vo.InventoryViewVO;

public class InventoryCheck extends MyJPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField formerDate;
	private MyJTextField latterDate;
	private MyJTable inventoryInfo;
	private MyJTable commodityInfo;
	public InventoryCheck(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(576, 30, 128, 32, "库存查看", 30, true));
		
		this.add(new MyJLabel(430, 105, 57, 19, "时间段", 18, true));
		formerDate = new MyJTextField(500, 100, 130, 30);
		formerDate.setForDate();
		formerDate.setText(GetDate.getDate());
		this.add(formerDate);
		this.add(new MyJLabel(635, 112, 19, 19, "~", 18, true));
		latterDate = new MyJTextField(650, 100, 130, 30);
		latterDate.setForDate();
		latterDate.setText(GetDate.getDate());
		this.add(latterDate);
		
		inventoryInfo = new MyJTable(new String[]{"入库总数", "出库总数", "库存数量"}, false);
		this.add(new MyJScrollPane(415, 170, 450, 45, inventoryInfo));
		commodityInfo = new MyJTable(new String[]{"订单编号", "入库日期", "目的地", "仓库存放位置"}, false);
		this.add(new MyJScrollPane(415, 215, 450, 450, commodityInfo));
		
		MyJButton search = new MyJButton(790, 103, 60, 25, "查询", 18);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(InventoryCheck.this.searchWithinGap(frame)){
					
				}else{
					new MyNotification(frame, "请正确输入时间", Color.RED);
				}
			}
		});
		this.add(search);
	}

	/**
	 * 搜索时间范围内的库存信息，时间输入正确返回true，错误返回false
	 * @return
	 */
	private boolean searchWithinGap(Frame_Inventory frame) {
		InventoryBLService inventoryController = ControllerFactory.getInventoryController();
		if((formerDate.getText().equals(""))||(latterDate.getText().equals(""))) return false;
		
		InventoryViewVO inventoryView = inventoryController.viewInventory(frame.getID().substring(0, 4), formerDate.getText(), latterDate.getText());
		if(inventoryView == null) return false;
		
		inventoryInfo.addRow(new String[]{Integer.toString(inventoryView.importNumber), Integer.toString(inventoryView.exportNumber), Integer.toString(inventoryView.num)});
		// TODO 得到时间段内出入库单据
		return true;		
	}
}