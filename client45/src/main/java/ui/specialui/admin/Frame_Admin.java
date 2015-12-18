
package ui.specialui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
/**
 * 管理员用户管理界面的主Frame
 * @author zsq
 * @version 2015/12/4 23:20
 */
public class Frame_Admin extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Panel_Admin_Total totalPanel;
	
	public Frame_Admin(String userID){
		super(userID);
		totalPanel = new Panel_Admin_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.BACKGROUND);
		this.repaint();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			this.logout();
		}
	}
}
