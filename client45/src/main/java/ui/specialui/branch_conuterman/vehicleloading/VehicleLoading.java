package ui.specialui.branch_conuterman.vehicleloading;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import businesslogic.ControllerFactory;
import businesslogicservice.orderblservice.OrderBLService;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.OrderVO;

public class VehicleLoading extends MyJPanel {
	private static final long serialVersionUID = 1L;
	private LoadingInfo loadingInfo;
	private MyJTextField deliveryCost;
	private MyJTable ordersID;
	
	public VehicleLoading(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		this.add(new MyJLabel(550, 30, 210, 45, "车辆装车管理", 30, true));
		
		loadingInfo = new LoadingInfo();
		this.add(loadingInfo);

		String[] orderId = new String[]{"订单编号"};
		ordersID = new MyJTable(orderId, false);
		this.add(new MyJLabel(690, 150, 100, 25, "订单编号", 18, true));
		MyJTextField orderID = new MyJTextField(780, 150, 150, 30);
		this.add(orderID);
		MyJButton addOrder = new MyJButton(950, 150, 70, 30, "添加", 18);
		addOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehicleLoading.this.addOrderID(orderID.getText());
				orderID.setText(null);
			}
		});
		this.add(addOrder);
		this.add(new MyJScrollPane(690, 200, 340, 320, ordersID));
		
		deliveryCost = new MyJTextField(670, 560, 138, 30);
		deliveryCost.setOnlyDouble();
		deliveryCost.setText("0.0");
		this.add(deliveryCost);
		
		MyJButton calculateCost = new MyJButton(472, 560, 138, 23, "计算运费/元", 18);
		calculateCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cost = VehicleLoading.this.calculateCost();
				if(cost == 0.0){
					new MyNotification(frame, "无订单信息", Color.RED);
				}else if(cost > 0){
					deliveryCost.setText(Double.toString(cost));
				}
			}
		});
		this.add(calculateCost);
		
		MyJButton produceLoadingList = new MyJButton(583, 630, 115, 23, "生成装车单", 18);
		produceLoadingList.setActionCommand("produceLoadingList");
		produceLoadingList.addActionListener(frame);
		this.add(produceLoadingList);
	}
	
	/**
	 * 插入订单编号
	 * @param text
	 */
	protected void addOrderID(String text) {
		String[] data = new String[]{text};
		ordersID.addRow(data);
	}

	/**
	 * 计算所有订单运费总和
	 * @param frame 
	 * @param orderID
	 * @return
	 */
	private double calculateCost(){
		double cost = 0.0;
		String[][] data = ordersID.getData();
		if(ordersID == null) return 0.0;
		OrderBLService order_info = ControllerFactory.getOrderController();
		for (int i = 0; i < data.length; i++) {
			OrderVO order = order_info.inquireOrder(data[i][0]);
			if(order == null){
				new MyNotification(this, "不存在订单号\n" + data[i][0], Color.RED);
				return -1;
			}
			cost += order.money;
		}
		return cost;
	}
	
	public int produceLoadingList(){
		String[] loadingInfo;
		double cost;
		if((loadingInfo = this.loadingInfo.getInfo())== null) return 1;	
		if((cost = Double.parseDouble(deliveryCost.getText())) <= 0) return 2;
		String[][] orderNum = ordersID.getData();
		
		// TODO
		// 根据数据生成装车单
		return 0;
	}
}