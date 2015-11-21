package ui.specialui.branch_conuterman.vehicleloading;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyFont;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.specialui.branch_conuterman.Frame_Branch;

public class VehicleLoading extends MyJPanel {
	private static final long serialVersionUID = 1L;
	private LoadingInfo loadingInfo;

	public VehicleLoading(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		this.add(new MyJLabel(550, 30, 210, 45, "车辆装车管理", 30, true));

		loadingInfo = new LoadingInfo();
		this.add(loadingInfo);

		this.add(new MyJLabel(820, 100, 210, 40, "订单编号", 22, true));
		// the table
		String[] orderId = this.getOrderId();
		MyJTable	table = new MyJTable(orderId, false);
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setFont(new MyFont(14));

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);

		JScrollPane jsp = new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setFont(new MyFont(14));
		head.setForeground(Color.BLACK);
		head.setResizingAllowed(false);

		jsp.setBounds(690, 150, 340, 370);
		jsp.getViewport().setBackground(new Color(0, 0, 0, 0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
	}
	/**
	 * 从bl层得到订单编号
	 * @return
	 */
	private String[] getOrderId(){
		return new String[]{};
	}
}
