package ui.specialui.courier;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyNotification;
import ui.specialui.courier.orderInput.OrderInput;

/**
 * 快递员界面
 * @author czw
 * @time 2015年11月15日下午10:04:34
 */
public class Frame_Courier extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Panel_Courier_Total totalPanel;
	private OrderInput orderInput;
	
	public Frame_Courier(){
		totalPanel = new Panel_Courier_Total(this);
		this.add(totalPanel);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OrderInput")){
			totalPanel.setVisible(false);
			orderInput = new OrderInput(this);
			this.add(orderInput);
			this.getLayeredPane().add(orderInput,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ReceiveInput")){
			totalPanel.setVisible(false);
		}else if(e.getActionCommand().equals("TimeCostManager")){
			totalPanel.setVisible(false);
		}else if(e.getActionCommand().equals("produceOrder")){
			if(this.produceOrder()){
				orderInput.setVisible(false);
				this.remove(orderInput);
				orderInput = null;
				// TODO 跳转至订单单据界面
			}
		}
	}
	/**
	 * 生成订单
	 * @return 是否成功生成订单
	 * @TODO 与bl层连接
	 */
	private boolean produceOrder(){
		switch(orderInput.produceOrder()){
		case 0: new MyNotification(this, "请完成寄件人信息填写", Color.RED); break;
		case 1: new MyNotification(this, "请完成收件人信息填写", Color.RED); break;
		case 2: new MyNotification(this, "请完成货运信息填写", Color.RED); break;
		case 3: new MyNotification(this, "请完成货物信息填写", Color.RED); break;
		case 4: new MyNotification(this, "成功生成订单", Color.GREEN); return true;
		}	
		return false;
	}
}