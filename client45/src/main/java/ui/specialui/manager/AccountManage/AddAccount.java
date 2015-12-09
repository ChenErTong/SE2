package ui.specialui.manager.AccountManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import businesslogic.ControllerFactory;
import businesslogic.organizationbl.OrganizationController;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class AddAccount extends MyTranslucentPanel{
	private MyJTextField[] fields ;
	private MyJComboBox branchID;
	private OrganizationController controller = ControllerFactory.getOrganizationController();

	public AddAccount() {
		super(680,70,550,240);
		this.initComponent();
	}
	private void initComponent() {
		this.add(new MyJLabel(240,10,150,30,"添加员工",18,true));
		this.add(new MyJLabel(40,50,90,30,"员工姓名",16,true));
		this.add(new MyJLabel(290,50,90,30,"员工职务",16,true));
		this.add(new MyJLabel(40,90,90,30,"出生日期",16,true));
		this.add(new MyJLabel(290,90,90,30,"身份证号",16,true));
		this.add(new MyJLabel(40,130,90,30,"薪水",16,true));
		this.add(new MyJLabel(290,130,90,30,"联系方式",16,true));
		this.add(new MyJLabel(40,170,90,30,"任职时间",16,true));
		this.add(new MyJLabel(290,170,100,30,"营业厅编号",16,true));
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
		
		ArrayList<String> id = controller.getAllBranchNumbers();
		String[] branchIDs = new String[100];
		for(int i=0;i<id.size();i++){
			branchIDs[i] = id.get(i);
		}
		branchID = new MyJComboBox(390,170,110,30,branchIDs);
		this.add(branchID);
	}

	public void setUneditable() {
		for(MyJTextField field: fields){
			field.setEditable(false);
		}
		branchID.setEditable(false);
	}
	
	public String[] getData(){
		String [] data = new String[8];
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
		return data;
	}
	
	public void setData(String [] data){
		for(int i=0;i<7;i++){
			fields[i].setText(data[i]);
		}
		branchID.setSelectedItem(data[7]);
	}
	
	public void refresh(){
		branchID.setSelectedItem(null);
		for(int i=0;i<7;i++){
			fields[i].setText(null);
		}
	}
	private static final long serialVersionUID = 1L;
}
