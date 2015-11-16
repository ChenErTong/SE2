package ui.specialui.courier;

import javax.swing.JButton;
import ui.myui.MyTranslucentPanel;

public class Panel_Courier_OrderInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Courier_OrderInput(Frame_Courier frame) {
		super(60, 40, 550, 640);
		this.initComponent();
	}
	
	private void initComponent(){
		JButton test = new JButton("Test");
		test.setBounds(0, 0, 150, 40);
		this.add(test);
		test.setVisible(true);
	}
}