package ui.commonui.exitSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExitSystemPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton button_yes,button_no;
	
	public ExitSystemPanel(){
		int width = 400;
		int height = 150;
		
		this.setBounds((1280-width)/2,(720-height)/2,width,height);
		
		Color foreColor = Color.WHITE;
		Color backColor = Color.BLUE;
		
		JLabel infoBar = new JLabel("请确认是否退出本系统",JLabel.CENTER);
		
		infoBar.setBounds(0,0,width,20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		button_yes = new JButton("是");
		button_yes.setBounds(40,60,120,30);
		button_yes.setForeground(foreColor);
		button_yes.setBackground(backColor);
		button_yes.addActionListener(this);
		this.add(button_yes);
		
		button_yes = new JButton("否");
		button_yes.setBounds(240,60,120,30);
		button_yes.setForeground(foreColor);
		button_yes.setBackground(backColor);
		button_yes.addActionListener(this);
		this.add(button_no);
	}
	@Override
	public void actionPerformed(ActionEvent events) {
		// TODO Auto-generated method stub
		if(events.getSource()==button_yes){
			System.exit(0);
		}
		if(events.getSource()==button_no){
			this.setVisible(true);
			ExitSystemFrame.button_close.doClick();
		}
	}
	
	

}
