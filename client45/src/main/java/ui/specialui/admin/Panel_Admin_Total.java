package ui.specialui.admin;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.userbl.UserController;
import state.ResultMessage;
import state.UserIdentity;
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
		userDetails.add(new MyJLabel(230,5,120,30,"查看用户信息",18,true));
		userDetails.setUneditable();
		this.add(userDetails);
		
		this.repaint();
	}

/*	private void deletePanel(Frame_Admin frame) {
		
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
		this.add(userInfo);
		this.initButton(frame);
		
		userDetails = new UserDetails();
		userDetails.setUneditable();
		userDetails.add(new MyJLabel(230,5,120,30,"删除用户",18,true));
		this.add(userDetails);
		this.repaint();
	}*/

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
		deleteButton.setActionCommand("DeleteUser");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
	}
	
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
				Object[] rowData = {userVO.get(i).id,userVO.get(i).userName,userVO.get(i).password,userVO.get(i).iden,userVO.get(i).authority
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
				new MyNotification(this,"请检查用户信息填写是否完整！",Color.RED);
			}else{//String id, String password, String userName, String phoneNumber, String iden, String authority,
				//String address{"总经理","快递员","库存管理员","中转业务员","营业厅业务员","财务人员","管理员"};
				if(data[4].equals("总经理")){
					ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.GENERAL_MANAGER,data[5],data[6]+data[7]+data[8]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						System.out.println("AddSucceed!");
						this.showAll();
						userDetails.refresh();
						new MyNotification(this,"用户添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"用户添加失败！",Color.RED);
					}
				}else if(data[4].equals("快递员")){
					ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.COURIER,data[5],data[6]+data[7]+data[8]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						System.out.println("AddSucceed!");
						this.showAll();
						userDetails.refresh();
						new MyNotification(this,"用户添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"用户添加失败！",Color.RED);
					}
				}else if(data[4].equals("库存管理员")){
					ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.INVENTORY_MANAGER,data[5],data[6]+data[7]+data[8]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						System.out.println("AddSucceed!");
						this.showAll();
						userDetails.refresh();
						new MyNotification(this,"用户添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"用户添加失败！",Color.RED);
					}
				}else if(data[4].equals("中转业务员")){
					ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.TRANSFER_CONTERMAN,data[5],data[6]+data[7]+data[8]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						System.out.println("AddSucceed!");
						this.showAll();
						userDetails.refresh();
						new MyNotification(this,"用户添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"用户添加失败！",Color.RED);
					}
				}else if(data[4].equals("营业厅业务员")){
					ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.TRANSFER_CONTERMAN,data[5],data[6]+data[7]+data[8]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						System.out.println("AddSucceed!");
						this.showAll();
						userDetails.refresh();
						new MyNotification(this,"用户添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"用户添加失败！",Color.RED);
					}
				}else if(data[4].equals("财务人员")){
					ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.FINANCE_MANAGER,data[5],data[6]+data[7]+data[8]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						System.out.println("AddSucceed!");
						this.showAll();
						userDetails.refresh();
						new MyNotification(this,"用户添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"用户添加失败！",Color.RED);
					}
				}else if(data[4].equals("管理员")){
					ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.ADMIN,data[5],data[6]+data[7]+data[8]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						System.out.println("AddSucceed!");
						this.showAll();
						userDetails.refresh();
						new MyNotification(this,"用户添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"用户添加失败！",Color.RED);
					}
				}	
			}
		}else if(e.getActionCommand().equals("ModifyUserInfo")){
				table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的用户！",Color.RED);
			}else{
				userID = userPool.get(table.getSelectedRow()).id;
				String[] data = new String[9];
				data[0] = userID;
				data[1] = userPool.get(table.getSelectedRow()).password;
				data[2] = userPool.get(table.getSelectedRow()).userName;
				data[3] = userPool.get(table.getSelectedRow()).phoneNumber;
				data[4] = userPool.get(table.getSelectedRow()).iden+"";
				data[5] = userPool.get(table.getSelectedRow()).authority;
				data[6] = userPool.get(table.getSelectedRow()).address.substring(0,3);
				data[7] = userPool.get(table.getSelectedRow()).address.substring(3,6);
				data[8] = userPool.get(table.getSelectedRow()).address.substring(6);
				
				userDetails = new UserDetails();
				userDetails.add(new MyJLabel(230,5,120,30,"查看用户信息",18,true));
				userDetails.setData(data);
				//userDetails.setUneditable();
				this.add(userDetails);
				userDetails.setData(data);
			}
		}else if(e.getActionCommand().equals("DeleteUser")){
			table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要删除的用户！",Color.RED);
			}else{
				new MyNotification(this,"正在删除用户！",Color.GREEN);
				this.deleteUser();
			
			}
		}else if(e.getActionCommand().equals("ViewUserInfo")){
			table = userInfo.getTable();
			if(table.getSelectedColumnCount()==0){
				new MyNotification(this,"请先选择要查看的用户！",Color.RED);
			}else{
				userID = userPool.get(table.getSelectedRow()).id;
				String[] data = new String[9];
				data[0] = userID;
				data[1] = userPool.get(table.getSelectedRow()).password;
				data[2] = userPool.get(table.getSelectedRow()).userName;
				data[3] = userPool.get(table.getSelectedRow()).phoneNumber;
				data[4] = userPool.get(table.getSelectedRow()).iden+"";
				data[5] = userPool.get(table.getSelectedRow()).authority;
				data[6] = userPool.get(table.getSelectedRow()).address.substring(0,3);
				data[7] = userPool.get(table.getSelectedRow()).address.substring(3,6);
				data[8] = userPool.get(table.getSelectedRow()).address.substring(6);
				userDetails.setData(data);
			}
		}else if(e.getActionCommand().equals("CheckModify")){
			table = userInfo.getTable();
			userID= userPool.get(table.getSelectedRow()).id;
				if(userDetails.getData()==null){
					new MyNotification(this,"请检查用户信息填写是否完整！",Color.RED);
				}else{
					new MyNotification(this,"正在修改用户信息！",Color.GREEN);
					this.modifyUser();
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
			//--TODO 缺少接口
			UserController userController = ControllerFactory.getUserController();
			ArrayList<UserVO> userVO;
			String data = userInfo.getData()+"";
			if(data!=""){
				switch(Integer.parseInt(data)){
					//case 1 : userVO = userController.
					//case 2 : userVO =
					//case 3 : userVO = 
					//case 4 : userVO =
					//case 5 : userVO = 
					//case 6 : userVO = 
					//case 7 : userVO =
					//default : userVO = 
					
				}
			
				//for(int i = 0; i < userVO.size(); i++){
			//	String[] rowData = {userVO.get(i)。,userVO.get(i).userName,userVO.get(i).password,
				//		userVO.get(i).iden,userVO.get(i).authority,userVO.get(i).phoneNumber,userVO.get(i).address};
				//	String[] rowData = {userVO.get(i).ID,use}
				//tableModel.addRow(rowData);
				//userPool.add(userVO.get(i));
				System.out.println("SearchSucceed!");
				new MyNotification(this,"共有"+table.getRowCount()+"个员工满足条件！",Color.GREEN);
				}
			}else{
					new MyNotification(this,"请选择查询类型！",Color.RED);
			}
		}
	

	private void modifyUser() {
		userController = ControllerFactory.getUserController();
		table = userInfo.getTable();
		userID= userPool.get(table.getSelectedRow()).id;
		String[] data = userDetails.getData();
		if(userDetails.getData()==null){
			new MyNotification(this,"请检查用户信息填写是否完整！",Color.RED);
		}else{//String id, String password, String userName, String phoneNumber, String iden, String authority,
			//String address{"总经理","快递员","库存管理员","中转业务员","营业厅业务员","财务人员","管理员"};
			if(data[4].equals("总经理")){
				ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.GENERAL_MANAGER,data[5],data[6]+data[7]+data[8]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					userDetails.refresh();
					new MyNotification(this,"用户信息修改成功！",Color.GREEN);
				}else{
					new MyNotification(this,"用户信息修改失败！",Color.RED);
				}
			}else if(data[4].equals("快递员")){
				ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.COURIER,data[5],data[6]+data[7]+data[8]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					userDetails.refresh();
					new MyNotification(this,"用户信息修改成功！",Color.GREEN);
				}else{
					new MyNotification(this,"用户信息修改失败！",Color.RED);
				}
			}else if(data[4].equals("库存管理员")){
				ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.INVENTORY_MANAGER,data[5],data[6]+data[7]+data[8]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					userDetails.refresh();
					new MyNotification(this,"用户信息修改成功！",Color.GREEN);
				}else{
					new MyNotification(this,"用户信息修改失败！",Color.RED);
				}
			}else if(data[4].equals("中转业务员")){
				ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.TRANSFER_CONTERMAN,data[5],data[6]+data[7]+data[8]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					userDetails.refresh();
					new MyNotification(this,"用户信息修改成功！",Color.GREEN);
				}else{
					new MyNotification(this,"用户信息修改失败！",Color.RED);
				}
			}else if(data[4].equals("营业厅业务员")){
				ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.TRANSFER_CONTERMAN,data[5],data[6]+data[7]+data[8]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					userDetails.refresh();
					new MyNotification(this,"用户信息修改成功！",Color.GREEN);
				}else{
					new MyNotification(this,"用户信息修改失败！",Color.RED);
				}
			}else if(data[4].equals("财务人员")){
				ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.FINANCE_MANAGER,data[5],data[6]+data[7]+data[8]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					userDetails.refresh();
					new MyNotification(this,"用户信息修改成功！",Color.GREEN);
				}else{
					new MyNotification(this,"用户信息修改失败！",Color.RED);
				}
			}else if(data[4].equals("管理员")){
				ResultMessage rsg = userController.addUser(new UserVO(userController.getID(),data[1],data[2],data[3],UserIdentity.ADMIN,data[5],data[6]+data[7]+data[8]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					userDetails.refresh();
					new MyNotification(this,"用户信息修改成功！",Color.GREEN);
				}else{
					new MyNotification(this,"用户信息修改失败！",Color.RED);
				}
			}	
		}
	}

	private void deleteUser() {
		table = userInfo.getTable();
		userController = ControllerFactory.getUserController();
		UserVO vo = userPool.get(table.getSelectedRow());
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

	
