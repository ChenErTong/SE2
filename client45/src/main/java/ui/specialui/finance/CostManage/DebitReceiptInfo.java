package ui.specialui.finance.CostManage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import ui.myui.MyJLabel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
import util.GetDate;

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
		super(710,70,550,240+30+20);
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
		table = new MyJTable(headers, false, this);		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DebitReceiptInfo.this.repaint();
			}
		});
		MyJScrollPane jsp=new MyJScrollPane(390, 90, 130, 140, table);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				DebitReceiptInfo.this.repaint();
			}
		});
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
