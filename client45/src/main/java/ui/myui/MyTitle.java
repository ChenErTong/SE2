package ui.myui;


import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.image.CommonImage;

public class MyTitle{
	public static void setTitle(JPanel panel, String text, int x, int y, int width, int height){
		JLabel title = new JLabel(CommonImage.getTITLE(text));
		title.setBounds(x, y, width, height);
		title.setVisible(true);
		panel.add(title);
	}
}