package ui.specialui.manager.AccountManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.ControllerFactory;
import businesslogic.organizationbl.OrganizationController;
import businesslogic.userbl.UserController;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.myui.MyTranslucentPanel;

public class ModifyAccount extends MyTranslucentPanel{
	private MyJTextField[] fields ;
	private MyJComboBox branchID;
	private MyJComboBox userID;
	
	public ModifyAccount() {
		super(680, 390-30,550,240);
		this.initComponent();
	}
	private void initComponent() {
		this.add(new MyJLabel(240,10,150,30,"修改员工信息",18,true));
		this.add(new MyJLabel(40,50,90,30,"员工姓名",16,true));
		this.add(new MyJLabel(290,50,90,30,"员工职务",16,true));
		this.add(new MyJLabel(40,90,90,30,"出生日期",16,true));
		this.add(new MyJLabel(290,90,90,30,"身份证号",16,true));
		this.add(new MyJLabel(40,130,90,30,"薪水",16,true));
		this.add(new MyJLabel(290,130,90,30,"联系方式",16,true));
		this.add(new MyJLabel(40,170,90,30,"任职时间",16,true));
		this.add(new MyJLabel(290,170,100,30,"营业厅编号",16,true));
		this.add(new MyJLabel(40,210,120,30,"对应用户编号",16,true));
		
		fields = new MyJTextField[7];
		fields[0] = new MyJTextField(130,50,120,30);
		fields[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[0]){
					fields[1].requestFocus();
				}
				
			}
			
		});
		this.add(fields[0]);
		
		fields[1] = new MyJTextField(380,50,120,30);
		fields[1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[1]){
					fields[2].requestFocus();
				}
				
			}
			
		});
		this.add(fields[1]);
		
		fields[2] = new MyJTextField(130,90,120,30);
		fields[2].setOnlyInteger(19);
		fields[2].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[2]){
					fields[3].requestFocus();
				}
				
			}
			
		});
		this.add(fields[2]);
		
		fields[3] = new MyJTextField(380,90,120,30);
		fields[3].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[3]){
					fields[4].requestFocus();
				}
				
			}
			
		});
		this.add(fields[3]);
		
		fields[4] = new MyJTextField(130,130,120,30);
		fields[4].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[4]){
					fields[5].requestFocus();
				}
				
			}
			
		});
		this.add(fields[4]);
		
		fields[5] = new MyJTextField(380,130,120,30);
		fields[5].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[5]){
					fields[6].requestFocus();
				}
				
			}
			
		});
		this.add(fields[5]);
		
		fields[6] = new MyJTextField(130,170,120,30);
		this.add(fields[6]);
		String[] branchIDs = new String[100];
		try {
			OrganizationController controller = ControllerFactory.getOrganizationController();
			ArrayList<String> id = controller.getAllBranchNumbers();
		
			for(int i=0;i<id.size();i++){
				branchIDs[i] = id.get(i);
			}
			branchID = new MyJComboBox(390,170,110,30,branchIDs);
			this.add(branchID);
		} catch (RemoteException | MalformedURLException | NotBoundException e1) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			e1.printStackTrace();
		}
		try {
			UserController controller = ControllerFactory.getUserController();
		
			ArrayList<String> userid = controller.getUserIDCanBeUsedByAccounts();
			int size = userid.size();
			String[] userIDs = new String[size];
			for(int i=0;i<size;i++){
				userIDs[i] = userid.get(i);
			}
			userID = new MyJComboBox(160,210,110,30,userIDs);
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
		}
		this.add(userID);
		
		
		
		
	}

	public void setUneditable() {
		for(MyJTextField field: fields){
			field.setEditable(false);
		}
		branchID.setEditable(false);
		userID.setEditable(false);
	}
	
	public String[] getData(){
		String [] data = new String[9];
		for(int i=0;i<7;i++){
			data[i] = fields[i].getText();
			if(data[i]==null){
				return null;
			}
		}
		data[7]=(String) branchID.getSelectedItem();
		if(data[7]==null){
			return null;
		}
		data[8] = (String)userID.getSelectedItem();
		if(data[8]==null){
			return null;
		}
		return data;
	}
	
	public void setData(String [] data){
		for(int i=0;i<7;i++){
			fields[i].setText(data[i]);
		}
		branchID.setSelectedItem(data[7]);
		userID.setSelectedItem(data[8]);
	}
	
	public void refresh(){
		branchID.setSelectedItem(null);
		for(int i=0;i<7;i++){
			fields[i].setText(null);
		}
		userID.setSelectedItem(null);
	}
	private static final long serialVersionUID = 1L;
}
