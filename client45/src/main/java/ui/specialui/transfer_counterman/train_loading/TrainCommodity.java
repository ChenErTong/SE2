package ui.specialui.transfer_counterman.train_loading;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import businesslogic.ControllerFactory;
import businesslogicservice.branchblservice.BranchBLService;
import businesslogicservice.orderblservice.OrderBLService;
import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.specialui.transfer_counterman.Frame_Transfer;
import vo.CommodityVO;
import vo.OrderVO;

public class TrainCommodity extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJTable orderSelected;
	private MyJTable orderList;
	
	public TrainCommodity(Frame_Transfer frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(544, 30, 192, 32, "火车装运管理", 30, true));
		
		//选中的订单的列表
		orderSelected = new MyJTable(new String[]{"选中订单"}, false);
		this.setOrdersID();
		orderSelected.addMouseListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {  
				int row = orderSelected.rowAtPoint(e.getPoint());
				String orderId = orderSelected.getData(row)[0];
				MyEmptyTextArea orderInfo = new MyEmptyTextArea(e.getX(), e.getY(), 150, 250);
				TrainCommodity.this.showOrder(orderInfo, orderId);
				//orderId加入到orderInfo中
				TrainCommodity.this.add(orderInfo);
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
		orderList = new MyJTable(new String[]{"所有订单"}, false);
		orderList.addMouseListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {  
				int row = orderList.rowAtPoint(e.getPoint());
				String orderId = orderList.getData(row)[0];
				MyEmptyTextArea orderInfo = new MyEmptyTextArea(e.getX(), e.getY(), 150, 250);
				TrainCommodity.this.showOrder(orderInfo, orderId);
			}
			
			public void mouseClicked(MouseEvent e) {
				//双击加入到候选列表
				if (e.getClickCount() == 2) {
					int row = orderList.getSelectedRow();
					String[] orderId = orderList.getData(row);
					orderSelected.addRow(orderId);
				}
			}
		});
		this.add(new MyJScrollPane(250, 150, 340, 370, orderList));
		
		MyButton TransferOrder = new MyButton(584, 600, 111, 33, TransferImage.getBUTTON_ZHUANGCHEDAN());
		TransferOrder.setActionCommand("TransferOrderForTrain");
		TransferOrder.addActionListener(frame);
		this.add(TransferOrder);
	}
	
	private void showOrder(MyEmptyTextArea orderInfo, String orderId) {
		OrderBLService orderController = ControllerFactory.getOrderController();
		OrderVO order = orderController.inquireOrder(orderId);
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
		BranchBLService branchController = ControllerFactory.getBranchController();
		ArrayList<String> ordersID = branchController.getAllOrderNumber();
		if(ordersID != null){
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
