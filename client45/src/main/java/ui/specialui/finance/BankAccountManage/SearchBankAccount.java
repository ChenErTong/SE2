package ui.specialui.finance.BankAccountManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import ui.image.LoginImage;
import ui.myui.MyFont;
import ui.myui.MyButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import vo.BankAccountVO;

/**
 * 查找银行账户的半透明Panel
 * @author zsq
 */
public class SearchBankAccount extends MyTranslucentPanel {

	private static final long serialVersionUID = 1L;
	
	private MyJComboBox findType;
	private MyJTextField searchField;
	private MyButton searchButton;
	private   MyJTable	table;
	private JScrollPane jsp;
	
	static ArrayList<BankAccountVO> accountPool;
	static String accountID = " ";
	
	public SearchBankAccount(BankAccountManage manage) {
		super(70,70,550,530);
		this.initComponent(manage);
}

private void initComponent(BankAccountManage manage) {

	this.add(new MyJLabel(10,10,150,30,"选择查找类型:",16,true));
	searchField = new MyJTextField(140,40,200,30);
	searchField.setText(" 在此输入搜索关键字  ");
	searchField.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==searchField){
				searchField.setText(null);
			}
		}
	});
	this.add(searchField);
	
	String[] types = {"账户ID","账户名称","账户余额","模糊查找"};
	findType = new MyJComboBox(10,40,120,30,types);
	this.add(findType);
	
	searchButton = new MyButton(420,40,30,30,LoginImage.getBUTTON_LOGISTIC());
	searchButton.setActionCommand("SearchBankAccount");
	searchButton.addActionListener(manage);
	this.add(searchButton);
	
	this.initTable();
}
	private void initTable(){
		//the table
		String[] headers = {"账户编号","账户名称","账户余额"};
		table = new MyJTable(headers, false);
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setFont(new MyFont(14));
					
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(80);
		firsetColumn.setMaxWidth(80);
		firsetColumn.setMinWidth(80);
		
		TableColumn secondColumn = table.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(250);
		secondColumn.setMaxWidth(250);
		secondColumn.setMinWidth(250);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
							  	
		jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setFont(new MyFont(14));
		head.setForeground(Color.BLACK);
		head.setResizingAllowed(false);
						
		jsp.setBounds(10, 76, 530, 444);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
	}
	public String[] getData(){
		String [] data = new String[3];
		
		data[0] = findType.getSelectedIndex()+"";
		data[1] = searchField.getText();
	
		if(data[0]==null&&data[1]==null){
			return null;
		}
		return data;
	}
	
	public  void setData(String[] data){
		findType.setSelectedItem(data[0]);
		searchField.setText(data[1]);
	}
	
	
	public void refresh() {
		findType.setSelectedItem(null);
		searchField.setText(null);
		
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
}

	


