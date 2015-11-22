package ui.specialui.manager.HandleOrganization;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

public class Panel_Manager_OrganizationInfo extends MyTranslucentPanel{
	
	private static final long serialVersionUID = 1L;

	public Panel_Manager_OrganizationInfo() {
		super(680, 100, 550, 540);
		this.initComponent();
	}
	
	private void initComponent() {
		MyJLabel title = new MyJLabel(195,10,170,40,"机构详细信息",18,true);
		this.add(title);
	}
}
