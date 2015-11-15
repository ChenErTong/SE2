package ui.specialui.courier;

import javax.swing.JButton;
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
		
		JButton OrderInput = new JButton("订单输入");
		OrderInput.setBounds(200, 300, 150, 40);
		OrderInput.setActionCommand("OrderInput");
		OrderInput.addActionListener(frame);
		this.add(OrderInput);
		OrderInput.setVisible(true);
		
		JButton ReceiveInput = new JButton("收件信息输入");
		ReceiveInput.setBounds(200, 350, 150, 40);
		ReceiveInput.setActionCommand("ReceiveInput");
		ReceiveInput.addActionListener(frame);
		this.add(ReceiveInput);
		ReceiveInput.setVisible(true);
		
		JButton TimeCostManager = new JButton("报价和时间管理");
		TimeCostManager.setBounds(200, 400, 150, 40);
		TimeCostManager.setActionCommand("TimeCostManager");
		TimeCostManager.addActionListener(frame);
		this.add(TimeCostManager);
		TimeCostManager.setVisible(true);
	}
}
