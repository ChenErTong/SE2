package ui.specialui.courier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.specialui.courier.orderInput.OrderInput;
import ui.specialui.courier.orderInput.SenderInfoInput;

/**
 * 快递员界面
 * @author czw
 * @time 2015年11月15日下午10:04:34
 */
public class Frame_Courier extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Panel_Courier_Total totalPanel;
	OrderInput orderInput;
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
		}
	}
}
