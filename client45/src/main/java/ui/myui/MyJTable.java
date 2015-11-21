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
 * @time 2015/11/17 20:04
 * 待修改
 */
public class MyJTable extends JTable{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private Boolean isCellEditable;
	private String[] headers;
	private String[][] cellData;
	
	public MyJTable(String[] headers, boolean isCellEditable){
		this.isCellEditable = isCellEditable;
		this.headers = headers;
		
		cellData = null;
		
		this.setCellEditable();
		
		this.setBackground(new Color(0, 0, 0, 0.3f));
		this.setForeground(Color.WHITE);
		this.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		this.setDefaultRenderer(Object.class, tcr);
		this.setRowSelectionAllowed(true);	
 
		JTableHeader head = this.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setFont(new MyFont(14));
		head.setForeground(Color.BLACK);
		head.setDefaultRenderer(tcr);
		head.setResizingAllowed(false);	
		head.setEnabled(false);
	}

	/**
	 * 设置表格内容能否修改
	 * @param cellData
	 * @param headers
	 * @param cellEditable
	 */
	private void setCellEditable(){
		model = new DefaultTableModel(cellData, headers) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return MyJTable.this.isCellEditable;
			}
		};
		this.setModel(model);
	}
	
	public void addRow(String[] rowData){
		model.addRow(rowData);
		this.setModel(model);
	}
	
	public void removeRow(){
		int[] selectedRows = this.getSelectedColumns();
		int j = 0;
		
		for (int i : selectedRows) {
			model.removeRow(i - j);
			j ++;
		}
		this.clearSelection();
		this.setModel(model);
	}
	
	public void clear(){
		model = new DefaultTableModel(null, this.headers);
		this.setModel(model);
	}
	
	public String[][] getData(){
		int row = this.getRowCount();
		int column = this.getColumnCount();
		
		String[][] data = new String[row][column];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				data[i][j] = (String) this.getValueAt(i, j);
			}
		}
		
		return data;
	}
}