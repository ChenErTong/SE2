package ui.specialui.admin;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.JLabel;




import ui.Config.JComboBoxOfChina;
import ui.image.CommonImage;
import ui.myui.MyComboBox;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;


public class Panel_Admin_AddUser extends MyTranslucentPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private MyJTextField userId;
	private MyJTextField passwordField;
	private MyJTextField userNameField;
	private MyJTextField phoneField;
	private MyComboBox userIdentityBox;
	private JComboBox provincesBox;
	private JComboBox citiesBox;
	//private JComboBox districtsBox;

	
	private MyComboBox userAuthorityBox;
	private MyEmptyTextArea addressDetails;
	public Panel_Admin_AddUser(Frame_Admin frame_Admin) {
		// TODO Auto-generated constructor stub
		super(365, 100, 550, 700);
		this.setOpaque(false);
		this.initComponent(frame_Admin);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	private void initComponent(Frame_Admin frame_Admin){
		MyJLabel title = new MyJLabel(225, 5, 170, 50, "新增用户信息", 24, true);
		this.add(title);
		
		MyJLabel userID = new MyJLabel(10, 60, 100, 30, "新用户编号", 18, true);
		this.add(userID);
		
		MyJLabel password = new MyJLabel(660,92,90,30,"用户密码",18,true);
		this.add(password);
		
		MyJLabel userName = new MyJLabel(400,180, 90, 30, "用户姓名", 18, true);
		this.add(userName);
		
		MyJLabel phone= new MyJLabel(660,180,90,30,"联系电话",18,true);
		this.add(phone);
		
		
		MyJLabel userIdentity = new MyJLabel(400, 270, 90, 30, "员工类别",18,true);
		this.add(userIdentity);
		
		MyJLabel userAuthority = new MyJLabel(660, 270, 90, 30, "员工权限",18,true);
		this.add(userAuthority);
		
		MyJLabel address = new MyJLabel(400,360,90,30,"家庭地址:",18,true);
		this.add(address);
		
		MyJLabel addrDetails = new MyJLabel(400,460,90,30,"详细地址:",18,true);
		this.add(addrDetails);
		
		MyJLabel province = new MyJLabel(490,400,25,30,"省",18,true);
		this.add(province);
		
		MyJLabel city = new MyJLabel(660,400,25,30,"市",18,true);
		this.add(city);
		
		//MyJLabel district = new MyJLabel(660,400,25,30,"区",18,true);
		//this.add(district);
		
		userId = new MyJTextField(500,92,140,30);
		this.add(userId);

		passwordField = new MyJTextField(750,92,140,30);
		this.add(passwordField);
		
		userNameField = new MyJTextField(500, 180, 140, 30);
		this.add(userNameField);
		

		

		phoneField = new MyJTextField(750,180,140,30);
		phoneField.setOnlyInteger(11);

		this.add(phoneField);
		
		String [] identity = {"请选择用户类型","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
		userIdentityBox = new MyComboBox(500,270,150,30,18,identity);
		this.add(userIdentityBox);
		
		String [] authority = {"请选择权限类型","管理员权限","总经理权限","普通员工权限"};
		userAuthorityBox = new MyComboBox(750,270,150,30,18,authority);
		this.add(userAuthorityBox);
		  
		//构建中国各大城市的三级联动下拉框
	    JComboBoxOfChina box = new JComboBoxOfChina();
	    
	 
	    provincesBox = box.getCombobox_privince();
	    provincesBox.setBounds(520,400,120,30);
	    provincesBox.setFont(new MyFont(14,true));
	    provincesBox.setVisible(true);
	    this.add(provincesBox);
	    
	    //构造市级下拉框
	    citiesBox =box.getCombobox_city();
	    citiesBox.setBounds(690,400,120,30);
	    citiesBox.setFont(new MyFont(14,true));
	    citiesBox.setVisible(true);
	    this.add(citiesBox);
	    
	    //构建区级下拉框
	    //JComboBox combobox_area = box.getCombobox_area();
	    //districtsBox = box.getCombobox_area();
	    //combobox_area.setBounds(100, 150, 150, 30);
	    //this.add(combobox_area);
	    
	   this.setVisible(true);
	
	   MyJButton add = new MyJButton(500,600,100,30,"确认添加",18);
	   add.setActionCommand("AddUser");
	   add.addActionListener(frame_Admin);
	   this.add(add);
	   
		MyJButton cancel = new MyJButton(720,600,100,30,"取消添加",18);
		cancel.setActionCommand("cancelAddUser");
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userId.setText(null);
				passwordField.setText(null);
				userNameField.setText(null);
				phoneField.setText(null);
				addressDetails.setText(null);
			}
			
		});
		this.add(cancel);
		cancel.setVisible(true);
	}

	public String[] getUserInfo(){
		String[] info = new String[9];
		info[0] = userId.getText();
		info[1] = passwordField.getText();
		info[2] = userNameField.getText();
		info[3] = phoneField.getText();
		info[4] = (String)userIdentityBox.getSelectedItem();
		info[5] = (String)userAuthorityBox.getSelectedItem();
		info[6] = (String)provincesBox.getSelectedItem();
		info[7] = (String)citiesBox.getSelectedItem();
	//	info[8] = (String)districtsBox.getSelectedItem();
		info[8] = addressDetails.getText();
		for (String string : info) {
			if(string.equals("")){
				return null;
			}
		}
		return info;
		
	}
	
	/**
	 * 添加用户
	 * @return  
	 */
	public int addUser() {
		String[] userInfo;
		if(( userInfo= this.getUserInfo()) == null){
			return 1;
		}

		return 0;
	}
}
