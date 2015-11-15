package ui.commonui.exitThisFunction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;


public class ExitThisFunctionFrame extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ExitThisFunctionPanel panel;
	public static JButton button_close;
	
	public ExitThisFunctionFrame(String flag){
		
		panel = new ExitThisFunctionPanel();
		panel.setOpaque(true);
		panel.setBackground(new Color(0,0,0,0.8f));
		this.add(panel);
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
		this.setBackground(new Color(0,0,0,0.8f));
	}
	@Override
	public void actionPerformed(ActionEvent events) {
		// TODO Auto-generated method stub
		if(events.getSource()==button_close){
			this.setVisible(false);
		}
	}

	
}
