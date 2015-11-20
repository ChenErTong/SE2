package ui.specialui.manager.AdjustSalaryPolicy;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class Panel_Manager_PolicyInfo extends MyTranslucentPanel{

	public Panel_Manager_PolicyInfo() {
		super(365, 100, 550, 560);
		this.initComponent();
	
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		MyJLabel title = new MyJLabel(195,10,170,40, "新增策略信息", 24, true);
		this.add(title);
		
		MyJLabel  policyName = new MyJLabel(20, 60, 100, 30, "新策略名称", 18, true);
		this.add(policyName);
		
		MyJLabel policyRule = new MyJLabel(275,60,90,30,"策略解释",18,true);
		this.add(policyRule);
		
		
		MyJLabel policyCalculate = new MyJLabel(20,150, 150, 30, "策略计算规则:", 18, true);
		this.add(policyCalculate);
		
		MyJTextField nameField = new MyJTextField(120,60,150,30);
		this.add(nameField);
		
		MyEmptyTextArea policyRuleArea = new MyEmptyTextArea(365,60,150,30);
		this.add(policyRuleArea);

		MyEmptyTextArea policyCalculateArea = new MyEmptyTextArea(20,185,510,150);
		this.add(policyCalculateArea);
		
	}

	private static final long serialVersionUID = 1L;

}
