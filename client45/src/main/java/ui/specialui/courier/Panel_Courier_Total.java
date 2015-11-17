package ui.specialui.courier;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;
/**
 * 快递员主界面
 * @author czw
 * @time 2015年11月15日下午10:38:11
 */
public class Panel_Courier_Total extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Courier_Total(Frame_Courier frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.initComponent(frame);
	}
	private void initComponent(Frame_Courier frame){
		MyJButton OrderInput = new MyJButton(200, 300, 150, 40, "订单输入", 15);
		OrderInput.setActionCommand("OrderInput");
		OrderInput.addActionListener(frame);
		this.add(OrderInput);
		
		MyJButton ReceiveInput = new MyJButton(200, 350, 150, 40, "收件信息输入", 15);
		ReceiveInput.setActionCommand("ReceiveInput");
		ReceiveInput.addActionListener(frame);
		this.add(ReceiveInput);
		
		MyJButton TimeCostManager = new MyJButton(200, 400, 150, 40, "报价和时间管理", 15);
		TimeCostManager.setActionCommand("TimeCostManager");
		TimeCostManager.addActionListener(frame);
		this.add(TimeCostManager);
	}
}