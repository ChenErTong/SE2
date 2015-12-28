package ui.specialui.transfer_counterman.transfer_receive;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
import util.GetDate;

public class ArrivalCommodityInfo extends MyTranslucentPanel {
	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	private MyJComboBox commodityState;
	
	public ArrivalCommodityInfo() {
		super(460, 110, 340, 470);
		this.initComponent();
	}

	private void initComponent() {
		fields = new MyJTextField[6];
		this.add(new MyJLabel(88, 42, 57, 19, "订单号", 18, true));
		fields[0] = new MyJTextField(160, 40, 130, 30);
		fields[0].setOnlyInteger(10);
		fields[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[0]){
					fields[1].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(88, 102, 57, 19, "出发地", 18, true));
		fields[1] = new MyJTextField(160, 100, 130, 30);
		fields[1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[1]){
					fields[2].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(88, 162, 57, 19, "目的地", 18, true));
		fields[2] = new MyJTextField(160, 160, 130, 30);
		fields[2].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[2]){
					fields[3].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(31, 222, 114, 19, "中转中心编号", 18, true));
		fields[3] = new MyJTextField(160, 220, 130, 30);
		fields[3].setOnlyInteger(4);
		fields[3].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[3]){
					fields[4].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(50, 282, 95, 19, "中转单编号", 18, true));
		fields[4] = new MyJTextField(160, 280, 130, 30);
		fields[4].setOnlyInteger(14);
		fields[4].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[4]){
					fields[5].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(69, 402, 76, 19, "到达日期", 18, true));
		fields[5] = new MyJTextField(160, 400, 130, 30);
		fields[5].setForDate();
		fields[5].setText(GetDate.getDate());
		
		this.add(new MyJLabel(31, 342, 114, 19, "货物到达状态", 18, true));
		commodityState = new MyJComboBox(160, 340, 130, 30, new String[]{"完整", "损坏", "丢失"});
		this.add(commodityState);
		
		for (MyJTextField myJTextField : fields) {
			this.add(myJTextField);
		}
	}

	public String[] getData() {
		String[] data = new String[7];
		for(int i = 0; i < 6; i ++){
			if((data[i] = fields[i].getText()).equals("")) return null;
		}
		data[6] = (String) commodityState.getSelectedItem();
		return data;
	}

	public void refresh() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
		commodityState.setSelectedIndex(0);
	}
}
