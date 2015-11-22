package ui.myui;

import javax.swing.JPanel;

/**
 * panel的总类
 * @author czw
 * @time 2015年11月15日下午4:11:05
 */
public class MyJPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public MyJPanel(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setVisible(true);
	}
}