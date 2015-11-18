package ui.myui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 * 表格类
 * @author zsq
 * @time 2015/11/18 20:04
 * copy version 待修改
 */
public class MyTable extends JTable{

	private static final long serialVersionUID = 1L;
	
	Boolean flag = false;
	
	public MyTable(String[] headers){
			
		Object[][] cellData = null;
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { //这里让表不可修改
			
			return false;
				
			}
		};
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		this.setDefaultRenderer(Object.class, tcr);
		
		this.setModel(model);
		this.setRowSelectionAllowed(true);	
	    JTableHeader tableH = this.getTableHeader();	 
	    tableH.setBackground(backColor);  
	    tableH.setForeground(foreColor);
	    tableH.setReorderingAllowed(false); 
	}
	
	public MyTable(String[] headers, Boolean _flag){
		
	Object[][] cellData = null;
	
	flag = _flag;
	
	Color foreColor = Color.WHITE;
	Color backColor = MyColor.getColor();
	
	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
	tcr.setHorizontalAlignment(JLabel.CENTER);
	this.setDefaultRenderer(Object.class, tcr);
	
	DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) { //这里让表不可修改
			if(flag == false){
				return false;
			}else if(flag == true && column >= 3){
				return true;
			}else{
				return false;
			}
		}
	};
	
	this.setModel(model);
	this.setRowSelectionAllowed(true);	
    JTableHeader tableH = this.getTableHeader();	 
    tableH.setBackground(backColor);  
    tableH.setForeground(foreColor);
    tableH.setReorderingAllowed(false); 
}
	
	public MyTable(String[] headers, int _flag){
		
		Object[][] cellData = null;
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { //这里让表不可修改
				return true;
			}
		};
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		this.setDefaultRenderer(Object.class, tcr);
		
		this.setModel(model);
		this.setRowSelectionAllowed(true);	
	    JTableHeader tableH = this.getTableHeader();	 
	    tableH.setBackground(backColor);  
	    tableH.setForeground(foreColor);
	    tableH.setReorderingAllowed(false); 
	}
}
