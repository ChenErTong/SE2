package ui.specialui.manager.ViewBusinessPerformance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;

public class Panel_Manager_ViewBusinessPerformance extends MyJPanel{

	private static final long serialVersionUID = 1L;
	private Panel_Manager_BusinessPerformance businessPerformance;
	private Panel_Manager_SearchPerformance searchPerformance;
	
	public Panel_Manager_ViewBusinessPerformance(FrameManager frameManager) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(550, 20, 210, 90, "查看经营情况表", 24, true));
		businessPerformance = new Panel_Manager_BusinessPerformance();
		this.add(businessPerformance);
		
		searchPerformance = new Panel_Manager_SearchPerformance();
		this.add(searchPerformance);
		
		MyJButton ViewIncomeTable = new MyJButton(460, 673, 150, 40,"经营情况表预览",14);
		ViewIncomeTable.setActionCommand("ViewIncomeTable");
		ViewIncomeTable.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("222");
			}
			
		});
		this.add(ViewIncomeTable);
		ViewIncomeTable.setVisible(true);
		
		MyJButton ExportIncomeTable = new MyJButton(1040,673,150,40,"生成经营情况表",14);
		ExportIncomeTable.setActionCommand("ExportIncomeTable");
		ExportIncomeTable.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(ExportIncomeTable);
		ExportIncomeTable.setVisible(true);
	}

}
