package ui.specialui.transfer_counterman.car_loading;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.transfer_counterman.Frame_Transfer;
import vo.CommodityVO;
import vo.OrderVO;
import businesslogic.ControllerFactory;
import businesslogicservice.branchblservice.BranchBLService;
import businesslogicservice.orderblservice.OrderBLService;

public class CarCommodity extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJTable orderSelected;
	private MyJTable orderList;
	
	public CarCommodity(Frame_Transfer frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(544, 30, 192, 32, "汽车装运管理", 30, true));
		
		//选中的订单的列表
		orderSelected = new MyJTable(new String[]{"选中订单"}, false, this);
		orderSelected.addMouseListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {  
				int row = orderSelected.rowAtPoint(e.getPoint());
				String orderId = orderSelected.getData(row)[0];
				MyEmptyTextArea orderInfo = new MyEmptyTextArea(e.getX(), e.getY(), 150, 250);
				CarCommodity.this.showOrder(orderInfo, orderId);
			}
			
			public void mouseClicked(MouseEvent e) {
				//双击加入到候选列表
				if (e.getClickCount() == 2) {
					orderSelected.removeRow();
				}
			}
		});
		this.add(new MyJScrollPane(690, 150, 340, 370, orderSelected));		
		
		//所有的订单的列表
		orderList = new MyJTable(new String[]{"所有订单"}, false, this);
		orderList.addMouseListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {  
				int row = orderList.rowAtPoint(e.getPoint());
				String orderId = orderList.getData(row)[0];
				MyEmptyTextArea orderInfo = new MyEmptyTextArea(e.getX(), e.getY(), 150, 250);
				CarCommodity.this.showOrder(orderInfo, orderId);
			}
			
			public void mouseClicked(MouseEvent e) {
				//双击加入到候选列表
				if (e.getClickCount() == 2) {
					int row = orderList.getSelectedRow();
					String[] orderId = orderList.getData(row);
					orderSelected.addRow(orderId);
					CarCommodity.this.repaint();
				}
			}
		});
		this.add(new MyJScrollPane(250, 150, 340, 370, orderList));
		
		MyButton TransferOrder = new MyButton(584, 600, 111, 33, TransferImage.getBUTTON_ZHUANGCHEDAN());
		TransferOrder.setActionCommand("TransferOrderForCar");
		TransferOrder.addActionListener(frame);
		this.add(TransferOrder);
	
		this.setOrdersID();
	}
	
	private void showOrder(MyEmptyTextArea orderInfo, String orderId) {
		OrderBLService orderController;
		try {
			orderController = ControllerFactory.getOrderController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		OrderVO order =null;
		try {
			order = orderController.inquireOrder(orderId);
		} catch (RemoteException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return;
		}
		orderInfo.setText("订单编号" + order.ID + "\n");
		orderInfo.append("货物信息：\n");	
		for(CommodityVO commodity: order.commodities){
			orderInfo.append(commodity.commodityType + "\t" + commodity.volumn + "m³\t" + commodity.weight + "kg\n");	
		}
		orderInfo.append("快递类型：" + order.express.value + "\t包装方式：" + order.packType.value + "\n");
		orderInfo.append("寄件日期：" + order.sendTime + "\t运费：" + order.money);
		this.add(orderInfo);
	}
	
	/**
	 * 得到所有订单号
	 */
	private void setOrdersID() {
		BranchBLService branchController;
		try {
			branchController = ControllerFactory.getBranchController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		ArrayList<String> ordersID = null;
		try {
			ordersID = branchController.getAllOrderNumber();
		} catch (RemoteException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return;
		}
		if((ordersID != null)&&(ordersID.size() > 0)){
			for (String orderID : ordersID) {
				orderList.addRow(new String[]{orderID});
			};	
		}	
	}
	/**
	 * 得到所有被选中的订单号
	 * @return
	 */
	public String[] produceTransferOrder(){
		String[][] data = orderSelected.getData();
		if(data == null) return null;
		String[] orderSelectedId = new String[data.length];
		for(int i = 0; i < data.length; i++){
			orderSelectedId[i] = data[i][0];
		}
		return orderSelectedId;
	}
}