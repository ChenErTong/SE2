package ui.specialui.inventory.export;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;

public class CargoExport extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJTable commodities;
	private MyJTable exportList;
	private MyJComboBox transport;
	
	public CargoExport(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(608, 30, 64, 32, "出库", 30, true));
		
		commodities = new MyJTable(new String[]{"中转接收单编号", "订单编号", "仓库存放位置"}, false);
		//设置为只可单选
		commodities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new MyJScrollPane(200, 150, 330, 370, commodities));
		this.add(new MyJLabel(329, 110, 80, 19, "出库货物", 18, true));
		
		exportList = new MyJTable(new String[]{"中转单编号", "订单编号", "出库日期", "目的地", "装运形式"}, false);
		this.add(new MyJScrollPane(630, 150, 450, 370, exportList));
		this.add(new MyJLabel(810, 110, 100, 19, "出库单列表", 18, true));
		
		this.add(new MyJLabel(265, 550, 80, 19, "物流方式", 18, true));
		transport = new MyJComboBox(350, 547, 101, 25, new String[]{"汽车装运", "火车装运", "飞机装运"});
		this.add(transport);
		
		MyJButton produceExportList = new MyJButton(580, 600, 120, 30, "生成出库单", 20);
		produceExportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CargoExport.this.produceExportList()){
					//TODO
				}else{
					new MyNotification(frame, "请选择一件订单", Color.RED);
				}		
			}
		});
		this.add(produceExportList);
	}

	private boolean produceExportList() {
		int row = commodities.getSelectedRow();
		if(row == -1) return false;
		//TODO 根据选中的订单信息生成出库单
		
		commodities.removeRow();
		return true;
	}
}