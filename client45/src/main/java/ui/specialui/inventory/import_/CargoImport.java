package ui.specialui.inventory.import_;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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
import vo.CommodityVO;
import vo.InventoryPositionVO;
import vo.OrderVO;
import vo.receiptvo.InventoryImportReceiptVO;
import businesslogic.ControllerFactory;
import businesslogicservice.branchblservice.BranchBLService;
import businesslogicservice.inventoryblservice.InventoryBLService;
import businesslogicservice.orderblservice.OrderBLService;

public class CargoImport extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJComboBox position;
	private MyJTable commodityList;
	private MyJTable importList;
	private InventoryBLService inventoryController;
	//仓库空余位置
	private ArrayList<InventoryPositionVO> posVOs;
	
	public CargoImport(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		try {
			inventoryController  = ControllerFactory.getInventoryController();
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		this.add(new MyJLabel(608, 30, 64, 32, "入库", 30, true));
		
		commodityList = new MyJTable(new String[]{"订单编号", "货物种类"}, false, this);
		//设置为只可单选
		commodityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MyJScrollPane jsp = new MyJScrollPane(150, 150, 300, 370, commodityList);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				CargoImport.this.repaint();
			}
		});
		this.add(jsp);
		
		this.add(new MyJLabel(260, 110, 80, 19, "入库货物", 18, true));
		
		importList = new MyJTable(new String[]{"入库单编号", "订单编号", "货物种类", "入库日期", "目的地", "仓库存放位置"}, false, this);
		this.add(new MyJScrollPane(550, 150, 580, 370, importList));
		this.add(new MyJLabel(790, 110, 100, 19, "入库单列表", 18, true));
		
		this.add(new MyJLabel(180, 550, 76, 19, "可选位置", 18, true));	
		
		position = new MyJComboBox(265 , 547, 142, 25, null);
		this.add(position);
		this.setBlankPos(frame);
		
		MyButton produceImportList = new MyButton(584, 600, 111, 33, InventoryImage.getBUTTON_RUKUDAN());
		produceImportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = CargoImport.this.produceImportList(frame);
				if(row > -1){
					position.removeItemAt(row);
					posVOs.remove(row);
					//库存报警
					try {
						inventoryController = ControllerFactory.getInventoryController();
						double alarmRate = inventoryController.inventoryAlarmRate(frame.getID().substring(0, 6));
						if(alarmRate < 0.9){
							new MyNotification(frame, "当前仓库存货量达" + Double.toString(alarmRate), Color.GREEN);
						}else{
							new MyNotification(frame, "当前仓库存货量达" + Double.toString(alarmRate), Color.RED);
						}
					} catch (RemoteException | MalformedURLException | NotBoundException e1) {
						new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
					}
				}else if(row == -1){
					new MyNotification(frame, "请选择一件订单", Color.RED);
				}		
			}
		});
		this.add(produceImportList);
		
		this.setCommodities(frame);
	}
	
	/**
	 * 生成入库单，若为选择货物则返回-1，反之返回选择的空位
	 * @return
	 */
	private int produceImportList(Frame_Inventory frame){
		int rowOfOrder = commodityList.getSelectedRow();
		if(rowOfOrder == -1) return -1;
		
		int rowOfPos = position.getSelectedIndex();
		//根据选中的订单信息生成入库单
		String[] commodityInfo = commodityList.getData(rowOfOrder);
		String orderID = commodityInfo[0];
		String commodityType = commodityInfo[1];
		OrderBLService orderController;
		try {
			orderController = ControllerFactory.getOrderController();
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -2;
		}
		OrderVO order = null;
		try {
			order = orderController.inquireOrder(orderID);
		} catch (RemoteException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);
			return -2;
		}
		CommodityVO commodity = null;
		for (CommodityVO comm : order.commodities) {
			if(comm.commodityType.equals(commodityType)){
				commodity = comm;
				break;
			}
		}
		InventoryPositionVO pos = posVOs.get(rowOfPos);
		InventoryImportReceiptVO importReceipt;
		try {
			inventoryController = ControllerFactory.getInventoryController();
			importReceipt = inventoryController.addCommodities(frame.getID().substring(0, 6), commodity, pos.area, pos.row, pos.frame, pos.position);
		} catch (RemoteException | MalformedURLException | NotBoundException e1) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -2;
		}
		
		//将入库单添加到入库单列表
		importList.addRow(new String[]{importReceipt.ID, orderID, commodityType, GetDate.getDate(), order.recipientAddress, (String) position.getSelectedItem()});
		//将货物从货物列表移除
		commodityList.removeRow();
		this.repaint();
		
		return rowOfPos;
	}
	
	/**
	 * 得到仓库空余位置
	 * @param frame
	 */
	private void setBlankPos(Frame_Inventory frame){
		if(inventoryController == null) return;
		
		try {
			inventoryController = ControllerFactory.getInventoryController();
			posVOs = inventoryController.getEmptyPositionsInList(frame.getID().substring(0, 6));
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		if(posVOs != null){
			String posInfo = null;
			for (InventoryPositionVO posVO : posVOs) {
				posInfo = Integer.toString(posVO.area + 1) + "区" + Integer.toString(posVO.row + 1) + "排" + Integer.toString(posVO.frame + 1) + "架" + Integer.toString(posVO.position + 1) + "位";
				position.addItem(posInfo);	
			}
		}
	}
	
	private void setCommodities(Frame_Inventory frame){
		ArrayList<String> ordersID = null;
		try {
			BranchBLService branchController = ControllerFactory.getBranchController();
			ordersID = branchController.getAllToBeExportedOrders();
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		if((ordersID == null)||(ordersID.size() == 0)){
			return;
		}
		
		OrderBLService orderController = null;
		try {
			orderController = ControllerFactory.getOrderController();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		for (String orderID: ordersID) {
			OrderVO order = null;
			try {
				order = orderController.inquireOrder(orderID);
			} catch (RemoteException e) {
				new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
				return;
			}
			for(CommodityVO commodity : order.commodities){
				if(!commodity.inStock){
					commodityList.addRow(new String[]{orderID, commodity.commodityType});
				}
			}
		}
		this.repaint();
	}
}