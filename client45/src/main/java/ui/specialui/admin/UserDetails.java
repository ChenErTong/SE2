package ui.specialui.admin;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComboBox;

import businesslogic.ControllerFactory;
import businesslogic.organizationbl.OrganizationController;
import ui.Config.JComboBoxOfChina;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyFont;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class UserDetails extends MyTranslucentPanel{

	private static final long serialVersionUID = 1L;
	
	private MyJTextField[] fields;
	private MyJComboBox userIdentityBox;
	private MyJComboBox branchID;
	@SuppressWarnings("rawtypes")
	private JComboBox provincesBox;
	@SuppressWarnings("rawtypes")
	private JComboBox citiesBox;
	private MyJComboBox userAuthorityBox;
	private MyEmptyTextArea address;
	private OrganizationController controller = ControllerFactory.getOrganizationController();
	public UserDetails() {
		super(680,100,550,562);
		this.initComponent();
	}



	private void initComponent() {
		fields = new MyJTextField[3];
		this.add(new MyJLabel(10, 60, 100, 30, "营业厅编号", 18, true));
		ArrayList<String> branchIDs = new ArrayList<String>();
		branchIDs = controller.getAllBranchNumbers();
		String[] trans = new String[100];
		for(int i=0;i<branchIDs.size();i++){
			trans[i] = branchIDs.get(i);
		}
		branchID = new MyJComboBox(110,60,130,30,trans);
		this.add(branchID);
		
		this.add(new MyJLabel(250,60,90,30,"用户密码",18,true));
		fields[0] = new MyJTextField(340,60,140,30);
		this.add(fields[0]);
		
		this.add(new MyJLabel(10,100, 90, 30, "用户姓名", 18, true));
		fields[1] = new MyJTextField(100, 100, 140, 30);
		this.add(fields[1]);
		
		this.add(new MyJLabel(250,100,100,30,"联系电话",18,true));
		fields[2] = new MyJTextField(340,100,140,30);
		fields[2].setOnlyInteger(11);
		this.add(fields[2]);
	
		this.add(new MyJLabel(10, 140, 90, 30, "用户类别",18,true));
		this.add(new MyJLabel(250, 140, 90, 30, "用户权限",18,true));
		this.add(new MyJLabel(10,180,90,30,"家庭地址:",18,true));
		this.add(new MyJLabel(10,250,90,30,"详细地址:",18,true));
		this.add(new MyJLabel(100,210,25,30,"省",18,true));
		this.add(new MyJLabel(300,210,25,30,"市",18,true));
		
		
		String [] identity = {"总经理","快递员","库存管理员","中转业务员","营业厅业务员","财务人员","管理员"};
		userIdentityBox = new MyJComboBox(100,140,150,30,identity);
		this.add(userIdentityBox);
		
		String [] authority = {"管理员权限","总经理权限","普通员工权限","高级财务权限"};
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
	   
	    address = new MyEmptyTextArea(100,250,410,100);
	    address.setBackground(Color.WHITE);
	    this.add(address);
	

	    
	}



	public void setUneditable() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setEditable(false);
		}
		branchID.setEditable(false);
		userIdentityBox.setEditable(false);
		userAuthorityBox.setEditable(false);
		provincesBox.setEditable(false);
		citiesBox.setEditable(false);
		address.setEditable(false);
		
	}

	public void setData(String[] data) {
		branchID.setSelectedItem(data[0]);
		for(int i = 0; i < 3; i++){
			fields[i].setText(data[i+1]);
		}
		userIdentityBox.setSelectedItem(data[4]);
		userAuthorityBox.setSelectedItem(data[5]);
		provincesBox.setSelectedItem(data[6]);
		citiesBox.setSelectedItem(data[7]);
		address.setText(data[8]);	
	}

	public void refresh() {
		branchID.setSelectedItem(null);
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
		userIdentityBox.setSelectedItem(null);
		userAuthorityBox.setSelectedItem(null);
		provincesBox.setSelectedItem(null);
		citiesBox.setSelectedItem(null);
		address.setText(null);
		
	}

	public String[] getData() {
		String[] data = new String[9];
		data[0] = (String) branchID.getSelectedItem();
		for (int i = 0; i < 3; i++) {			
			if((data[i+1] = fields[i].getText()).equals("")) return null;
		}
		data[4] = (String)userIdentityBox.getSelectedItem();
		data[5] = (String)userAuthorityBox.getSelectedItem();
		data[6] = (String) provincesBox.getSelectedItem();
		data[7] = (String) citiesBox.getSelectedItem();
		data[8] = address.getText();
		for(int i = 4;i<8;i++){
			if(data[i].equals("")) return null;
		}
		return data;
	}

}
