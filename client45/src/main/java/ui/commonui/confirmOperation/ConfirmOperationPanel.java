package ui.commonui.confirmOperation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ui.myui.MyColor;
import ui.myui.MyJPanel;

public class ConfirmOperationPanel extends MyJPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton button_yes,button_no;
	String flag;
	
	public ConfirmOperationPanel(){
		super(0,0,400,150);
		int width = 400;
		int height = 150;
		
		Color foreColor = Color.BLACK;
		Color backColor = MyColor.getColor();
		
		this.setBounds((1280-width)/2,(720-height)/2,width,height);
		
		JLabel infoBar = new JLabel("请确认是否进行本次操作",JLabel.CENTER);
		infoBar.setBounds(0,0,WIDTH,200);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		button_yes = new JButton("是");
		button_yes.setBounds(40,60,120,30);
		button_yes.setForeground(foreColor);
		button_yes.setBackground(backColor);
		this.add(button_yes);
		
		button_no = new JButton("否");
		button_no.setBounds(240,60,120,30);
		button_no.setForeground(foreColor);
		button_no.setBackground(backColor);
		this.add(button_no);
		
		this.add(infoBar);
	}
	@Override
	public void actionPerformed(ActionEvent events) {
		if(events.getSource()==button_no){
			ConfirmOperationFrame.button_close.doClick();
		}
		if(events.getSource()==button_yes){
			switch(flag){
			
			case "DeleteUser":
			}
		ConfirmOperationFrame.button_close.doClick();
		}
	}
	public void setFlag(String flag){
		this.flag = flag;
	}
}
