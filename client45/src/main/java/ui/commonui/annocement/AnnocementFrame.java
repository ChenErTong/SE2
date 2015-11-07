package ui.commonui.annocement;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class AnnocementFrame extends JDialog implements ActionListener{
	public static JButton button_Close;
	AnnocementPanel annocementPanel;
	public AnnocementFrame(String name){
		annocementPanel = new AnnocementPanel(name);
		//setContentPane(annocementPanel);
		annocementPanel.setOpaque(true);
		annocementPanel.setBackground(new Color(0,0,0,0.8f));
		this.add(annocementPanel);
		
		button_Close = new JButton();
		button_Close.addActionListener(this);
		this.add(button_Close);
		
		this.setBackground(new Color(0,0,0,0.6f));
	}

	

	@Override
	public void actionPerformed(ActionEvent events) {
		// TODO Auto-generated method stub
		if(events.getSource()==button_Close){
			this.setVisible(false);
		}
	}
}
