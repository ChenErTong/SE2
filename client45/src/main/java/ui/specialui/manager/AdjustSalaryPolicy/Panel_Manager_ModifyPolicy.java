package ui.specialui.manager.AdjustSalaryPolicy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;

public class Panel_Manager_ModifyPolicy extends MyJPanel{
	private Panel_Manager_ModifyInfo modifyInfo;
	public Panel_Manager_ModifyPolicy() {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent();
	}

	private void initComponent() {
		modifyInfo = new Panel_Manager_ModifyInfo();
		this.add(modifyInfo);
		
		MyJButton confirmModify = new MyJButton(460,682,150,30,"确认修改",18);
		confirmModify.setActionCommand("ModifyPolicy");
		confirmModify.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
			});
		this.add(confirmModify);
		
	
		
		MyJButton backoutModify = new MyJButton(650,682,150,30,"取消修改",18);
		backoutModify.setActionCommand("BackoutModify");
		backoutModify.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
			
			});
		this.add(backoutModify);
		
	}

	private static final long serialVersionUID = 1L;

}
