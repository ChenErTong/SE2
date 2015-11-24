package ui.specialui.transfer_counterman.transfer_receive;

import ui.GetDate;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class ArrivalCommodityInfo extends MyTranslucentPanel {
	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	private MyJComboBox commodityState;
	
	public ArrivalCommodityInfo() {
		super(460, 130, 340, 410);
		this.initComponent();
	}

	private void initComponent() {
		fields = new MyJTextField[5];
		this.add(new MyJLabel(88, 42, 57, 19, "订单号", 18, true));
		fields[0] = new MyJTextField(160, 40, 130, 30);
		fields[0].setOnlyInteger(9);
		
		this.add(new MyJLabel(88, 102, 57, 19, "出发地", 18, true));
		fields[1] = new MyJTextField(160, 100, 130, 30);
		
		this.add(new MyJLabel(31, 162, 114, 19, "中转中心编号", 18, true));
		fields[2] = new MyJTextField(160, 160, 130, 30);
		fields[2].setOnlyInteger(3);
		
		this.add(new MyJLabel(50, 222, 95, 19, "中转单编号", 18, true));
		fields[3] = new MyJTextField(160, 220, 130, 30);
		fields[3].setOnlyInteger(14);
		
		this.add(new MyJLabel(69, 342, 76, 19, "到达日期", 18, true));
		fields[4] = new MyJTextField(160, 340, 130, 30);
		fields[4].setForDate();
		fields[4].setText(GetDate.getDate());
		
		this.add(new MyJLabel(31, 282, 114, 19, "货物到达状态", 18, true));
		commodityState = new MyJComboBox(160, 280, 130, 30, new String[]{"完整", "损坏", "丢失"});
		this.add(commodityState);
		
		for (MyJTextField myJTextField : fields) {
			this.add(myJTextField);
		}
	}

	public String[] getData() {
		String[] data = new String[6];
		for(int i = 0; i < 5; i ++){
			if((data[i] = fields[i].getText()).equals("")) return null;
		}
		data[5] = (String) commodityState.getSelectedItem();
		return data;
	}
}
