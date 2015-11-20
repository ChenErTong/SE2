package ui.specialui.manager.ViewBusinessPerformance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyTable;
import ui.myui.MyTranslucentPanel;

public class Panel_Manager_SearchPerformance extends MyTranslucentPanel{

	public Panel_Manager_SearchPerformance() {
		super(80, 120, 550, 550);
		this.initComponent();

	}

	private void initComponent() {
		MyJLabel  startDate = new MyJLabel(20,20,120,30,"选择开始日期:",16,true);
		this.add(startDate);
		
		MyJLabel endDate = new MyJLabel(20,55,120,30,"选择截止日期:",16,true);
		this.add(endDate);
		
		MyJLabel year = new MyJLabel(142,20,30,30,"年",16,true);
		this.add(year);
		
		MyJLabel year_2 =new MyJLabel(142,55,30,30,"年",16,true);
		this.add(year_2);
		
		MyJLabel month = new MyJLabel(265,20,30,30,"月",16,true);
		this.add(month);
		
		MyJLabel month_2 = new MyJLabel(265,55,30,30,"月",16,true);
		this.add(month_2);
		
		MyJLabel day = new MyJLabel(388,20,30,30,"日",16,true);
		this.add(day);
		MyJLabel day_2 = new MyJLabel(388,55,30,30,"日",16,true);
		this.add(day_2);
		
		String[] years = {"2015","2014"};
		MyComboBox yearBox = new MyComboBox(172,20,90,30,16,years);
		this.add(yearBox);
		MyComboBox yearBox_2 = new MyComboBox(172,55,90,30,16,years);
		this.add(yearBox_2);
		
		String[] months = {"一月","二月"};
		MyComboBox monthBox = new MyComboBox(295,20,90,30,16,months);
		this.add(monthBox);
		MyComboBox monthBox_2 = new MyComboBox(295,55,90,30,16,months);
		this.add(monthBox_2);
		
		String[] days = {"01","02"};
		MyComboBox dayBox = new MyComboBox(418,20,90,30,16,days);
		this.add(dayBox);
		MyComboBox dayBox_2 = new MyComboBox(418,55,90,30,16,days);
		this.add(dayBox_2);
		
		MyJButton search = new MyJButton(418,90,90,30,"搜索",16);
		search.setActionCommand("SearchReceipt");
		search.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("111");
			}
		});
		this.add(search);
		
		//the table
				String[] headers = {"单据种类","单据内容"};
				MyTable	table = new MyTable(headers);
				table.setBackground(new Color(40, 42, 66));
				table.setForeground(Color.WHITE);
				table.setFont(new MyFont(14));
							
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
				tcr.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, tcr);
									  	
				JScrollPane jsp=new JScrollPane(table);
				JTableHeader head = table.getTableHeader();
				head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
				head.setFont(new MyFont(14));
				head.setForeground(Color.BLACK);
				head.setResizingAllowed(false);
								
				jsp.setBounds(20, 122, 510, 420);
				jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
				jsp.setOpaque(false);
				jsp.setBorder(BorderFactory.createEmptyBorder());
				jsp.setVisible(true);
				this.add(jsp);
		
	}

	private static final long serialVersionUID = 1L;


}
