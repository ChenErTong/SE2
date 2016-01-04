package ui.specialui.manager.AdjustSalaryPolicy;

import java.awt.Color;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;
/**
 * 修改已有的薪水策略
 * @author zsq
 * @version 2015/12/05 14：10
 */
public class ModifyPolicy extends MyTranslucentPanel{
	
	private MyJComboBox employeeType;
	private MyJComboBox policyType;
	private MyEmptyTextArea policyRule;
	
	public ModifyPolicy() {
		super(680,390-30,550,240);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(225,10,100,30,"修改常量",20,true));
		this.add(new MyJLabel(25,50,90,30,"员工类别",18,true));
		this.add(new MyJLabel(285,50,90,30,"策略类别",18,true));
		this.add(new MyJLabel(25,140,90,30,"策略规则",18,true));
		String [] employeeList = {"快递员","财务人员","中转中心业务员","库存管理人员","营业厅业务员","司机","管理员","总经理"};
		employeeType = new MyJComboBox(115,50,150,30,employeeList);
		this.add(employeeType);
		String [] policyList = {"按月","计次","提成"};
		policyType = new MyJComboBox(375,50,150,30,policyList);
		this.add(policyType);
		
		policyRule = new MyEmptyTextArea(115,140,410,90,true);
		policyRule.setBackground(Color.WHITE);
		this.add(policyRule);
	}
	
	public void setData(Object[] data) {
		if(data!=null){
			employeeType.setSelectedItem(data[0]);
			policyType.setSelectedItem(data[1]);
			policyRule.setText((String) data[2]);
		}
	}

	public void refresh() {
		employeeType.setSelectedItem(null);
		policyType.setSelectedItem(null);
		policyRule.setText(null);
	}

	public String[] getData() {
		String[] data = new String[3];
		data[0] = employeeType.getSelectedIndex()+"";
		data[1] = policyType.getSelectedIndex()+"";
		data[2] = policyRule.getText();
		for(int i=0;i<2;i++){
			if(data[i]==" "){
				return null;
			}
		}
		if(data[2]==""){
			return null;
		}else{
			return data;
		}
		
	}
	private static final long serialVersionUID = 1L;

}
