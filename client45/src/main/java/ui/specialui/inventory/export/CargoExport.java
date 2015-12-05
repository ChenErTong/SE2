package ui.specialui.inventory.export;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;
import util.GetDate;
import vo.InventoryPositionVO;
import vo.receiptvo.InventoryExportReceiptVO;
import businesslogic.ControllerFactory;
import businesslogicservice.inventoryblservice.InventoryBLService;

public class CargoExport extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJTable commodities;
	private MyJTable exportList;
	private MyJComboBox transport;
	private InventoryBLService inventoryController;
	
	public CargoExport(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		inventoryController = ControllerFactory.getInventoryController();
		
		this.add(new MyJLabel(608, 30, 64, 32, "出库", 30, true));
		
		commodities = new MyJTable(new String[]{"订单编号", "货物种类", "仓库存放位置"}, false);
		//设置为只可单选
		commodities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new MyJScrollPane(150, 150, 330, 370, commodities));
		this.add(new MyJLabel(279, 110, 80, 19, "出库货物", 18, true));
		
		exportList = new MyJTable(new String[]{"中转单编号", "订单编号", "货物种类", "出库日期", "物流方式"}, false);
		this.add(new MyJScrollPane(580, 150, 550, 370, exportList));
		this.add(new MyJLabel(805, 110, 100, 19, "出库单列表", 18, true));
		
		this.add(new MyJLabel(215, 550, 80, 19, "物流方式", 18, true));
		transport = new MyJComboBox(300, 547, 101, 25, new String[]{"汽车装运", "火车装运", "飞机装运"});
		this.add(transport);
		
		this.setInventory(frame);
		
		MyJButton produceExportList = new MyJButton(580, 600, 120, 30, "生成出库单", 20);
		produceExportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CargoExport.this.produceExportList(frame)){
					//TODO
				}else{
					new MyNotification(frame, "请选择一件订单", Color.RED);
				}		
			}
		});
		this.add(produceExportList);
	}

	/**
	 * 设置仓库已有货物信息
	 * @param frame
	 */
	private void setInventory(Frame_Inventory frame){
		ArrayList<InventoryPositionVO> commodities = inventoryController.getCommoditiesInInventory(frame.getID().substring(0, 4));
		if(commodities != null){
			for (InventoryPositionVO commodity : commodities) {
				String position = Integer.toString(commodity.area) + "区" + Integer.toString(commodity.row) + "排" + Integer.toString(commodity.frame) + "架" + Integer.toString(commodity.position) + "位";
				this.commodities.addRow(new String[]{commodity.commodity.ID, commodity.commodity.commodityType, position});
			}
		}
	}
	
	private boolean produceExportList(Frame_Inventory frame) {
		int row = commodities.getSelectedRow();
		if(row == -1) return false;
		//TODO 根据选中的订单信息生成出库单
		String[] commodityInfo = commodities.getData(row);
		String position = commodityInfo[2];	
		InventoryExportReceiptVO exportReceipt = inventoryController.minusCommodities(frame.getID().substring(0, 4), position.charAt(0) - '0', position.charAt(2) - '0', position.charAt(4) - '0', position.charAt(6) - '0');
		String id = inventoryController.getExportID();
		//将数据加入出库单列表
		exportList.addRow(new String[]{id, commodityInfo[0], commodityInfo[1], GetDate.getDate(), (String) transport.getSelectedItem()});
		//将货物从仓库列表中移除
		commodities.removeRow();
		//存储数据
		inventoryController.saveExport(exportReceipt);
		inventoryController.submitExport(exportReceipt);
		return true;
	}
}