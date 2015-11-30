package ui.specialui.manager.ViewUserInfo;

import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class ModifyAccount extends MyTranslucentPanel{
	private MyJTextField[] fields ;
	public ModifyAccount() {
		super(680, 390,550,240);
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
		fields = new MyJTextField[7];
		fields[0] = new MyJTextField(130,50,120,30);
		this.add(fields[0]);
		
		fields[1] = new MyJTextField(380,50,120,30);
		this.add(fields[1]);
		
		fields[2] = new MyJTextField(130,90,120,30);
		fields[2].setOnlyInteger(19);
		this.add(fields[2]);
		
		fields[3] = new MyJTextField(380,90,120,30);
		this.add(fields[3]);
		
		fields[4] = new MyJTextField(130,130,120,30);
		this.add(fields[4]);
		
		fields[5] = new MyJTextField(380,130,120,30);
		this.add(fields[5]);	
		
		fields[6] = new MyJTextField(130,170,120,30);
		this.add(fields[6]);
	}



	public void setUneditable() {
		for(MyJTextField field: fields){
			field.setEditable(false);
		}
		
	}
	
	public String[] getData(){
		String [] data = new String[7];
		for(int i=0;i<7;i++){
			data[i] = fields[i].getText();
			if(data[i]==null){
				return null;
			}
		}
		return data;
	}
	
	public void setData(String [] data){
		for(int i=0;i<7;i++){
			fields[i].setText(data[i]);
		}
	}
	

	private static final long serialVersionUID = 1L;
}
