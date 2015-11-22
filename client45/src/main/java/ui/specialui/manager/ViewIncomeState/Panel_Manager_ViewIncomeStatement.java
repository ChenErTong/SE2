package ui.specialui.manager.ViewIncomeState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.myui.MyJButton;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;

public class Panel_Manager_ViewIncomeStatement extends MyJPanel {

    private Panel_Manager_SearchIncomeStatement searchPanel;
	private Panel_Manager_IncomeState statePanel;
	public Panel_Manager_ViewIncomeStatement(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	private void initComponent(FrameManager frameManager) {
		searchPanel = new Panel_Manager_SearchIncomeStatement();
		this.add(searchPanel);
		
		statePanel = new Panel_Manager_IncomeState();
		this.add(statePanel);
		
		MyJButton SelectedAllReceipts = new MyJButton(120, 673, 150, 40,"选中所有单据",14);
		SelectedAllReceipts.setActionCommand("SelectedAllReceipts");
		SelectedAllReceipts.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	System.out.println("111");
				
			}
			
		});
		this.add(SelectedAllReceipts);
		SelectedAllReceipts.setVisible(true);
		
		MyJButton ViewIncomeTable = new MyJButton(380, 673, 150, 40,"成本收益表预览",14);
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
		
		MyJButton ExportIncomeTable = new MyJButton(1040,673,150,40,"生成成本收益表",14);
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

	private static final long serialVersionUID = 1L;

}
