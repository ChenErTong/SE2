package ui.specialui.finance.ViewBusinessPerformance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.manager.ViewBusinessPerformance.Panel_Manager_BusinessPerformance;
import ui.specialui.manager.ViewBusinessPerformance.Panel_Manager_SearchPerformance;

public class Panel_Finance_ViewBusinessPerformance extends MyJPanel{
	private Panel_Finance_BusinessPerformance businessPerformance;
	private Panel_Finance_SearchPerformance searchPerformance;
	private static final long serialVersionUID = 1L;

	public Panel_Finance_ViewBusinessPerformance(Frame_Finance frame_Finance) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
	}
	private void initComponent() {
		businessPerformance = new Panel_Finance_BusinessPerformance();
		this.add(businessPerformance);
		
		searchPerformance = new Panel_Finance_SearchPerformance();
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
		
		MyJButton ExportIncomeTable = new MyJButton(1040,673,150,40,"导出经营情况表",14);
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
