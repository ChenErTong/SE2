package ui.specialui.inventory.export;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

import ui.image.InventoryImage;
import ui.myui.MyButton;
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
		
		try {
			inventoryController = ControllerFactory.getInventoryController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		this.add(new MyJLabel(608, 30, 64, 32, "出库", 30, true));
		
		commodities = new MyJTable(new String[]{"订单编号", "货物种类", "仓库存放位置"}, false, this);
		//设置为只可单选
		commodities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new MyJScrollPane(150, 150, 330, 370, commodities));
		this.add(new MyJLabel(279, 110, 80, 19, "出库货物", 18, true));
		
		exportList = new MyJTable(new String[]{"中转单编号", "订单编号", "货物种类", "出库日期", "物流方式"}, false, this);
		this.add(new MyJScrollPane(580, 150, 550, 370, exportList));
		this.add(new MyJLabel(805, 110, 100, 19, "出库单列表", 18, true));
		
		this.add(new MyJLabel(215, 550, 80, 19, "物流方式", 18, true));
		transport = new MyJComboBox(300, 547, 101, 25, new String[]{"汽车装运", "火车装运", "飞机装运"});
		this.add(transport);
		
		this.setInventory(frame);
		
		MyButton produceExportList = new MyButton(584, 600, 111, 33, InventoryImage.getBUTTON_CHUKUDAN());
		produceExportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = CargoExport.this.produceExportList(frame);
				if(result == 1){
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
		if(inventoryController == null) return;
		ArrayList<InventoryPositionVO> commodities = null;
		try {
			inventoryController = ControllerFactory.getInventoryController();
			commodities = inventoryController.getCommoditiesInInventory(frame.getID().substring(0, 6));
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		if(commodities != null){
			for (InventoryPositionVO commodity : commodities) {
				String position = Integer.toString(commodity.area + 1) + "区" + Integer.toString(commodity.row + 1) + "排" + Integer.toString(commodity.frame + 1) + "架" + Integer.toString(commodity.position + 1) + "位";
				this.commodities.addRow(new String[]{commodity.commodity.orderID, commodity.commodity.commodityType, position});
			}
		}
	}
	
	private int produceExportList(Frame_Inventory frame) {
		int row = commodities.getSelectedRow();
		if(row == -1) return 1;

		String[] commodityInfo = commodities.getData(row);
		String position = commodityInfo[2];	
		InventoryExportReceiptVO exportReceipt;
		try {
			exportReceipt = inventoryController.minusCommodities(frame.getID().substring(0, 6), position.charAt(0) - '0', position.charAt(2) - '0', position.charAt(4) - '0', position.charAt(6) - '0');
			//将数据加入出库单列表
			exportList.addRow(new String[]{exportReceipt.ID, commodityInfo[0], commodityInfo[1], GetDate.getDate(), (String) transport.getSelectedItem()});
			//将货物从仓库列表中移除
			commodities.removeRow();
			this.repaint();
			return 0;
		} catch (RemoteException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);
			return 2;
		}
	}
}