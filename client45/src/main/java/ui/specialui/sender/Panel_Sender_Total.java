package ui.specialui.sender;

import java.awt.Font;

import javax.swing.JLabel;

import ui.myui.MyJPanel;

public class Panel_Sender_Total extends MyJPanel{

	public Panel_Sender_Total(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	
	public Panel_Sender_Total(Frame_Sender frame_Sender) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		
		//订单号和寄件人姓名label
		JLabel	label_field1 = new JLabel();
		label_field1.setBounds(221, 414, 200, 40);
		label_field1.setFont(new Font("Arail",Font.PLAIN,20));
		//this.add(label_field1);
		this.add(label_field1);
		label_field1.setVisible(true);
		
		JLabel	label_field2 = new JLabel();
		label_field2.setBounds(221,464,200,40);
		label_field2.setFont(new Font("Arail",Font.PLAIN,20));
		//	this.add(label_field2);
		this.add(label_field2);
		label_field2.setVisible(true);
	}


	private static final long serialVersionUID = 1L;

}
