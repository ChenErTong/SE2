package ui.specialui.admin;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.userbl.UserController;
import state.ResultMessage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import vo.UserVO;


public class Panel_Admin_Total extends MyJPanel implements ActionListener{
	private UserInfo userInfo;
	private UserDetails userDetails;
	private MyJButton commonButton;
	
	private MyJTable table;
	
	static ArrayList<UserVO> userPool;
	static String userID = " ";
	@SuppressWarnings("unused")
	private ArrayList<UserVO> userList;
	private UserController userController ;
	public Panel_Admin_Total(Frame_Admin frame_Admin)  {
		super(0, 0, 1280, 720);
		
		userController = ControllerFactory.getUserController();
		userPool = new ArrayList<UserVO>();
		this.setOpaque(false);

		this.initComponent(frame_Admin);

		this.showAll();
	
	}
	
	private void initComponent(Frame_Admin frame_Admin){
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
	
		userInfo = new UserInfo(this);
		this.add(userInfo);
		
		userDetails = new UserDetails();
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
		
		
		commonButton = new MyJButton(890, 670, 120, 30, "确认添加", 20);
		commonButton.setActionCommand("AddUser");
		commonButton.addActionListener(this);
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
		
		commonButton = new MyJButton(890, 670, 150, 30, "修改用户信息", 20);
		commonButton.setActionCommand("CheckModify");
		commonButton.addActionListener(this);
		this.add(commonButton);
		
		this.repaint();
	}

	private void searchPanel(Frame_Admin frame) {
		
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
		this.add(userInfo);
		this.initButton(frame);
		
		userDetails = new UserDetails();
	//	userDetails.setUneditable();
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
		
		//commonButton = new MyJButton(890, 670, 120, 30, "删除用户", 20);
		//commonButton.setActionCommand("DeleteUser");
		//commonButton.addActionListener(this);
		//this.add(commonButton);
		
		this.repaint();
	}

