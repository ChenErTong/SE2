package ui.specialui.transfer_counterman.plane_loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
import util.GetDate;

public class PlaneLoadingInfo extends MyTranslucentPanel {
	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	
	public PlaneLoadingInfo() {
		super(470, 110, 340, 455);
		this.initComponent();
	}

	private void initComponent() {
		fields = new MyJTextField[7];
		this.add(new MyJLabel(55, 42, 92, 23, "航运编号", 18, true));
		fields[0] = new MyJTextField(150, 40, 130, 30);
		fields[0].setOnlyInteger(10);
		fields[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[0]){
					fields[1].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(78, 102, 69, 23, "航班号", 18, true));
		fields[1] = new MyJTextField(150, 100, 130, 30);
		fields[1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[1]){
					fields[2].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(78, 162, 69, 23, "货柜号", 18, true));
		fields[2] = new MyJTextField(150, 160, 130, 30);
		fields[2].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[2]){
					fields[3].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(78, 222, 69, 23, "出发地", 18, true));
		fields[3] = new MyJTextField(150, 220, 130, 30);
		fields[3].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[3]){
					fields[4].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(78, 282, 69, 23, "目的地", 18, true));
		fields[4] = new MyJTextField(150, 280, 130, 30);
		fields[4].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[4]){
					fields[5].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(55, 342, 92, 23, "装运日期", 18, true));
		fields[5] = new MyJTextField(150, 340, 130, 30);
		fields[5].setForDate();
		fields[5].setText(GetDate.getDate());
		fields[5].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[5]){
					fields[6].requestFocus();
				}
				
			}
			
		});
		
		this.add(new MyJLabel(78, 402, 69, 23, "监装员", 18, true));
		fields[6] = new MyJTextField(150, 400, 130, 30);

		for (MyJTextField myJTextField : fields) {
			this.add(myJTextField);
		}	
	}
	/**
	 * 得到所有数据
	 * @return
	 */
	public String[] getData() {
		String[] data = new String[7];
		for (int i = 0; i < 7; i++) {
			if((data[i] = fields[i].getText()).equals("")) return null;			
		}
		return data;
	}
}