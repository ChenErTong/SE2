package ui.specialui.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.userbl.UserController;
import state.ResultMessage;
import state.UserAuthority;
import state.UserIdentity;
import ui.image.AdminImage;
import ui.image.CommonImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.myui.MyTitle;
import vo.UserVO;

/**
 * 管理员进行用户信息管理的总Panel,负责管理所有Panel的相互跳转
 * @author zsq
 * @version 2015/12/4 23:06
 */

public class Panel_Admin_Total extends MyJPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private UserInfo userInfo;
	private UserDetails userDetails;
	private MyButton commonButton ;
	private MyButton modifyButton ;
	private MyJTable table;
	private MyButton backout;
	private MyButton redo;
	
	/**
	 * 静态变量，作为UserVO的存储池，在构造函数中初始化
	 */
	static ArrayList<UserVO> userPool;
	static String userID = " ";
	
	private UserController userController ;
	
	public Panel_Admin_Total(Frame_Admin frame_Admin)  {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		MyTitle.setTitle(this, "管理员界面", 487, 0, 306, 142);
		
		this.initComponent(frame_Admin);
		this.repaint();
		userPool = new ArrayList<UserVO>();
		this.showAll();
	}
	
	private void initComponent(Frame_Admin frame_Admin){
		userInfo = new UserInfo(this);
		this.add(userInfo);
		
		userDetails = new UserDetails();
		userDetails.setUneditable();
		this.add(userDetails);
		this.initButton(frame_Admin);
		
		this.repaint();
	}	
	
	
	/**
	 *增加用户的操作面板，装载userDetails
	 * @param frame
	 */
	private void insertPanel(Frame_Admin frame) {
		this.removeAll();
		this.add(userInfo);
		this.add(new MyJLabel(550, 30, 210, 45, "用户信息管理", 30, true));
		this.initButton(frame);
	
		userDetails = new UserDetails();
		userDetails.add(new MyJLabel(230,5,120,30,"新增用户",18,true));
		this.add(userDetails);
		
		commonButton  = new MyButton(890, 670, 120, 30,AdminImage.getBUTTON_CONFIRMADD());
		commonButton.setActionCommand("AddUser");
		commonButton.addActionListener(this);
		this.add(commonButton);
	
		
		this.repaint();
	}
	
	/**
	 * 初始化按钮，在界面添加按钮及注册监听
	 * @param frame
	 */
	private void initButton(Frame_Admin frame) {
		MyButton insertButton = new MyButton(75, 660, 120, 30,AdminImage.getBUTTON_ADDUSER());
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Admin_Total.this.insertPanel(frame);
			}
		});
		insertButton.addActionListener(this);
		this.add(insertButton);

		MyButton modifyButton = new MyButton(205, 660,  120, 30,AdminImage.getBUTTON_MODIFY());
		modifyButton.setActionCommand("ModifyUserInfo");
		modifyButton.addActionListener(this);
		this.add(modifyButton);

		MyButton searchButton = new MyButton(335, 660,  120, 30,AdminImage.getBUTTON_VIEWUSER());
		searchButton.setActionCommand("ViewUserInfo");
		searchButton.addActionListener(this);
		this.add(searchButton);

		MyButton deleteButton = new MyButton(465,  660,  120, 30,AdminImage.getBUTTON_DELETEUSER());
		deleteButton.setActionCommand("DeleteUser");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		backout = new MyButton(1150,665,35,35,CommonImage.getBUTTON_BACKOUT());
		backout.setActionCommand("backout");
		backout.addActionListener(this);
		this.add(backout);
		
		redo = new MyButton(1190,665,35,35,CommonImage.getBUTTON_REDO());
		redo.setActionCommand("redo");
		redo.addActionListener(this);
		this.add(redo);
		
		this.repaint();
	}
	
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
			
		try {
			userController = ControllerFactory.getUserController();
			ArrayList<UserVO> userVO= userController.show();
			if(userVO==null){
				new MyNotification(this,"系统中无人员信息！",Color.RED);
				return;
			}
			for(int i = 0; i < userVO.size(); i++){
			
				Object[] rowData = {userVO.get(i).id,userVO.get(i).userName,userVO.get(i).password,
						userVO.get(i).iden.value,userVO.get(i).authority.value
							,userVO.get(i).phoneNumber,userVO.get(i).address};
				tableModel.addRow(rowData);
				userPool.add(userVO.get(i));
				}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
		} 

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("AddUser")){
			String[] data = userDetails.getData();
			if(userDetails.getData()==null){
				new MyNotification(this,"请检查用户信息填写是否完整！",Color.RED);
			}else if(!this.limitIdentity(data[4], data[5])){
				new MyNotification(this,"用户身份和用户权限不匹配！",Color.RED);
			}else{
				try {
					userController = ControllerFactory.getUserController();
					ResultMessage rsg = userController.addUser((new UserVO(userController.getID(data[0],this.decideIden(data[4])),data[1],data[2],data[3],this.identity(data[4]),this.authority(data[5]),data[6]+data[7]+data[8])));
					if(rsg.equals(ResultMessage.SUCCESS)){
						this.showAll();
						userDetails.refresh();
						new MyNotification(this,"用户信息添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"用户信息添加失败！",Color.RED);
					}
				} catch (MalformedURLException e1) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
					return;
				} catch (RemoteException e1) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
					return;
				} catch (NotBoundException e1) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
					return;
				}
			}
		}else if(e.getActionCommand().equals("ModifyUserInfo")){
			this.remove(userDetails);
			if(commonButton!=null){
				this.remove(commonButton);
			}
			userDetails = new UserDetails();
			userDetails.add(new MyJLabel(230,5,120,30,"修改用户信息",18,true));
			this.repaint();
			this.add(userDetails);
			
			modifyButton = new MyButton(890, 670, 120, 30,AdminImage.getBUTTON_CONFIRMMODIFY());
			modifyButton.setActionCommand("CheckModify");
			modifyButton.addActionListener(this);
			this.add(modifyButton);
			
			table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的用户！",Color.RED);
			}else{
				String[] data = new String[9];
				this.setUserDetails(data);
				userDetails.setData(data);
				userDetails.setEnabled(true);
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
			this.remove(userDetails);
			if(commonButton!=null){
				this.remove(commonButton);
			}
			if(modifyButton!=null){
				this.remove(modifyButton);
			}
	
			userDetails = new UserDetails();
			userDetails.add(new MyJLabel(230,5,120,30,"查看用户信息",18,true));
			this.add(userDetails);
			this.repaint();
		
			table = userInfo.getTable();
			if(table.getSelectedColumnCount()==0){
				new MyNotification(this,"请先选择要查看的用户！",Color.RED);
			}else{
				String [] data = new String[9];
						this.setUserDetails(data);
				userDetails.setData(data);
				userDetails.setUneditable();
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
			
			UserController userController;
			try {
				userController = ControllerFactory.getUserController();
				ArrayList<UserVO> userVO;
				String data = userInfo.getData()+"";
				if(data!=""){
					switch(Integer.parseInt(data)){
						case 1 : userVO = userController.showUser(UserIdentity.GENERAL_MANAGER);break;
						case 2 : userVO = userController.showUser(UserIdentity.COURIER);break;
						case 3 : userVO = userController.showUser(UserIdentity.INVENTORY_MANAGER);break;
						case 4 : userVO = userController.showUser(UserIdentity.TRANSFER_CONTERMAN);break;
						case 5 : userVO = userController.showUser(UserIdentity.BRANCH_COUNTERMAN); break;
						case 6 : userVO = userController.showUser(UserIdentity.FINANCE_MANAGER);break;
						case 7 : userVO =userController.showUser(UserIdentity.ADMIN);break;
						default : userVO = userController.show();break;
					}
					for(int i = 0; i < userVO.size(); i++){
						Object[] rowData = {userVO.get(i).id,userVO.get(i).userName,userVO.get(i).password,
							userVO.get(i).iden.value,userVO.get(i).authority.value,userVO.get(i).phoneNumber,userVO.get(i).address};
						tableModel.addRow(rowData);
						userPool.add(userVO.get(i));
						System.out.println("SearchSucceed!");
					}
					this.repaint();
					new MyNotification(this,"共有"+table.getRowCount()+"个员工满足条件！",Color.GREEN);
				}else{
					new MyNotification(this,"请选择查询类型！",Color.RED);
				}
			}catch (MalformedURLException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
				return;
			} catch (RemoteException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
				return;
			} catch (NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
				return;
			}
		}else if(e.getActionCommand().equals("backout")){
			try {
				UserController controller = ControllerFactory.getUserController();
				ResultMessage rsg = controller.undo();
				if(rsg.equals(ResultMessage.SUCCESS)){
					new MyNotification(this,"操作撤销成功！",Color.GREEN);
					this.showAll();
				}else{
					new MyNotification(this,"操作撤销失败！",Color.RED);
				}
			} catch (MalformedURLException | RemoteException
					| NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
				return;
			}
		}else if(e.getActionCommand().equals("redo")){
			try {
				UserController controller = ControllerFactory.getUserController();
				ResultMessage rsg = controller.redo();
				if(rsg.equals(ResultMessage.SUCCESS)){
					new MyNotification(this,"操作恢复成功！",Color.GREEN);
					this.showAll();
				}else{
					new MyNotification(this,"操作恢复失败！",Color.RED);
				}
			} catch (MalformedURLException | RemoteException
					| NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
				return;
			}
		}
		this.repaint();
	}
	
	
	private void modifyUser() {
		try {
			userController = ControllerFactory.getUserController();
			table = userInfo.getTable();
			userID= userPool.get(table.getSelectedRow()).id;
			String[] data = userDetails.getData();
			if(userDetails.getData()==null){
				new MyNotification(this,"请检查用户信息填写是否完整！",Color.RED);
			}else if(!this.limitIdentity(data[4], data[5])){
				new MyNotification(this,"用户身份和用户权限不匹配！",Color.RED);
			}
			else{
				ResultMessage rsg = userController.updateUser((new UserVO(userID,data[1],data[2],data[3],this.identity(data[4]),this.authority(data[5]),data[6]+data[7]+data[8])));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					userDetails.refresh();
					new MyNotification(this,"用户信息修改成功！",Color.GREEN);
				}else{
					new MyNotification(this,"用户信息修改失败！",Color.RED);
				}
			}
		} catch (MalformedURLException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
		} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
		} catch (NotBoundException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
		}
		this.repaint();
	}
	
	/**
	 * 判断修改/添加的人员身份
	 * @param num
	 * @return UserIdentity
	 */
	private UserIdentity identity(String num){
		if(num.equals("总经理")){
			return UserIdentity.GENERAL_MANAGER;
		}else if(num.equals("快递员")){
			return UserIdentity.COURIER;
		}else if(num.equals("管理员")){
			return UserIdentity.ADMIN;
		}else if(num.equals("营业厅业务员")){
			return UserIdentity.BRANCH_COUNTERMAN;
		}else if(num.equals("财务人员")){
			return UserIdentity.FINANCE_MANAGER;
		}else if(num.equals("库存管理员")){
			return UserIdentity.INVENTORY_MANAGER;
		}else if(num.equals("中转业务员")){
			return UserIdentity.TRANSFER_CONTERMAN;
		}
		return null;
	}
	
	private UserAuthority authority(String authority){
		if(authority.equals(UserAuthority.ADVANCE_FINANCE.value)){
			return UserAuthority.ADVANCE_FINANCE;
		}else if(authority.equals(UserAuthority.COMMONLEVEL.value)){
			return UserAuthority.COMMONLEVEL;
		}else if(authority.equals(UserAuthority.HIGHESTLEVEL.value)){
			return UserAuthority.HIGHESTLEVEL;
		}else if(authority.equals(UserAuthority.MANAGER_LEVEL.value)){
			return UserAuthority.MANAGER_LEVEL;
		}
		return null;
	}
	
	private void deleteUser() {
		try {
			table = userInfo.getTable();
			userController = ControllerFactory.getUserController();
			UserVO vo = userPool.get(table.getSelectedRow());
			ResultMessage rsg = userController.deleteUser(vo);
			if(rsg.equals(ResultMessage.SUCCESS)){
				System.out.println("DeleteSucceed!");
				this.showAll();
				new MyNotification(this,"用户删除成功！",Color.GREEN);
				this.repaint();
			}else{
				new MyNotification(this,"用户删除失败！",Color.RED);
			}
		} catch (MalformedURLException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
		} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
		} catch (NotBoundException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
		}
	}
	
	/**
	 * 设置用户详细信息面板,在查看用户信息和修改用户信息时调用
	 */
	private void  setUserDetails(String[] data){
		userID = userPool.get(table.getSelectedRow()).id;
		
		data[0] = userPool.get(table.getSelectedRow()).id;
		data[1] = userPool.get(table.getSelectedRow()).password;
		data[2] = userPool.get(table.getSelectedRow()).userName;
		data[3] = userPool.get(table.getSelectedRow()).phoneNumber;
		data[4] = userPool.get(table.getSelectedRow()).iden.value;
		data[5] = userPool.get(table.getSelectedRow()).authority.value;
		data[6] = userPool.get(table.getSelectedRow()).address.substring(0,3);
		data[7] = userPool.get(table.getSelectedRow()).address.substring(3,6);
		data[8] = userPool.get(table.getSelectedRow()).address.substring(6);
	
	}
	/**
	 * 身份和权限是否匹配
	 * @param iden
	 * @param authority
	 * @return 是否匹配
	 */
	private boolean limitIdentity(String iden,String authority){
		if(iden.equals("总经理")&&(!(authority.equals("总经理权限")))){
			return false;
		}else if(iden.equals("管理员")&&(!(authority.equals("管理员权限")))){
			return false;
		}else if(!(iden.equals("总经理"))&&(authority.equals("总经理权限"))){
			return false;
		}else if(!(iden.equals("管理员"))&&((authority.equals("管理员权限")))){
			return false;
		}else if(!(iden.equals("财务人员"))&&(authority.equals("高级财务权限"))){
			return false;
		}
		return true;
	}
	
	/**
	 * 添加员工 {"总经理","快递员","库存管理员","中转业务员","营业厅业务员","财务人员","管理员"};
	 */
	
	private UserIdentity decideIden(String data){
		switch (data){
		case "快递员":return UserIdentity.COURIER;
		case "财务人员":return UserIdentity.FINANCE_MANAGER;
		case "中转业务员":return UserIdentity.TRANSFER_CONTERMAN;
		case "库存管理员":return UserIdentity.INVENTORY_MANAGER;
		case "营业厅业务员":return UserIdentity.BRANCH_COUNTERMAN;
		case "管理员":return UserIdentity.ADMIN;
		case "总经理":return UserIdentity.GENERAL_MANAGER;
		default:
			break;
		}
		return null;
	}
}