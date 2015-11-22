package ui.specialui.branch_conuterman.debitNoteBuild;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.branch_conuterman.Frame_Branch;

public class DebitNoteBuild extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public DebitNoteBuild(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(550, 30, 210, 45, "收款单建立", 30, true));
	}
}
