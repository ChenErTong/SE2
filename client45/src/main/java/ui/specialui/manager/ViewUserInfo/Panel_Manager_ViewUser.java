package ui.specialui.manager.ViewUserInfo;


import ui.myui.MyJButton;
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
