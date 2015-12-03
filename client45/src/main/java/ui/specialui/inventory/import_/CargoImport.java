package ui.specialui.inventory.import_;

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
import vo.CommodityVO;
import vo.InventoryPositionVO;
import vo.OrderVO;
import vo.receiptvo.InventoryImportReceiptVO;
import businesslogic.ControllerFactory;
import businesslogicservice.inventoryblservice.InventoryBLService;
import businesslogicservice.orderblservice.OrderBLService;

public class CargoImport extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJComboBox position;
	private MyJTable commodities;
	private MyJTable importList;
	private InventoryBLService inventoryController;
	//仓库空余位置
	private ArrayList<InventoryPositionVO> posVOs;
	
	public CargoImport(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		inventoryController  = ControllerFactory.getInventoryController();
		
		this.add(new MyJLabel(608, 30, 64, 32, "入库", 30, true));
		
		commodities = new MyJTable(new String[]{"订单编号", "货物种类"}, false);
		//设置为只可单选
		commodities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new MyJScrollPane(150, 150, 300, 370, commodities));
		this.add(new MyJLabel(260, 110, 80, 19, "入库货物", 18, true));
		
		importList = new MyJTable(new String[]{"入库单编号", "订单编号", "货物种类", "入库日期", "目的地", "仓库存放位置"}, false);
		this.add(new MyJScrollPane(550, 150, 580, 370, importList));
		this.add(new MyJLabel(790, 110, 100, 19, "入库单列表", 18, true));
		
		this.add(new MyJLabel(180, 550, 76, 19, "可选位置", 18, true));	
		
		position = new MyJComboBox(265 , 547, 142, 25, null);
		this.add(position);
		this.setBlankPos(frame);
		
		MyJButton produceImportList = new MyJButton(580, 600, 120, 30, "生成入库单", 20);
		produceImportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = CargoImport.this.produceImportList(frame);
				if(row != -1){
					position.removeItemAt(row);
					posVOs.remove(row);
					//库存报警
					double alarmRate = inventoryController.inventoryAlarmRate(frame.getID().substring(0, 4));
					if(alarmRate < 0.9){
						new MyNotification(frame, "当前仓库存货量达" + Double.toString(alarmRate), Color.GREEN);
					}else{
						new MyNotification(frame, "当前仓库存货量达" + Double.toString(alarmRate), Color.RED);
					}
				}else{
					new MyNotification(frame, "请选择一件订单", Color.RED);
				}		
			}
		});
		this.add(produceImportList);
	}
	
	/**
	 * 生成入库单，若为选择货物则返回-1，反之返回选择的空位
	 * @return
	 */
	private int produceImportList(Frame_Inventory frame){
		int rowOfOrder = commodities.getSelectedRow();
		if(rowOfOrder == -1) return -1;
		
		int rowOfPos = position.getSelectedIndex();
		//根据选中的订单信息生成入库单
		String[] commodityInfo = commodities.getData(rowOfOrder);
		String orderID = commodityInfo[0];
		String commodityType = commodityInfo[1];
		OrderBLService orderController = ControllerFactory.getOrderController();
		OrderVO order = orderController.inquireOrder(orderID);
		CommodityVO commodity = null;
		for (CommodityVO comm : order.commodities) {
			if(comm.commodityType.equals(commodityType)){
				commodity = comm;
				break;
			}
		}
		InventoryPositionVO pos = posVOs.get(rowOfPos);
		InventoryImportReceiptVO importReceipt = inventoryController.addCommodities(frame.getID().substring(0, 4), commodity, pos.area, pos.row, pos.frame, pos.position);
		inventoryController.saveImport(importReceipt);
		inventoryController.submitImport(importReceipt);
		
		commodities.removeRow();
		
		return rowOfPos;
	}
	
	private void setBlankPos(Frame_Inventory frame){
		ArrayList<InventoryPositionVO> posVOs = inventoryController.getEmptyPositionsInList(frame.getID().substring(0, 4));
		if(posVOs != null){
			String posInfo = null;
			for (InventoryPositionVO posVO : posVOs) {
				posInfo = Integer.toString(posVO.area) + "区" + Integer.toString(posVO.row) + "排" + Integer.toString(posVO.frame) + "架" + Integer.toString(posVO.position) + "位";
				position.addItem(posInfo);	
			}
		}
	}
}