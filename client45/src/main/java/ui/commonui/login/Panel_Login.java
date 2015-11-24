package ui.commonui.login;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJRadioButton;
import ui.myui.MyJTextField;
/**
 * 登陆界面
 * @author 
 * @time 下午4:08:40
 */
public class Panel_Login extends MyJPanel{
	private static final long serialVersionUID = 1L;
	private MyJTextField userIdField;
	private MyJTextField passwordField;
	private MyJRadioButton keepPassword;
	private MyJButton login;
	private MyJButton backout;
	public Panel_Login(Frame_Login frame_Login) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Login);
	}
	
	private void initComponent(Frame_Login frame_Login){
		this.add(new MyJLabel(432,80,500,90,"快递物流管理系统",50,true));
		
		this.add(new MyJLabel(500, 235, 90, 40,"用户ID",18,true));
		this.add(new MyJLabel(500,285,90,40,"密码",18,true));
		
		userIdField = new MyJTextField(590, 235, 200, 40);
		this.add(userIdField);

		passwordField = new MyJTextField(590, 285, 200, 40);
		this.add(passwordField);
		
		keepPassword= new MyJRadioButton(620,335,200,30,"记住密码");
		keepPassword.addActionListener(frame_Login);
		this.add(keepPassword);
		
		login = new MyJButton(590,385,90,40,"登录",18);
		login.setActionCommand("login");
		login.addActionListener(frame_Login);
		this.add(login);
		
		backout = new MyJButton(690,385,90,40,"取消",18);
		backout.setActionCommand("backout");
		backout.addActionListener(frame_Login);
		this.add(backout);
	}
	
	
		
	
}
