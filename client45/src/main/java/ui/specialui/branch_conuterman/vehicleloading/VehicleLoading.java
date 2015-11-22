package ui.specialui.branch_conuterman.vehicleloading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.specialui.branch_conuterman.Frame_Branch;

public class VehicleLoading extends MyJPanel {
	private static final long serialVersionUID = 1L;
	private LoadingInfo loadingInfo;
	private MyJTextField deliveryCost;
	
	public VehicleLoading(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		this.add(new MyJLabel(550, 30, 210, 45, "车辆装车管理", 30, true));

		loadingInfo = new LoadingInfo();
		this.add(loadingInfo);

		// the table
		String[] orderId = new String[]{"订单编号"};
		MyJTable table = new MyJTable(orderId, false);
		this.add(new MyJScrollPane(690, 150, 340, 370, table));
		
		deliveryCost = new MyJTextField(670, 560, 138, 30);
		deliveryCost.setOnlyDouble();
		deliveryCost.setText("0.0");
		this.add(deliveryCost);
		
		MyJButton calculateCost = new MyJButton(472, 560, 138, 23, "计算运费/元", 18);
		calculateCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 计算运费
				double cost = 0.0;
				deliveryCost.setText(Double.toString(cost));
			}
		});
		this.add(calculateCost);
		
		MyJButton produceLoadingList = new MyJButton(583, 630, 115, 23, "生成装车单", 18);
		produceLoadingList.setActionCommand("produceLoadingList");
		produceLoadingList.addActionListener(frame);
		this.add(produceLoadingList);
	}
	/**
	 * 从bl层得到订单编号
	 * @return
	 */
	private String[] getOrderId(){
		return new String[]{};
	}
	
	public int produceLoadingList(){
		String[] loadingInfo;
		double cost;
		if((loadingInfo = this.loadingInfo.getInfo())== null) return 1;	
		if((cost = Double.parseDouble(deliveryCost.getText())) <= 0) return 2;
		return 0;
	}
}
