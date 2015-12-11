package ui.specialui.finance.SettlementManage;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyFont;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

/**
 * 按照日期搜索收款单
 * @author zsq
 * @version 2015/12/5 10:11
 */
public class SearchPayReceipt extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;
	
	private MyJLabel chooseDate;
	private MyButton search;
	private MyJTable table;
	private JScrollPane jsp;
	
	private DateLabel[] dateLabel;
	private MyJTextField[] input;
	
	public SearchPayReceipt(SettlementManage handle) {
		super(30, 100-30, 620, 240);
		this.initComponent(handle);
	}

	private void initComponent(SettlementManage handle) {
		chooseDate = new MyJLabel(20,10,90,30,"请填写日期",14,true);
		this.add(chooseDate);
		
		MyJLabel year = new MyJLabel(142-30,10,30,30,"年",16,true);
		this.add(year);
		
		MyJLabel month = new MyJLabel(265-30,10,30,30,"月",16,true);
		this.add(month);
		
		MyJLabel day = new MyJLabel(388-30,10,30,30,"日",16,true);
		this.add(day);
		
	//	String[] dates = {""};
		//dateList = new MyComboBox(140,10,150,30,14,dates);
		//this.add(dateList);
		
		search = new MyButton(508-30+5,10,30,30,LoginImage.getBUTTON_LOGISTIC());
		search.setActionCommand("SearchPayReceipt");
		search.addActionListener(handle);
		this.add(search);
		
		this.initTable();
		this.addInput();
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
			input[i] = new MyJTextField(172+i*123-30,10,90,30);
			input[i].setText(sdf[i].format(curDate));
			input[i].setFont(getFont());
			input[i].setHorizontalAlignment(JTextField.CENTER);
			this.add(input[i]);
			this.add(dateLabel[i]);
		}
	}
	
		private void initTable(){
		//the table
				String[] headers = {"付款单编号","付款人","付款金额","付款账号","付款条目","付款备注","付款日期"};
				table = new MyJTable(headers, false);
				table.setBackground(new Color(40, 42, 66));
				table.setForeground(Color.WHITE);
				table.setFont(new MyFont(14));
									
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
				tcr.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, tcr);
											  	
				jsp=new JScrollPane(table);
				JTableHeader head = table.getTableHeader();
				head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
				head.setFont(new MyFont(14));
				head.setForeground(Color.BLACK);
				head.setResizingAllowed(false);
										
				jsp.setBounds(15, 50, 590, 180);
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
	
	public MyJTable getTable() {
		return table;
	}
	@SuppressWarnings("unused")
	private class WheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			JScrollBar onlineFriendsBar =  jsp.getHorizontalScrollBar();
			if (!((onlineFriendsBar.getValue() == onlineFriendsBar.getMinimum() && e.getWheelRotation() <= 0) || (onlineFriendsBar.getValue() == onlineFriendsBar.getMaximum() && e.getWheelRotation() >= 0))) {
				if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 >= onlineFriendsBar.getMaximum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMaximum());
				} else if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 <= onlineFriendsBar.getMinimum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMinimum());
				} else {
					onlineFriendsBar.setValue(onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement()
												* e.getUnitsToScroll() * 10);
				}
			}
		}
	}
}
