package ui.specialui.inventory.stocking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ui.image.InventoryImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;
import util.GetDate;
import vo.InventoryCheckVO;
import vo.InventoryPositionVO;
import businesslogic.ControllerFactory;
import businesslogicservice.inventoryblservice.InventoryBLService;

public class Stocking extends MyJPanel {
	private static final long serialVersionUID = 1L;

	// 前一截止点
	private MyJLabel formerPoint;
	private MyJTable inventoryCondition;

	private InventoryCheckVO inventoryCheck = null;
	private InventoryBLService inventoryController;

	public Stocking(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		try {
			inventoryController = ControllerFactory.getInventoryController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}

		this.add(new MyJLabel(576, 30, 128, 32, "库存盘点", 30, true));

		this.add(new MyJLabel(385, 128, 105, 19, "前一截止点:", 18, true));
		formerPoint = new MyJLabel(495, 128, 180, 19, null, 18, true);
		this.add(formerPoint);
		inventoryCondition = new MyJTable(new String[] { "订单编号", "货物种类",
				"仓库存放位置" }, false, this);
		this.add(new MyJScrollPane(385, 150, 510, 410, inventoryCondition));

		this.refreshCondition(frame);

		MyButton refresh = new MyButton(855, 110, 34, 34,
				InventoryImage.getBUTTON_REFRESH());
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Stocking.this.refreshCondition(frame)) {
					new MyNotification(frame, "刷新成功", Color.GREEN);
				}
			}
		});
		this.add(refresh);

		MyButton stocking = new MyButton(584, 600, 111, 33,
				InventoryImage.getBUTTON_PD());
		stocking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Stocking.this.snapshot()) {
					new MyNotification(frame, "盘点成功", Color.GREEN);
				}
			}
		});
		this.add(stocking);
	}

	/**
	 * 进行库存快照，若成功返回true，若库存高于预警值则返回false 需要导出到excel表
	 * 
	 * @return
	 */
	private boolean snapshot() {
		if (inventoryCheck == null)
			return false;
		try {
			inventoryController = ControllerFactory.getInventoryController();
			inventoryController.exportToExcel(inventoryCheck);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return false;
		}
		inventoryCheck = null;
		return true;
	}

	// 刷新库存信息
	private boolean refreshCondition(Frame_Inventory frame) {
		if (inventoryController == null) return false;
		
		try {
			inventoryController = ControllerFactory.getInventoryController();
			inventoryCheck = inventoryController.checkRecord(frame.getID()
					.substring(0, 6), GetDate.getDate());
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);
			return false;
		}

		formerPoint.setText(inventoryCheck.lotNum.substring(5));
		ArrayList<InventoryPositionVO> commodities = inventoryCheck.commos;
		if (commodities != null) {
			for (InventoryPositionVO commodity : commodities) {
				String position = Integer.toString(commodity.area + 1) + "区"
						+ Integer.toString(commodity.row + 1) + "排"
						+ Integer.toString(commodity.frame + 1) + "架"
						+ Integer.toString(commodity.position + 1) + "位";
				inventoryCondition.addRow(new String[] {
						commodity.commodity.orderID,
						commodity.commodity.commodityType, position});
			}
		}
		return true;
	}
}