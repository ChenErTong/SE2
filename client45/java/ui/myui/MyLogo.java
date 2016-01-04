package ui.myui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.image.CommonImage;

public class MyLogo{
	public static void setLogo(JPanel panel){
		JLabel logo = new JLabel(CommonImage.getLOGO());
		logo.setBounds(250, 80, 155, 157);
		logo.setVisible(true);
		panel.add(logo);
	}
}