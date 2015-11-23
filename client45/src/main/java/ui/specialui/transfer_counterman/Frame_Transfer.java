package ui.specialui.transfer_counterman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;

public class Frame_Transfer extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Panel_Transfer_Total totalPanel;
	private MyJPanel subPanel;
	
	public Frame_Transfer() {
		this.totalPanel = new Panel_Transfer_Total(this);
		this.add(totalPanel);
		
		this.returnButton.addActionListener(this);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}