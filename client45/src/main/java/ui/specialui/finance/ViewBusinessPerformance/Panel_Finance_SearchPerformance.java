package ui.specialui.finance.ViewBusinessPerformance;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.finance.Frame_Finance;

public class Panel_Finance_SearchPerformance extends MyTranslucentPanel{
	private MyComboBox yearBox;
	private MyComboBox yearBox_2;
	private MyComboBox monthBox;
	private MyComboBox monthBox_2;
	private MyComboBox dayBox;
	private MyComboBox dayBox_2;
	private MyJButton search;
	public Panel_Finance_SearchPerformance(Frame_Finance frame_Finance) {
		super(80, 120, 550, 550);
		this.initComponent(frame_Finance);

	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add( new MyJLabel(20,20,120,30,"选择开始日期:",16,true));
		this.add( new MyJLabel(20,55,120,30,"选择截止日期:",16,true));
		this.add(new MyJLabel(142,20,30,30,"年",16,true));
		this.add(new MyJLabel(142,55,30,30,"年",16,true));
		this.add(new MyJLabel(265,20,30,30,"月",16,true));
		this.add( new MyJLabel(265,55,30,30,"月",16,true));
		this.add(new MyJLabel(388,20,30,30,"日",16,true));
		this.add(new MyJLabel(388,55,30,30,"日",16,true));
		
		String[] years = {"2015","2014"};
		yearBox = new MyComboBox(172,20,90,30,16,years);
		this.add(yearBox);
		yearBox_2 = new MyComboBox(172,55,90,30,16,years);
		this.add(yearBox_2);
		
		String[] months = {"一月","二月"};
		monthBox = new MyComboBox(295,20,90,30,16,months);
		this.add(monthBox);
		monthBox_2 = new MyComboBox(295,55,90,30,16,months);
		this.add(monthBox_2);
		
		String[] days = {"01","02"};
		dayBox = new MyComboBox(418,20,90,30,16,days);
		this.add(dayBox);
		dayBox_2 = new MyComboBox(418,55,90,30,16,days);
		this.add(dayBox_2);
		
		search = new MyJButton(418,90,90,30,"搜索",16);
		search.setActionCommand("SearchReceipt");
		search.addActionListener(frame_Finance);
		this.add(search);
		
		//the table
				String[] headers = {"单据种类","单据内容"};
				MyJTable	table = new MyJTable(headers, false);
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
