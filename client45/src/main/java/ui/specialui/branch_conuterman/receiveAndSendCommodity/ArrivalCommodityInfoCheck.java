package ui.specialui.branch_conuterman.receiveAndSendCommodity;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.branch_conuterman.Frame_Branch;
/**
 * 送达货物信息查看界面
 * @author czw
 * @time 2015年11月22日下午2:20:46
 */
public class ArrivalCommodityInfoCheck extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyEmptyTextArea orderInfo;
	private int row = -1;
	
	public ArrivalCommodityInfoCheck(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		this.add(new MyJLabel(550, 30, 210, 45, "接收派件货物", 30, true));

		MyJTable orders = new MyJTable(new String[] { "送达订单编号" }, false);
		orders.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//双击显示订单详细信息
				if (e.getClickCount() == 2) {
					row = orders.getSelectedRow();
					String orderId = orders.getData(row)[0];
					ArrivalCommodityInfoCheck.this.showOrderInfo(orderId);
				}
			}
		});

		this.add(new MyJScrollPane(250, 150, 340, 370, orders));

		orderInfo = new MyEmptyTextArea(690, 150, 340, 370);
		this.add(orderInfo);

		MyJButton produceArrivalList = new MyJButton(583, 630, 115, 23,
				"生成到达单", 18);
		produceArrivalList.setActionCommand("produceArrivalList");
		produceArrivalList.addActionListener(frame);
		this.add(produceArrivalList);
	}

	private void showOrderInfo(String orderId){
		
	}
	/**
	 * 生成到达单
	 * @return
	 */
	public int produceArrivalList() {
		//未选中任何订单
		//if(row == -1) return 1;
		// TODO
		//选中订单，将其转化成到达单
		return 0;
	}
}
