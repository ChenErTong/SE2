package ui.specialui.finance.ViewBusinessPerformance;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;

public class Panel_Finance_ViewBusinessPerformance extends MyJPanel{
	private Panel_Finance_BusinessPerformance businessPerformance;
	private Panel_Finance_SearchPerformance searchPerformance;
	private MyJButton ViewBusinessState;
	private MyJButton ExportBusinessState;
	private static final long serialVersionUID = 1L;

	public Panel_Finance_ViewBusinessPerformance(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}
	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(540,40,200,40,"查看经营情况表",24,true));
		businessPerformance = new Panel_Finance_BusinessPerformance();
		this.add(businessPerformance);
		
		searchPerformance = new Panel_Finance_SearchPerformance(frame_Finance);
		this.add(searchPerformance);
		
		ViewBusinessState = new MyJButton(460, 673, 150, 40,"经营情况表预览",14);
		ViewBusinessState.setActionCommand("ViewBusinessState");
		ViewBusinessState.addActionListener(frame_Finance);
		this.add(ViewBusinessState);
		
		ExportBusinessState = new MyJButton(1040,673,150,40,"导出经营情况表",14);
		ExportBusinessState.setActionCommand("ExportBusinessState");
		ExportBusinessState.addActionListener(frame_Finance);
		this.add(ExportBusinessState);
		
	}
}
