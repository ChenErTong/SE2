package ui.commonui.login;

import java.awt.Font;

import javax.swing.JLabel;

import ui.myui.MyJPanel;
/**
 * 登陆界面
 * @author 
 * @time 下午4:08:40
 */
public class Panel_Login extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Login(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public Panel_Login(Frame_Login frame_Login) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		//ID和密码label
			JLabel	label_field1 = new JLabel();
			label_field1.setBounds(221, 414, 200, 40);
			label_field1.setFont(new Font("Arail",Font.PLAIN,20));
			//this.add(label_field1);
			this.add(label_field1);
			//label_field1.setVisible(true);
			
			JLabel	label_field2 = new JLabel();
			label_field2.setBounds(221,464,200,40);
			label_field2.setFont(new Font("Arail",Font.PLAIN,20));
			//	this.add(label_field2);
			this.add(label_field2);
			//label_field2.setVisible(true);
		
		
	}
}
