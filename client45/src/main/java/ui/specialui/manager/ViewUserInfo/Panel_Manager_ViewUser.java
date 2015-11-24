package ui.specialui.manager.ViewUserInfo;


import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;

public class Panel_Manager_ViewUser extends MyJPanel{
	private UserInfo userInfo;
	public Panel_Manager_ViewUser(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}
	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(550, 20, 210, 90, "查看公司员工信息", 24, true));
		MyJButton ViewUser = new MyJButton(565, 670, 150, 40,"查看员工信息",14);
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(frameManager);
		this.add(ViewUser);
		ViewUser.setVisible(true);
		
		userInfo = new UserInfo(frameManager);
		this.add(userInfo);
	
	}

	private static final long serialVersionUID = 1L;

}
