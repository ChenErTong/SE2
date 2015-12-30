package ui.specialui.finance.CostManage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

/**
 * 选择日期进行收款单搜索，并且显示搜索得到的收款单列表
 * @author zsq
 * @version 2015/11/30 23:14
 */
public class SearchDebitReceipt extends MyTranslucentPanel{
	
	private MyJLabel chooseBranch;
	private MyJComboBox branchList;
	//private MyComboBox dateList;
	private MyButton search;
	private MyJTable table;
	private JScrollPane jsp;
	
	private DateLabel[] dateLabel;
	private MyJTextField[] input;
	
	public SearchDebitReceipt(CostManagement handle) {
		super(20, 70, 680, 560);
		this.initComponent(handle);
	}

	private void initComponent(CostManagement handle) {
		
		MyJLabel year = new MyJLabel(250-90,10,30,30,"年",16,true);
		this.add(year);
		
		MyJLabel month = new MyJLabel(373-90,10,30,30,"月",16,true);
		this.add(month);
		
		MyJLabel day = new MyJLabel(526-30-90,10,30,30,"日",16,true);
		this.add(day);
		
		chooseBranch = new MyJLabel(10,10,60,30,"请选择：",14,true);
		this.add(chooseBranch);
	
		String[] branches = {"南京","上海","北京","广州"};
		branchList = new MyJComboBox(160-90,10,90,30,branches);
		this.add(branchList);
		 
		//String[] dates = {""};
		//dateList = new MyComboBox(330,10,150,30,14,dates);
		//this.add(dateList);
		
		search = new MyButton(280+3*123-90,10,30,30,LoginImage.getBUTTON_LOGISTIC());
		search.setActionCommand("SearchDebitReceipt");
		search.addActionListener(handle);
		this.add(search);
		
		this.addInput();
		this.initTable();
		
	}
	private void initTable(){
		String[] headers = {"收款单编号","收款日期","收款金额","收款快递员","对应订单条形码"};
		table = new MyJTable(headers, false, this);			
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				SearchDebitReceipt.this.repaint();
			}
		});
		jsp=new MyJScrollPane(15, 50, 590+60, 495, table);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				SearchDebitReceipt.this.repaint();
			}
		});
		this.add(jsp);
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
			input[i] = new MyJTextField(280-90+i*123,10,90,30);
			input[i].setText(sdf[i].format(curDate));
			input[i].setFont(getFont());
			input[i].setHorizontalAlignment(JTextField.CENTER);
			this.add(input[i]);
			this.add(dateLabel[i]);
		}
	}
	
	public void setData(String[] data) {
		branchList.setSelectedItem(data[0]);
		//dateList.setSelectedItem(data[1]);
	}

	public String[] getData() {
		String  data[] = new String[4] ;
		data[0] = (String) branchList.getSelectedItem();
		for(int i=0;i<3;i++){
			data[i+1] = input[i].getText();
			if(data[i]==null){
				return null;
			}
		}
		return data;
	}
	
	public MyJTable getTable(){
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
	

	private static final long serialVersionUID = 1L;

}
