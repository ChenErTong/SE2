package ui.specialui.branch_conuterman.vehicleloading;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import ui.image.BranchImage;
import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.OrderVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import businesslogic.ControllerFactory;
import businesslogicservice.branchblservice.BranchBLService;
import businesslogicservice.orderblservice.OrderBLService;

public class VehicleLoading extends MyJPanel {
	private static final long serialVersionUID = 1L;
	private LoadingInfo loadingInfo;
	private MyJTextField deliveryCost;
	private MyJTable ordersID;
	private BranchBLService branchController;
	
	public VehicleLoading(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		this.add(new MyJLabel(550, 30, 210, 45, "车辆装车管理", 30, true));
		
		try {
			branchController = ControllerFactory.getBranchController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		loadingInfo = new LoadingInfo(frame.getID().substring(0, 6));
		this.add(loadingInfo);

		String[] orderId = new String[]{"订单编号"};
		ordersID = new MyJTable(orderId, false, this);
		ordersID.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//双击取消订单
				if (e.getClickCount() == 2) {
					ordersID.removeRow();
				}
				VehicleLoading.this.repaint();
			}
		});
		
		this.add(new MyJLabel(690, 150, 100, 25, "订单编号", 18, true));
		MyJTextField orderID = new MyJTextField(780, 150, 150, 30);
		orderID.setOnlyInteger(10);
		this.add(orderID);
		MyButton addOrder = new MyButton(950, 150, 66, 33, BranchImage.getBUTTON_TIANJIA());
		addOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(VehicleLoading.this.addOrderID(orderID.getText())){
					orderID.setText(null);
				}
			}
		});
		this.add(addOrder);
		this.add(new MyJScrollPane(690, 200, 340, 320, ordersID));
		
		deliveryCost = new MyJTextField(670, 560, 138, 30);
		deliveryCost.setOnlyDouble();
		deliveryCost.setText("0.0");
		this.add(deliveryCost);
		
		MyButton calculateCost = new MyButton(472, 560, 116, 25, BranchImage.getBUTTON_JISUAN());
		calculateCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal cost = VehicleLoading.this.calculateCost();
				if(cost.compareTo(new BigDecimal(0))==0){
					new MyNotification(frame, "无订单信息", Color.RED);
				}else if(cost.compareTo(new BigDecimal(0)) > 0){
					deliveryCost.setText(cost+"");
				}
			}
		});
		this.add(calculateCost);
		
		MyButton produceLoadingList = new MyButton(584, 630, 111, 33, TransferImage.getBUTTON_ZHUANGCHEDAN());
		produceLoadingList.setActionCommand("produceLoadingList");
		produceLoadingList.addActionListener(frame);
		this.add(produceLoadingList);
	}
	
	/**
	 * 插入订单编号
	 * @param text
	 */
	private boolean addOrderID(String text) {
		if(text.length() != 10){
			new MyNotification(this, "请输入正确的订单号", Color.RED);
			return false;
		}
		
		String[] data = new String[]{text};

		if(ordersID.getData() != null){
			for (String[] datas : ordersID.getData()) {
				if(data[0].equals(datas[0])){
					new MyNotification(this, "该订单已存在于列表", Color.RED);
					return false;
				}
			}
		}
		
		ordersID.addRow(data);
		this.repaint();
		return true;
	}

	/**
	 * 计算所有订单运费总和
	 * @param frame 
	 * @param orderID
	 * @return
	 */
	private BigDecimal calculateCost(){
		BigDecimal cost = new BigDecimal(0);
		String[][] data = ordersID.getData();
		if(data == null) return new BigDecimal(0);
		OrderBLService order_info;
		try {
			order_info = ControllerFactory.getOrderController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return new BigDecimal(0.0);
		}
		
		for (int i = 0; i < data.length; i++) {
			OrderVO order = null;;
			try {
				order = order_info.inquireOrder(data[i][0]);
			} catch (RemoteException e) {
				new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
				return new BigDecimal(0.0);
			}
			if(order == null){
				new MyNotification(this, "不存在订单号\n" + data[i][0], Color.RED);
				return new BigDecimal(-1);
			}
			cost=cost.add(order.money);
		}
		return cost;
	}
	
	public LoadingListVO produceLoadingList(){
		String[] loadingInfo;
		BigDecimal cost;
		if((loadingInfo = this.loadingInfo.getInfo())== null){
			new MyNotification(this, "请完成装车信息填写", Color.RED);
			return null;	
		}
		if((cost = new BigDecimal(deliveryCost.getText())).compareTo(new BigDecimal(0))<=0){
			new MyNotification(this, "运费应大于0元", Color.RED);
			return null;
		}
		String[][] orderNum = ordersID.getData();
		if(orderNum == null){
			new MyNotification(this, "请输入订单编号", Color.RED);
			return null;
		}
		ArrayList<String> ordernum = new ArrayList<String>(orderNum.length);
		for (String[] num : orderNum) {
			ordernum.add(num[0]);
		}
		new MyNotification(this, "成功生成装车单", Color.GREEN);
		
		try {
			 branchController = ControllerFactory.getBranchController();
			return branchController.truckDeliver(loadingInfo[5], loadingInfo[0], loadingInfo[2], loadingInfo[3], loadingInfo[1], ordernum, cost);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return null;
		}
	}
}