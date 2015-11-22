package ui.specialui.manager.AdjustBase;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

public class Panel_Manager_ModifyBaseInfo extends MyTranslucentPanel{

	public Panel_Manager_ModifyBaseInfo() {
		super(365,100,550,550);
		this.initComponent();
	}

	private void initComponent() {
		MyJLabel title = new MyJLabel(195,10,170,40, "修改成本信息", 24, true);
		this.add(title);
		
	}

	private static final long serialVersionUID = 1L;

}
