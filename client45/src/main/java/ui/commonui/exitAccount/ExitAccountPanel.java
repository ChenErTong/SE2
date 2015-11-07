package ui.commonui.exitAccount;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.commonui.exitThisFunction.ExitThisFunctionFrame;
import ui.commonui.login.Frame_Login;

public class ExitAccountPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton button_yes,button_no;
	String flag;
	
	public ExitAccountPanel(String flag){
		int width = 400;
		int height = 150;
		
		Color foreColor = Color.WHITE;
		Color backColor = Color.CYAN;
		
		this.setBounds((1280-width)/2,(720-height)/2,width,height);
		
		JLabel infoBar = new JLabel("请确认是否注销此账号",JLabel.CENTER);
		infoBar.setBounds(0,0,WIDTH,20);
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
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
	}
	@Override
	public void actionPerformed(ActionEvent events) {
		// TODO Auto-generated method stub
		if(events.getSource()==button_no){
			ExitAccountFrame.button_close.doClick();
		}
		if(events.getSource()==button_yes){
			Frame_Login fl = new Frame_Login();
			fl.setVisible(true);
			ExitAccountFrame.button_close.doClick();
			
			switch(flag){
			case"Frame_Admin": break;
			case"Frame_Inventory":break;
			case"Frame_Manager": break;
			case"Frame_Branch":break;
			case"Frame_Courier":break;
			case"Frame_Finance":break;
			case"Frame_Transfer":break;
			}
			ExitAccountFrame.button_close.doClick();
		}
	}
	public void setFlag(String flag){
		this.flag = flag;
	}

}
