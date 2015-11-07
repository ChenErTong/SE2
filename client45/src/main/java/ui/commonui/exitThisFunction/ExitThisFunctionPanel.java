package ui.commonui.exitThisFunction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ExitThisFunctionPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JButton button_yes,button_no;
	String flag;
	
	public ExitThisFunctionPanel(){
		int width = 400;
		int height = 150;
		
		Color foreColor = Color.WHITE;
		Color backColor = Color.CYAN;
		
		this.setBounds((1280-width)/2,(720-height)/2,width,height);
		
		JLabel infoBar = new JLabel("请确认是否离开此功能界面",JLabel.CENTER);
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
			ExitThisFunctionFrame.button_close.doClick();
		}
		if(events.getSource()==button_yes){
			switch(flag){
			//TODO-在不同的几面进行不同的操作时根据flag调用
			}
			ExitThisFunctionFrame.button_close.doClick();
		}
	}
	public void setFlag(String flag){
		this.flag = flag;
	}
}
