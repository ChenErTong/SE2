package ui.commonui.confirmOperation;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * 确定是否进行此操作的窗体
 * @author zsq
 * 
 */
public class ConfirmOperationFrame extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ConfirmOperationPanel panel;
	public static JButton button_close;
	
	public ConfirmOperationFrame(String flag){
		
		panel = new ConfirmOperationPanel();
		panel.setOpaque(true);
		panel.setBackground(new Color(0,0,0,0.8f));
		this.add(panel);
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
		//this.setBackground(new Color(0,0,0,0.6f));
	}
	@Override
	public void actionPerformed(ActionEvent events) {
		// TODO Auto-generated method stub
		if(events.getSource()==button_close){
			this.setVisible(false);
		}
	}

}
