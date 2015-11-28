package ui.specialui.manager.AdjustSalaryPolicy;

import ui.myui.MyComboBox;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;
/*"员工类别","策略类别","策略规则","详细策略解释"*/
public class PolicyDetails extends MyTranslucentPanel{
	private MyComboBox employeeType;
	private MyComboBox policyType;
	private MyEmptyTextArea policyRule;
	private MyEmptyTextArea policyExplain;
	public PolicyDetails() {
		super(680,100,550,562);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(25,50,90,30,"员工类别",18,true));
		this.add(new MyJLabel(285,50,90,30,"策略类别",18,true));
		this.add(new MyJLabel(25,140,90,30,"策略规则",18,true));
		this.add(new MyJLabel(25,375,90,30,"策略解释",18,true));
		String [] employeeList = {"快递员","财务人员","中转中心业务员","库存管理人员","营业厅业务员","司机","管理员","总经理"};
		employeeType = new MyComboBox(115,50,150,30,14,employeeList);
		this.add(employeeType);
		String [] policyList = {"按月","计次","提成"};
		policyType = new MyComboBox(375,50,150,30,14,policyList);
		this.add(policyType);
		
		policyRule = new MyEmptyTextArea(115,140,410,180);
		this.add(policyRule);
		
		policyExplain = new MyEmptyTextArea(115,355,410,180);
		this.add(policyExplain);
		
	}

	private static final long serialVersionUID = 1L;

	public void setUneditable() {
		employeeType.setEditable(false);
		policyType.setEditable(false);
		policyRule.setEditable(false);
		policyExplain.setEditable(false);
		
	}

	public void setData(String[] data) {
		if(data!=null){
			employeeType.setSelectedItem(data[0]);
			policyType.setSelectedItem(data[1]);
			policyRule.setText(data[2]);
			policyExplain.setText(data[3]);
		}
	}

	public void refresh() {
		
	}

	public String[] getData() {
		String[] data = new String[9];
		data[0] = employeeType.getSelectedIndex()+"";
		data[1] = policyType.getSelectedIndex()+"";
		data[2] = policyRule.getText();
		data[3] = policyRule.getText();
		if(data==null){
			return null;
		}else {
			return data;
		}
	}

}
