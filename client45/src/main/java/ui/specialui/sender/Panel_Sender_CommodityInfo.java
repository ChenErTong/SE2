package ui.specialui.sender;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyFont;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTable;
import ui.myui.MyTranslucentPanel;
/**
 * 订单货物信息显示面板
 * @author zsq
 * @time 2015/11/18 19:32
 */
public class Panel_Sender_CommodityInfo extends MyTranslucentPanel{
	//private MyJComboBox packKindField;
	//private MyJComboBox deliveryKindField;
	public Panel_Sender_CommodityInfo() {
		super(10, 220, 620, 490);
		this.initComponent();
	}

	

	private void initComponent() {
		// TODO Auto-generated method stub
		this.add(new MyJLabel(250,10,170,40,"商品订单信息",18,true));
		//this.add(new MyJLabel(50, 54, 100, 20, "原件数/件:", 15, true));
		//this.add(new MyJLabel(190, 54, 120, 20, "实际体积/m^3:", 15, true));
		//this.add(new MyJLabel(360, 54, 120, 20, "实际重量/kg:", 15, true));
		//this.add(new MyJLabel(50, 100, 80, 20, "包装类型:", 15, true));
		//this.add(new MyJLabel(300, 100, 80, 20, "快递类型:", 15, true));
		//this.add(new MyJLabel(50, 146, 80, 20, "货物名:", 15, true));
		//this.add(new MyJLabel(300, 146, 80, 20, "货物种类:", 15, true));
		//this.add(new MyJLabel(50,186,80,20,"运输费用:",15,true));
		//this.add(new MyJLabel(300,186,120,20,"预计到达时间:",15,true));
		
		//String[] packs = {"纸盒", "塑料", "泡沫", "金属"};
		//packKindField = new MyJComboBox(130, 100, 130, 30, packs);
		//this.add(packKindField);
		
		//String[] deliveries = {"顺丰", "EMS", "圆通", "中通", "申通", "圆通", "韵达", "京东"};
		//deliveryKindField = new MyJComboBox(380, 100, 130, 30, deliveries);
		//this.add(deliveryKindField);
		
		//the table
				String[] headers = {"订单号","寄件人","快递类型","种类","费用","预计到达时间"};
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
								
				jsp.setBounds(10, 50, 610, 430);
				jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
				jsp.setOpaque(false);
				jsp.setBorder(BorderFactory.createEmptyBorder());
				jsp.setVisible(true);
				this.add(jsp);
	}
	private static final long serialVersionUID = 1L;

}
