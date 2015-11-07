package ui.commonui.annocement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnnocementPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton button_yes;
	
	public AnnocementPanel(String name){
		
		int width = 400;
		int height = 150;
		
		Color foreColor = Color.WHITE;
		Color backColor = Color.getColor(name);
		
		this.setBounds((1280-width)/2, (720-height)/2, width, height);
		
		JLabel infoBar = new JLabel("提示",JLabel.CENTER);
		infoBar.setBounds(0, 0, width, 40);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		
		this.add(infoBar);
		
		JLabel warning = new JLabel(name,JLabel.CENTER);
		warning.setForeground(Color.RED);
		warning.setBackground(new Color(0,0,0,0));
		warning.setBounds(0, 40, 400, 30);
		this.add(warning);
		
		button_yes = new JButton("返回");
		button_yes.setBounds(140,80,120,25);
		button_yes.setForeground(foreColor);
		button_yes.setBackground(backColor);
		button_yes.addActionListener(this);
		this.add(button_yes);
	}

	@Override
	public void actionPerformed(ActionEvent events) {
		// TODO Auto-generated method stub
		if(events.getSource()==button_yes){
			AnnocementFrame.button_Close.doClick();
		}
	}
}
