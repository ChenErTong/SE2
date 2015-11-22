package ui.specialui.admin.TotalPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.specialui.admin.Frame_Admin;
import ui.specialui.branch_conuterman.Frame_Branch;
import ui.specialui.branch_conuterman.facilityInfoManage.FacilityInfo;
import ui.specialui.branch_conuterman.facilityInfoManage.FacilityInfoManage;


public class Panel_Admin_Total extends MyJPanel{
	private UserInfo userInfo;
	private UserDetails userDetails;
	private MyJButton commonButton;
	public Panel_Admin_Total(Frame_Admin frame_Admin) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Admin);
	//	this.insertPanel(frame_Admin);
	
	}
	
	private void initComponent(Frame_Admin frame_Admin){
		userInfo = new UserInfo(frame_Admin);
		this.add(userInfo);
		userDetails = new UserDetails();
		this.add(userDetails);
	}
	
/*	MyJButton AddUser = new MyJButton(50, 670, 150, 40,"添加用户",14);
		AddUser.setActionCommand("AddUser");
		AddUser.addActionListener(frame_Admin);
		this.add(AddUser);
		AddUser.setVisible(true);
		
		MyJButton ViewUserInfomation = new MyJButton(210, 670, 150, 40,"查看用户信息",14);
		ViewUserInfomation.setActionCommand("ViewUserInfomation");
		ViewUserInfomation.addActionListener(frame_Admin);
		this.add(ViewUserInfomation);
		ViewUserInfomation.setVisible(true);
		
		MyJButton DeleteUser = new MyJButton(370, 670, 150, 40,"删除用户",14);
		DeleteUser.setActionCommand("DeleteUser");
		DeleteUser.addActionListener(frame_Admin);
		this.add(DeleteUser);
		DeleteUser.setVisible(true);
		
		MyJButton ModifyUserInfomation = new MyJButton(530,670,150,40,"修改用户信息",14);
		ModifyUserInfomation.setActionCommand("ModifyUserInformation");
		ModifyUserInfomation.addActionListener(frame_Admin);
		this.add(ModifyUserInfomation);
		ModifyUserInfomation.setVisible(true);
		
		MyJButton SaveChanges = new MyJButton(690, 670, 150, 40,"保存更改",14);
		SaveChanges.setActionCommand("SaveChanges");
		SaveChanges.addActionListener(frame_Admin);
		this.add(SaveChanges);
		
		MyJButton Backout = new MyJButton(850, 670, 150, 40,"撤销",14);
		Backout.setActionCommand("Backout");
		Backout.addActionListener(frame_Admin);
		this.add(Backout);*/
		
		/*MyJButton Withdraw = new MyJButton(1120,55,150,40,"注销登录",14);
		Withdraw.setActionCommand("Withdraw");
		Withdraw.addActionListener(frame_Admin);
		this.add(Withdraw);*/
		
	
		private void insertPanel(Frame_Admin frame) {
		this.removeAll();
		this.add(userInfo);
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
		this.initButton(frame);
	
		
		userDetails = new UserDetails();
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
		this.add(userDetails);
		
		//this.add(new MyJLabel(415, 110, 100, 40, "车辆代号", 20, true));
		//this.add(facilityId);
		
		commonButton = new MyJButton(890, 670, 120, 30, "修改用户信息", 20);
		commonButton.setActionCommand("modifyFacility");
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
		this.add(userDetails);
		
		commonButton = new MyJButton(890, 670, 120, 30, "删除用户", 20);
		commonButton.setActionCommand("deleteUser");
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
	 * 查找用户
	 */
/*	@SuppressWarnings("unused")
	public boolean searchUser() {
		String[] data;
		
		// TODO
		data = null;
		
		if(data == null){
			return false;
		}
	//	id = facilityId.getText();
		userDetails.setData(data);
		return true;
	}

	public int addUser() {
		int result = this.getData();
		if(result == 0){
			// TODO
			// 添加车辆
		}
		return result;
	}

	public int modifyUser() {
		if(id == null){
			return 2;
		}
		int result = this.getData();
		if(result == 0){
			// TODO
			// 修改车辆
		}
		return result;
	}
	
	public int deleteUser() {
		if(id == null){
			return 2;
		}
		// TODO
		// 删除车辆
		return 0;
	}
	
	public void refresh() {
		userDetails.refresh();
	//	facilityId.setText(null);
	}
	
	private int getData(){
		@SuppressWarnings("unused")
		String[] data;
		if((data = userDetails.getData()) == null) return 1;
		return 0;	
	}
		
		
	//	MyJLabel title = new MyJLabel(600,50,210,50,"用户信息",22,true);
		//this.add(title);
		
*/
		
	private static final long serialVersionUID = 1L;
		

	}

	