	private void initButton(Frame_Admin frame) {
		MyJButton insertButton = new MyJButton(75, 660, 130, 40,
				"添加用户", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

		MyJButton modifyButton = new MyJButton(205, 660, 130, 40,
				"修改用户信息", 18);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.modifyPanel(frame);
				
			}
		});
		modifyButton.setActionCommand("ModifyUserInfo");
		modifyButton.addActionListener(this);
		this.add(modifyButton);

		MyJButton searchButton = new MyJButton(335, 660, 130, 40,
				"查看所选用户", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.searchPanel(frame);
				
			}
		});
		searchButton.setActionCommand("ViewUserInfo");
		searchButton.addActionListener(this);
		this.add(searchButton);

		MyJButton deleteButton = new MyJButton(465,  660, 130, 40,
				"删除用户", 18);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.deletePanel(frame);
				
			}
		});
		deleteButton.setActionCommand("DeleteUser");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
	}
	/**
	 * TODO 从bl层获取数据
	 * 添加用户
	 */

	/*public int addUser() {
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
/*	public int modifyUser() {
		String [] data = userDetails.getData();
		if(data == null){
			return 1;
		}
		user.id=data[0];
		user.password=data[1];
		user.userName=data[2];
		user.phoneNumber=data[3];
		user.iden=data[4];
		user.authority=data[5];
		user.address=data[9];
		userController.updateUser(user);
		userController.confirmOperation();
		return 0;
	}
	/**
	 * 删除用户
	 * @return
	 */
	/*public int deleteUser() {
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
/*	public boolean searchUser() {		
		String type = userInfo.getData();
		if(type==null){
			return false;
		}
		userList = userController.show();
		return true;
	}
	
	/**
	 * 查看用户详细信息
	 */
	/*public boolean viewUserDetails(){
		//TODO
		//从userList中选择一个要查看的用户
		return false;
	}*/
	private static final long serialVersionUID = 1L;
	
	/**
	 * 显示所有的用户账号
	 */
	public void showAll(){
			table = userInfo.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			userPool.clear();
			userID = "";
			
			userController = ControllerFactory.getUserController();
			ArrayList<UserVO> userVO= userController.show();
			
			for(int i = 0; i < userVO.size(); i++){
				String[] rowData = {userVO.get(i).id,userVO.get(i).userName,userVO.get(i).password,userVO.get(i).iden,userVO.get(i).authority
						,userVO.get(i).phoneNumber,userVO.get(i).address};
				tableModel.addRow(rowData);
				userPool.add(userVO.get(i));
			}
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("AddUser")){
			userController = ControllerFactory.getUserController();
			String[] data = userDetails.getData();
			if(userDetails.getData()==null){
				this.add(new MyNotification(this,"请检查用户信息填写是否完整！",Color.RED));
			}else{
				ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],data[4],data[5],data[6]+data[7]+data[8]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					System.out.println("AddSucceed!");
					this.showAll();
					new MyNotification(this,"账户添加成功！",Color.GREEN);
				}else{
					new MyNotification(this,"账户添加失败！",Color.RED);
				}
			}
		}else if(e.getActionCommand().equals("ModifyUserInfo")){
			table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				this.add(new MyNotification(this,"请先选择要修改的用户！",Color.RED));
			}else{
				userID = userPool.get(table.getSelectedRow()).id;
				System.out.println(userID);
				String[] data = new String[9];
				data[0] = userID;
				data[1] = userPool.get(table.getSelectedRow()).userName;
				data[2] = userPool.get(table.getSelectedRow()).password;
				data[3] = userPool.get(table.getSelectedRow()).iden;
				data[4] = userPool.get(table.getSelectedRow()).authority;
				data[5] = userPool.get(table.getSelectedRow()).phoneNumber;
				data[6] = userPool.get(table.getSelectedRow()).address;
				userDetails.setData(data);
			}
		}else if(e.getActionCommand().equals("DeleteUser")){
			table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				this.add(new MyNotification(this,"请先选择要删除的员工！",Color.RED));
			}else{
				new MyNotification(this,"正在删除账户！",Color.GREEN);
				this.deleteUser();
			
			}
		}else if(e.getActionCommand().equals("ViewUserInfo")){
			table = userInfo.getTable();
			if(table.getSelectedColumnCount()==0){
				this.add(new MyNotification(this,"请先选择要查看的员工！",Color.RED));
			}else{
				userID = userPool.get(table.getSelectedRow()).id;
				String[] data = new String[9];
				data[0] = userID;
				data[1] = userPool.get(table.getSelectedRow()).userName;
				data[2] = userPool.get(table.getSelectedRow()).password;
				data[3] = userPool.get(table.getSelectedRow()).iden;
				data[4] = userPool.get(table.getSelectedRow()).authority;
				data[5] = userPool.get(table.getSelectedRow()).phoneNumber;
				data[6] = userPool.get(table.getSelectedRow()).address;
				userDetails.setData(data);
			}
		}else if(e.getActionCommand().equals("CheckModify")){
			table = userInfo.getTable();
			userID= userPool.get(table.getSelectedRow()).id;
			if(table.getSelectedRow()==0){
				this.add(new MyNotification(this,"请先选择需要修改的用户！",Color.RED));
			}else{
				if(userDetails.getData()==null){
					new MyNotification(this,"请检查用户信息填写是否完整！",Color.RED);
				}else{
					new MyNotification(this,"正在修改账户信息！",Color.GREEN);
					this.modifyUser();
				}
			}
		}else if(e.getActionCommand().equals("SearchUser")){
			table = userInfo.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			userPool.clear();
			userID = "";
			
			// {"所有用户","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
			userController = ControllerFactory.getUserController();
			ArrayList<UserVO> userVO;
			String data = userInfo.getData()+"";
			if(data!=""){
				switch(Integer.parseInt(data)){
					case 1 : userVO = userController.show();break;
					case 2 : userVO = userController.show();break;
					case 3 : userVO = userController.show();break;
					case 4 : userVO = userController.show();break;
					case 5 : userVO = userController.show();break;
					case 6 : userVO = userController.show();break;
					case 7 : userVO = userController.show();break;
					default : userVO = userController.show();break;
					
				}
			
				for(int i = 0; i < userVO.size(); i++){
				String[] rowData = {userVO.get(i).id,userVO.get(i).userName,userVO.get(i).password,
						userVO.get(i).iden,userVO.get(i).authority,userVO.get(i).address,userVO.get(i).address};
				tableModel.addRow(rowData);
				userPool.add(userVO.get(i));
					System.out.println("SearchSucceed!");
					this.add(new MyNotification(this,"共有"+table.getColumnCount()+"个账户满足条件！",Color.GREEN));
				}
			}else{
					this.add(new MyNotification(this,"请选择查询类型！",Color.RED));
			}
		}
	}
	private void modifyUser() {
		userController = ControllerFactory.getUserController();
		table = userInfo.getTable();
		userID= userPool.get(table.getSelectedRow()).id;
		String[] data = userDetails.getData();
		ResultMessage rsg = userController.updateUser(new UserVO(userID,data[0],data[1],data[2],data[3],data[4],data[5]));
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("ModifySucceed!");
			this.showAll();
			new MyNotification(this,"用户修改成功！",Color.GREEN);		
		}else{
			new MyNotification(this,"用户修改失败！",Color.RED);
		}
	}

	private void deleteUser() {
		System.out.println("111");
		table = userInfo.getTable();
		userController = ControllerFactory.getUserController();
		System.out.println(userPool.size());
		UserVO vo = userPool.get(table.getSelectedRow());
		System.out.println(vo.id);
		ResultMessage rsg = userController.deleteUser(vo);
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("DeleteSucceed!");
			this.showAll();
			new MyNotification(this,"用户删除成功！",Color.GREEN);
		}else{
			new MyNotification(this,"用户删除失败！",Color.RED);
		}
	}
}

	
