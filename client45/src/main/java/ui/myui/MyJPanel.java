package ui.myui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
/**
 * panel的总类
 * @author czw
 * @time 2015年11月15日下午4:11:05
 */
public class MyJPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public MyJPanel(){
		this.setOpaque(false);
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setVisible(true);
	}
}
