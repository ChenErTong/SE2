
package ui.specialui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.commonui.login.Frame_Login;
import ui.commonui.login.Panel_Login;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
/**
 * 管理员用户管理界面的主Frame
 * @author zsq
 * @version 2015/12/4 23:20
 */
public class Frame_Admin extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private MyJPanel subPanel;
	private Panel_Admin_Total totalPanel;
	
	public Frame_Admin(String userID){
		super(userID);
		totalPanel = new Panel_Admin_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		this.withdrawButton.addActionListener(this);
		this.setBackground(CommonImage.BACKGROUND);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
			}
		}else if(e.getActionCommand().equals("Withdraw")){
			Frame_Login login = new Frame_Login(ID);
			subPanel = new Panel_Login(login);
			subPanel.setVisible(true);
		}
	}
}
