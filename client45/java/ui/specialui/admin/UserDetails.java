package ui.specialui.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import businesslogic.ControllerFactory;
import businesslogic.organizationbl.OrganizationController;
import businesslogic.organizationbl.transferbl.TransferController;
import ui.Config.JComboBoxOfChina;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyFont;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.myui.MyTranslucentPanel;

/**
 * 显示用户详细信息的Panel，根据不同的场景可作为添加用户、修改用户信息、查看用户信息的Panel.
 * @author zsq
 * @version 2015/12/4 23:01
 */
public class UserDetails extends MyTranslucentPanel{

	private static final long serialVersionUID = 1L;
	
	private MyJTextField[] fields;
	private MyJTextField passwordField;
	private MyJComboBox userIdentityBox;
	private MyJComboBox branchID;
	private JComboBox<?> provincesBox;
	private JComboBox<?> citiesBox;
	private MyJComboBox userAuthorityBox;
	private MyEmptyTextArea address;
	
	
	public UserDetails() {
		super(680,100,550,562);
		this.initComponent();
	}

	private void initComponent() {
		fields = new MyJTextField[2];
		
		this.add(new MyJLabel(10, 60, 100, 30, "机构编号", 18, true));
		
		try {
			OrganizationController controller = ControllerFactory.getOrganizationController();
			TransferController transController = ControllerFactory.getTransferController();
			ArrayList<String> branchIDs = new ArrayList<String>();
			ArrayList<String> transIDs = new ArrayList<String>();
			branchIDs = controller.getAllBranchNumbers();
			transIDs = transController.getAllTransferNumbers();
			
			String[] trans = new String[2000];
			
			for(int i=0;i<branchIDs.size();i++){
				trans[i] = branchIDs.get(i);
			}
			for(int i=0;i<transIDs.size();i++){
				trans[i+branchIDs.size()] = transIDs.get(i);
			}
		
			branchID = new MyJComboBox(110,60,130,30,trans);
			this.add(branchID);
		} catch (RemoteException | MalformedURLException | NotBoundException e1) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			e1.printStackTrace();
		}
		
		this.add(new MyJLabel(250,60,90,30,"用户密码",18,true));
		passwordField = new MyJTextField(340,60,140,30);
		passwordField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==passwordField){
					fields[0].requestFocus();
				}
				
			}
			
		});
		this.add(passwordField);
		
		this.add(new MyJLabel(10,100, 90, 30, "用户姓名", 18, true));
		fields[0] = new MyJTextField(100, 100, 140, 30);
		fields[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[0]){
					fields[1].requestFocus();
				}
				
			}
			
		});
		this.add(fields[0]);
		
		this.add(new MyJLabel(250,100,100,30,"联系电话",18,true));
		fields[1] = new MyJTextField(340,100,140,30);
		fields[1].setOnlyInteger(11);
		this.add(fields[1]);
	
	
		this.add(new MyJLabel(10, 140, 90, 30, "用户类别",18,true));
		this.add(new MyJLabel(250, 140, 90, 30, "用户权限",18,true));
		this.add(new MyJLabel(10,180,90,30,"家庭地址:",18,true));
		this.add(new MyJLabel(10,250,90,30,"详细地址:",18,true));
		this.add(new MyJLabel(100,210,25,30,"省",18,true));
		this.add(new MyJLabel(300,210,25,30,"市",18,true));
		
		
		String [] identity = {"总经理","快递员","库存管理人员","中转中心业务员","营业厅业务员","财务人员","管理员"};
		userIdentityBox = new MyJComboBox(100,140,150,30,identity);
		this.add(userIdentityBox);
		
		String [] authority = {"总经理权限","普通员工权限","管理员权限","高级财务权限"};
		userAuthorityBox = new MyJComboBox(340,140,150,30,authority);
		this.add(userAuthorityBox);
		  
		//构建中国各大城市的三级联动下拉框
	    JComboBoxOfChina box = new JComboBoxOfChina();
	    provincesBox = box.getCombobox_privince();
	    provincesBox.setBounds(130,210,120,30);
	    provincesBox.setFont(new MyFont(14,true));
	    provincesBox.setVisible(true);
	    this.add(provincesBox);
	    
	    //构造市级下拉框
	    citiesBox =box.getCombobox_city();
	    citiesBox.setBounds(325,210,120,30);
	    citiesBox.setFont(new MyFont(14,true));
	    citiesBox.setVisible(true);
	    this.add(citiesBox);
	   
	    address = new MyEmptyTextArea(100,250,410,100,true);
	    address.setBackground(Color.WHITE);
	    this.add(address);   
	}
	
	/**
	 * 设置此panel不可编辑
	 */
	public void setUneditable() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setEditable(false);
		}
		passwordField.setEditable(false);
		branchID.setEnabled(false);
		userIdentityBox.setEnabled(false);;
		userAuthorityBox.setEnabled(false);
		provincesBox.setEnabled(false);
		citiesBox.setEnabled(false);
		address.setEditable(false);
		
	}
	
	/**
	 * 设置Panel各组件的值
	 * @param data 
	 */
	public void setData(String[] data) {
		branchID.setSelectedItem(data[0]);
		passwordField.setText(data[1]);
		for(int i = 0; i < 2; i++){
			fields[i].setText(data[i+2]);
		}
		userIdentityBox.setSelectedItem(data[4]);
		userAuthorityBox.setSelectedItem(data[5]);
		provincesBox.setSelectedItem(data[6]);
		citiesBox.setSelectedItem(data[7]);
		address.setText(data[8]);	
	}
	
	/**
	 * 清空所有组件
	 */
	public void refresh() {
		branchID.setSelectedItem(null);
		passwordField.setText(null);
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
		userIdentityBox.setSelectedItem(null);
		userAuthorityBox.setSelectedItem(null);
		provincesBox.setSelectedItem(null);
		citiesBox.setSelectedItem(null);
		address.setText(null);
	}

	/**
	 * 获得Panel内用户输入的各项信息
	 * @return String[] 
	 */
	public String[] getData() {
		String[] data = new String[9];
		data[0] = (String) branchID.getSelectedItem();
		data[1] = new String(passwordField.getText());
		System.out.println(data[1]);
		for (int i = 0; i < 2; i++) {			
			if((data[2+i] = fields[i].getText()).equals(null)) return null;
		}
		data[4] = (String)userIdentityBox.getSelectedItem();
		data[5] = (String)userAuthorityBox.getSelectedItem();
		data[6] = (String) provincesBox.getSelectedItem();
		data[7] = (String) citiesBox.getSelectedItem();
		data[8] = address.getText();
		for(int i = 4;i<9;i++){
			if(data[i].equals("")) return null;
		}
		return data;
	}
}
