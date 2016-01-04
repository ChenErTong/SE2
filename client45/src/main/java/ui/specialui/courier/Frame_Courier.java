package ui.specialui.courier;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.image.CommonImage;
import ui.image.CourierImage;
import ui.myui.MyButton;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.courier.orderInput.OrderInput;
import ui.specialui.courier.receiveInput.ReceiveInput;
import ui.specialui.courier.timeAndCostManager.TimeAndCostManager;

/**
 * 快递员界面
 * 
 * @author czw
 * @time 2015年11月15日下午10:04:34
 */
public class Frame_Courier extends MyJFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Panel_Courier_Total totalPanel;
	private MyJPanel subPanel;
	// 导航栏
	private MyButton orderInput;
	private MyButton receiveInput;
	private MyButton timeAndCost;

	public Frame_Courier(String userID) {
		super(userID);
		totalPanel = new Panel_Courier_Total(this);
		this.add(totalPanel);

		this.returnButton.addActionListener(this);
		
		orderInput = new MyButton(910, 690, 80, 20,
				CourierImage.getBUTTON_DINGDAN_GUIDE());
		orderInput.setActionCommand("OrderInput");
		orderInput.addActionListener(this);
		receiveInput = new MyButton(1000, 690, 120, 20,
				CourierImage.getBUTTON_SHOUJIAN_GUIDE());
		receiveInput.setActionCommand("ReceiveInput");
		receiveInput.addActionListener(this);
		timeAndCost = new MyButton(1130, 690, 140, 20,
				CourierImage.getBUTTON_BAOJIASHIJIAN_GUIDE());
		timeAndCost.setActionCommand("TimeCostManager");
		timeAndCost.addActionListener(this);
		this.add(orderInput);
		this.add(receiveInput);
		this.add(timeAndCost);
		this.setNavigation(false);

		this.setBackground(CommonImage.BACKGROUND);

		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("return")) {
			if (subPanel != null) {
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
				this.setNavigation(false);
			}else{
				this.logout();
			}
		} else if (e.getActionCommand().equals("OrderInput")) {
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new OrderInput(this);
			this.getLayeredPane().add(subPanel, new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		} else if (e.getActionCommand().equals("ReceiveInput")) {
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new ReceiveInput(this);
			this.getLayeredPane().add(subPanel, new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		} else if (e.getActionCommand().equals("TimeCostManager")) {
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new TimeAndCostManager(this);
			this.getLayeredPane().add(subPanel, new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		} else if (e.getActionCommand().equals("produceOrder")) {
			if (this.produceOrder()) {
				((OrderInput) subPanel).refresh();
			}
		} else if (e.getActionCommand().equals("produceReceiveList")) {
			if (this.produceReceiveList()) {
				((ReceiveInput) subPanel).refresh();
			}
		} else if (e.getActionCommand().equals("calculateTimeCost")) {
			if (this.calculateTimeCost()) {
				((TimeAndCostManager) subPanel).refresh();
			}
		}
	}

	/**
	 * 生成订单
	 * 
	 * @return 是否成功生成订单
	 * @TODO 与bl层连接
	 */
	private boolean produceOrder() {
		switch (((OrderInput) subPanel).produceOrder(this)) {
		case 0:
			new MyNotification(this, "成功生成订单", Color.GREEN);
			return true;
		case 1:
			new MyNotification(this, "请完成寄件人信息填写", Color.RED);
			break;
		case 2:
			new MyNotification(this, "请完成收件人信息填写", Color.RED);
			break;
		case 3:
			new MyNotification(this, "请完成货运信息填写", Color.RED);
			break;
		case 4:
			new MyNotification(this, "请完成货物信息填写", Color.RED);
			break;
		}
		return false;
	}

	/**
	 * 生成收件单
	 * 
	 * @return 是否成功生成收件单
	 * @TODO 与bl层连接
	 */
	private boolean produceReceiveList() {
		switch (((ReceiveInput) subPanel).produceReceiveList(this)) {
		case 0:
			new MyNotification(this, "成功生成收件单", Color.GREEN);
			return true;
		case 1:
			new MyNotification(this, "请完成收件信息填写", Color.RED);
			break;
		case 2:
			new MyNotification(this, "请先确认一件订单", Color.RED);
			break;
		}
		return false;
	}

	/**
	 * 计算预估时间与费用
	 * 
	 * @return 是否成功
	 */
	private boolean calculateTimeCost() {
		switch (((TimeAndCostManager) subPanel).calculateTimeAndCost()) {
		case 0:
			new MyNotification(this, "计算完成", Color.GREEN);
			return true;
		case 1:
			new MyNotification(this, "请完成寄件人信息填写", Color.RED);
			break;
		case 2:
			new MyNotification(this, "请完成收件人信息填写", Color.RED);
			break;
		case 3:
			new MyNotification(this, "请完成货运信息填写", Color.RED);
			break;
		case 4:
			new MyNotification(this, "请完成货物信息填写", Color.RED);
			break;
		}
		return false;
	}

	// 设置导航栏是否隐藏
	private void setNavigation(boolean isVisible) {
		orderInput.setVisible(isVisible);
		receiveInput.setVisible(isVisible);
		timeAndCost.setVisible(isVisible);
		subscript.setVisible(isVisible);
	}
}