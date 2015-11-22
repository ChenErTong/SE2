package ui.specialui.manager.AdjustSalaryPolicy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;


public class Panel_Manager_AddNewPolicy extends MyJPanel{
	private Panel_Manager_PolicyInfo policyInfo;
	public Panel_Manager_AddNewPolicy() {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent();
	}
	

	private void initComponent() {
		policyInfo = new Panel_Manager_PolicyInfo();
		this.add(policyInfo);
		
		MyJButton confirmAdd = new MyJButton(460,682,150,30,"确认添加",18);
		confirmAdd.setActionCommand("AddNewPolicy");
		confirmAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
			});
		this.add(confirmAdd);
		
	
		
		MyJButton backoutAdd = new MyJButton(650,682,150,30,"取消添加",18);
		backoutAdd.setActionCommand("BackoutAdd");
		backoutAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
			
			});
		this.add(backoutAdd);
		}

	private static final long serialVersionUID = 1L;

}
