package ui.specialui.manager.ViewLogMsg;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyFont;

import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
/**
 * 查看、显示系统记录日志的Panel
 * @author zsq
 * @version 2015/12/05 14:45
 */
public class LogPanel extends MyTranslucentPanel{
	private MyEmptyTextArea ta;
	private MyButton search,showAll;
	private DateLabel[] dateLabel;
	private MyJTextField[] input;
	private MyJTable table;
	
	private static final long serialVersionUID = 1L;
	
	public LogPanel(ViewLogPanel handle) {
		super(50, 100-30, 1180, 600);
		this.addInput();
		this.initButton(handle);
		this.initTable();
		
		ta = new MyEmptyTextArea(620+42,50,500,530);
		ta.setBackground(Color.WHITE);
		this.add(ta);
		
		MyJLabel  startDate = new MyJLabel(20,10,120,30,"请选择日期:",16,true);
		this.add(startDate);
		
		MyJLabel year = new MyJLabel(142,10,30,30,"年",16,true);
		this.add(year);
		
		MyJLabel month = new MyJLabel(265,10,30,30,"月",16,true);
		this.add(month);
		
		MyJLabel day = new MyJLabel(388,10,30,30,"日",16,true);
		this.add(day);
		
		this.add(new MyJLabel(760+42,10,150,30,"操作记录信息",20,true));
	}
	
	class DateLabel extends JLabel {
		private static final long serialVersionUID = 1L;

		public DateLabel(String Text) {
			super(Text, JLabel.LEFT);
			this.setFont(getFont());
		}
	}
	/**
	 * 添加输入日期的输入框
	 */
	private void addInput() {
		dateLabel = new DateLabel[3];
		input = new MyJTextField[3];
		SimpleDateFormat[] sdf = new SimpleDateFormat[3];
		String[] date_s = {"年", "月", "日"};
		String[] dateFormat = {"yyyy", "MM", "dd"};
		Date curDate = new Date();
		// 初始化输入框，设置标签和输入框的位置，并且添加标签和输入框
		for(int i = 0; i < dateLabel.length; i++) {
			dateLabel[i] = new DateLabel(date_s[i]);
			sdf[i] = new SimpleDateFormat(dateFormat[i]);
			input[i] = new MyJTextField(172+i*123,10,90,30);
			input[i].setText(sdf[i].format(curDate));
			input[i].setFont(getFont());
			input[i].setHorizontalAlignment(JTextField.CENTER);
			this.add(input[i]);
			this.add(dateLabel[i]);
		}
	}
	/**
	 * 添加按钮
	 */
	private void initButton(ViewLogPanel panel){
		search = new MyButton(534,10,30,30,LoginImage.getBUTTON_LOGISTIC());
	//	showAll = new MyJButton(0,0,0,0,"显示全部",18);
		search.setActionCommand("Search");
		search.addActionListener(panel);
		
	//	showAll.setActionCommand("ShowAll");
		//showAll.addActionListener(panel);
		
		this.add(search);
		//this.add(showAll);	
	}
	/**
	 * 初始化表格
	 */
	private void initTable(){
		String[] headers = {"操作人","操作时间","操作记录"};
		table = new MyJTable(headers,false);
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setFont(new MyFont(14));

		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(100);
		firsetColumn.setMaxWidth(100);
		firsetColumn.setMinWidth(100);
		
		TableColumn secondColumn = table.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(100);
		secondColumn.setMaxWidth(100);
		secondColumn.setMinWidth(100);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
			  	
		JScrollPane jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setFont(new MyFont(14));
		head.setForeground(Color.BLACK);
		head.setResizingAllowed(false);
				
		jsp.setBounds(15, 50, 590, 530);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
	}
	
	
	public String[] getData(){
		String[] data = new String[3];
		for(int i=0;i<3;i++){
			data[i] = input[i].getText();
			if(data[i]==null){
				return null;
			}
		}
		return data;
	}
	
	public MyEmptyTextArea getText(){
		return  ta;
	}
	
	public MyJTable getTable() {
		return table;
	}
}


