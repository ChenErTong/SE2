package ui.specialui.finance.OpenningStock;

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
import ui.myui.MyJPanel;
import ui.myui.MyTable;
import ui.specialui.finance.Frame_Finance;

public class Panel_Finance_OpenningStock extends MyJPanel{

	private static final long serialVersionUID = 1L;
	private Panel_Finance_OpenningStockInfo openningStockInfo;
	public Panel_Finance_OpenningStock(Frame_Finance frame_Finance) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		openningStockInfo = new Panel_Finance_OpenningStockInfo();
		this.add(openningStockInfo);
		
		MyJLabel chooseYear = new MyJLabel(50,100,120,30,"请选择年份:",18,true);
		this.add(chooseYear);
		
		String[] years = {"2014","2015"};
		MyComboBox  yearList = new MyComboBox(170,100,150,30,18,years);
		this.add(yearList);
		
		//the table
				String[] headers = {"机构","人员","车辆","库存","银行账户","账户余额"};
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
								
				jsp.setBounds(20, 140, 630, 495);
				jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
				jsp.setOpaque(false);
				jsp.setBorder(BorderFactory.createEmptyBorder());
				jsp.setVisible(true);
				this.add(jsp);
				
		MyJButton viewStockInfo = new MyJButton(85,650,150,30,"查看期初账目",18);
		viewStockInfo.setActionCommand("ViewStockInfo");
		viewStockInfo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(viewStockInfo);
		
		MyJButton addNewStock = new MyJButton(405,650,150,30,"新建期初账目",18);
		addNewStock.setActionCommand("AddNewStock");
		addNewStock.addActionListener(frame_Finance);
		this.add(addNewStock);
		
	}

}
