package ui.specialui.finance.BankAccountManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
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
				searchField.setText("");
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
		table = new MyJTable(headers, false, this);  	
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				SearchBankAccount.this.repaint();
			}
		});
		jsp=new MyJScrollPane(10, 76, 530, 444, table);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				SearchBankAccount.this.repaint();
			}
		});
		this.add(jsp);
	}
	public String[] getData(){
		String [] data = new String[2];
		
		data[0] = findType.getSelectedIndex()+"";
		data[1] = searchField.getText();
		System.out.println(data[0]);
		System.out.println(data[1]);
	
		if(data[0].equals("")){
			return null;
		}else if(data[1].length()<=0){
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

	


