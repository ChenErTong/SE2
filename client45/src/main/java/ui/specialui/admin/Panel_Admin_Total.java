package ui.specialui.admin;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import businesslogic.ControllerFactory;
import businesslogic.userbl.UserController;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;

import vo.UserVO;


public class Panel_Admin_Total extends MyJPanel{
	private UserInfo userInfo;
	private UserDetails userDetails;
	private MyJButton commonButton;
	private UserVO user;
	@SuppressWarnings("unused")
	private ArrayList<UserVO> userList;
	private UserController userController;
	public Panel_Admin_Total(Frame_Admin frame_Admin) {
		super(0, 0, 1280, 720);
		
		userController = ControllerFactory.getUserController();
		
		this.setOpaque(false);

		this.initComponent(frame_Admin);

	
	}
	
	private void initComponent(Frame_Admin frame_Admin){
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
	
		userInfo = new UserInfo(frame_Admin);
		this.add(userInfo);
		
		userDetails = new UserDetails();
		userDetails.setUneditable();
		this.add(userDetails);
		this.initButton(frame_Admin);
	}	
	
		private void insertPanel(Frame_Admin frame) {
		this.removeAll();
		this.add(userInfo);
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
		this.initButton(frame);
	
		
		userDetails = new UserDetails();
		userDetails.add(new MyJLabel(230,5,120,30,"新增用户",18,true));
		this.add(userDetails);
		
		
		commonButton = new MyJButton(890, 670, 120, 30, "添加用户", 20);
		commonButton.setActionCommand("AddUser");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void modifyPanel(Frame_Admin frame) {
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
		this.add(userInfo);
		this.initButton(frame);
		
		userDetails = new UserDetails();
		userDetails.add(new MyJLabel(230,5,120,30,"修改用户信息",18,true));
		this.add(userDetails);
		
		//this.add(new MyJLabel(415, 110, 100, 40, "车辆代号", 20, true));
		//this.add(facilityId);
		
		commonButton = new MyJButton(890, 670, 150, 30, "修改用户信息", 20);
		commonButton.setActionCommand("ModifyUserInformation");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void searchPanel(Frame_Admin frame) {
		
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
		this.add(userInfo);
		this.initButton(frame);
		
		userDetails = new UserDetails();
		userDetails.setUneditable();
		userDetails.add(new MyJLabel(230,5,120,30,"查看用户信息",18,true));
		this.add(userDetails);
		
		this.repaint();
	}

	private void deletePanel(Frame_Admin frame) {
		
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
		this.add(userInfo);
		this.initButton(frame);
		
		userDetails = new UserDetails();
		userDetails.setUneditable();
		userDetails.add(new MyJLabel(230,5,120,30,"删除用户",18,true));
		this.add(userDetails);
		
		commonButton = new MyJButton(890, 670, 120, 30, "删除用户", 20);
		commonButton.setActionCommand("DeleteUser");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void initButton(Frame_Admin frame) {
		MyJButton insertButton = new MyJButton(0, 150, 40, 130,
				"<html>添<br/>加<br/>用<br/>户<br/></html>", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

		MyJButton modifyButton = new MyJButton(0, 280, 40, 130,
				"<html>修<br/>改<br/>用<br/>户<br/>信<br/>息<br/></html>", 18);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.modifyPanel(frame);
				
			}
		});
		this.add(modifyButton);

		MyJButton searchButton = new MyJButton(0, 410, 40, 130,
				"<html>查<br/>看<br/>用<br/>户<br/></html>", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.searchPanel(frame);
				
			}
		});
		this.add(searchButton);

		MyJButton deleteButton = new MyJButton(0, 540, 40, 110,
				"<html>删<br/>除<br/>用<br/>户<br/></html>", 18);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.deletePanel(frame);
				
			}
		});
		this.add(deleteButton);
	}
	/**
	 * TODO 从bl层获取数据
	 * 添加用户
	 */

	public int addUser() {
		String [] data = userDetails.getData();
		if(data == null){
			return 1;
		}
		data[0] = userController.getID();
		user = new UserVO(data[0], data[1], data[2], data[3], data[4], data[5],data[8]);
		userController.addUser(user);
		userController.confirmOperation();
		return 0;
		
	}
/**
 * 修改用户信息
 * 从bl层获得数据
 */
	public int modifyUser() {
		String [] data = userDetails.getData();
		if(data == null){
			return 1;
		}
		user.setId(data[0]);
		user.setPassword(data[1]);
		user.setUserName(data[2]);
		user.setPhoneNumber(data[3]);
		user.setIden(data[4]);
		user.setAuthority(data[5]);
		user.setAddress(data[9]);
		userController.updateUser(user);
		userController.confirmOperation();
		return 0;
	}
	/**
	 * 删除用户
	 * @return
	 */
	public int deleteUser() {
		//现在列表中选择一个用户后再进行删除
		userController.deleteUser(user);
		userController.confirmOperation();
		return 0;
	}
	
	public void refresh() {
		userDetails.refresh();
	}
	/**
	 * 查看用户信息列表
	 * TODO 从bl层获取数据
	 */
	public boolean searchUser() {		
		String type = userInfo.getData();
		if(type==null){
			return false;
		}
		userList = userController.show(type);
		return true;
	}
	
	/**
	 * 查看用户详细信息
	 */
	public boolean viewUserDetails(){
		//TODO
		//从userList中选择一个要查看的用户
		return false;
	}
	private static final long serialVersionUID = 1L;
		

	}

	
