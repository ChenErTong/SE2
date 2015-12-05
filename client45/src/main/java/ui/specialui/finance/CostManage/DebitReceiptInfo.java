package ui.specialui.finance.CostManage;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.GetDate;
import ui.myui.MyFont;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

/**
 * 显示收款单详细信息的Panel
 * @author zsq
 * @version 2015/11/30 00:14
 */
public class DebitReceiptInfo extends MyTranslucentPanel{
	
	private static final long serialVersionUID = 1L;
	
	private MyJTextField numberField;
	private MyJTextField courierField;
	private MyJTextField dateField;
	private  MyJTable table;
	
	public DebitReceiptInfo() {
		super(680,100,550,240);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(240,10,150,30,"收款单信息",18,true));
		this.add(new MyJLabel(40,50,90,30,"收款日期",16,true));
		this.add(new MyJLabel(290,50,90,30,"收款金额",16,true));
		this.add(new MyJLabel(40,90,90,30,"收款快递员",16,true));
		this.add(new MyJLabel(290,90,100,30,"对应订单号",16,true));
		
		dateField = new MyJTextField(140,50,120,30);
		dateField.setText(GetDate.getDate());
		this.add(dateField);
		numberField = new MyJTextField(380,50,120,30);
		numberField.setOnlyInteger(100);
		this.add(numberField);
		courierField = new MyJTextField(140,90,120,30);
		this.add(courierField);
		
		String[] headers = {"对应订单号"};
		table = new MyJTable(headers, false);
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
						
		jsp.setBounds(390, 90, 130, 140);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
	}

	public void setUneditable() {
		dateField.setEditable(false);
		numberField.setEditable(false);
		courierField.setEditable(false);
		
	}

	public  MyJTable getTable(){
		return table;
	}

	public void setData(Object[] data) {
		dateField.setText((String)data[0]);
		numberField.setText((String)data[1]);
		courierField.setText((String)data[2]);
	}
}
