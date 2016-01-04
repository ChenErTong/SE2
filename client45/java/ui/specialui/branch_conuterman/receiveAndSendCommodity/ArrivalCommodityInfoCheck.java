package ui.specialui.branch_conuterman.receiveAndSendCommodity;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import state.CommodityState;
import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.CommodityVO;
import vo.OrderVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import businesslogic.ControllerFactory;
import businesslogicservice.branchblservice.BranchBLService;
import businesslogicservice.orderblservice.OrderBLService;
/**
 * 送达货物信息查看界面
 * @author czw
 * @time 2015年11月22日下午2:20:46
 */
public class ArrivalCommodityInfoCheck extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyEmptyTextArea orderInfo;
	private MyJComboBox commodityState;
	private MyJTable orders;
	private int row = -1;
	private OrderVO order;
	private BranchBLService branchController;
	private BranchArrivalListVO arrivalList;
	
	public ArrivalCommodityInfoCheck(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		try {
			branchController = ControllerFactory.getBranchController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		this.add(new MyJLabel(550, 30, 210, 45, "接收派件货物", 30, true));
		
		orders = new MyJTable(new String[]{"送达订单编号"}, false, this);
		orders.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//双击显示订单详细信息
				if (e.getClickCount() == 2) {
					row = orders.getSelectedRow();
					String orderId = orders.getData(row)[0];
					ArrivalCommodityInfoCheck.this.showOrderInfo(orderId);
				}
				ArrivalCommodityInfoCheck.this.repaint();
			}
		});
		this.setOrderList();
		MyJScrollPane jsp = new MyJScrollPane(250, 150, 340, 370, orders);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				ArrivalCommodityInfoCheck.this.repaint();
			}
		});
		this.add(jsp);

		orderInfo = new MyEmptyTextArea(690, 150, 340, 370);
		this.add(orderInfo);

		//货物到达状态
		this.add(new MyJLabel(520, 560, 114, 19, "货物到达状态", 18, true));
		String[] commodityStates = new String[]{"完整", "损坏", "丢失"};
		commodityState = new MyJComboBox(650, 555, 115, 30, commodityStates);	
		this.add(commodityState);
		
		MyButton produceArrivalList = new MyButton(584, 630, 111, 33,
				TransferImage.getBUTTON_DAODADAN());
		produceArrivalList.setActionCommand("produceArrivalList");
		produceArrivalList.addActionListener(frame);
		this.add(produceArrivalList);
	}

	private void showOrderInfo(String orderId){
		OrderBLService orderController = null;
		try {
			orderController = ControllerFactory.getOrderController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return;
		}
		try {
			order = orderController.inquireOrder(orderId);
		} catch (RemoteException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return;
		}
		orderInfo.setText("订单编号" + order.ID + "\n");
		orderInfo.append("寄件人信息：\n");
		orderInfo.append("姓名：" + order.senderName + "\t");
		orderInfo.append("电话：" + order.senderTel + "\n");
		orderInfo.append("住址：" + order.senderAddress + "\n");
		orderInfo.append("单位：" + order.senderCo + "\n");
		orderInfo.append("收件人信息：\n");
		orderInfo.append("姓名：" + order.recipientName + "\t");
		orderInfo.append("电话：" + order.recipientTel + "\n");
		orderInfo.append("住址：" + order.recipientAddress + "\n");
		orderInfo.append("单位：" + order.recipientCo + "\n");
		orderInfo.append("货物信息：\n");	
		for(CommodityVO commodity: order.commodities){
			orderInfo.append(commodity.commodityType + "\t" + commodity.volumn + "m³\t" + commodity.weight + "kg\n");	
		}
		orderInfo.append("快递类型：" + order.express.value + "\t包装方式：" + order.packType.value + "\n");
		orderInfo.append("寄件日期：" + order.sendTime + "\t运费：" + order.money);
	}
	/**
	 * 生成到达单
	 * @return
	 */
	public int produceArrivalList() {
		//未选中任何订单
		if(row == -1) return 1;
		//选中订单，将其转化成到达单
		try {
			branchController = ControllerFactory.getBranchController();
			arrivalList = branchController.getBranchArrivalList(order.senderAddress, CommodityState.getType((String)commodityState.getSelectedItem()), order);
			row = -1;
			
			return 0;
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -1;
		}
	}
	
	/**
	 * 将订单列表显示在左侧列表中
	 */
	private void setOrderList(){
		if(branchController == null) return;
		
		orders.clear();
		
		ArrayList<String> orderIDs = null;
		try {
			branchController = ControllerFactory.getBranchController();
			orderIDs = branchController.getAllExportingOrders();
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		if((orderIDs == null) || (orderIDs.size() == 0)){
			return;
		}
		for (String orderID : orderIDs) {
			orders.addRow(new String[]{orderID});
		}
		orders.repaint();
	}
	
	public BranchArrivalListVO getArrivalList(){
		return arrivalList;
	}
}