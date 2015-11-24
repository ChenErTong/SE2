package ui.specialui.transfer_counterman.train_loading;

import ui.GetDate;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class TrainLoadingInfo extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	
	public TrainLoadingInfo() {
		super(470, 110, 340, 455);
		this.initComponent();
	}

	private void initComponent() {
		fields = new MyJTextField[7];
		this.add(new MyJLabel(55, 42, 92, 23, "货运编号", 18, true));
		fields[0] = new MyJTextField(150, 40, 130, 30);
		fields[0].setOnlyInteger(10);
		
		this.add(new MyJLabel(78, 102, 69, 23, "车次号", 18, true));
		fields[1] = new MyJTextField(150, 100, 130, 30);
		
		this.add(new MyJLabel(78, 162, 69, 23, "车厢号", 18, true));
		fields[2] = new MyJTextField(150, 160, 130, 30);
		
		this.add(new MyJLabel(78, 222, 69, 23, "出发地", 18, true));
		fields[3] = new MyJTextField(150, 220, 130, 30);
		
		this.add(new MyJLabel(78, 282, 69, 23, "目的地", 18, true));
		fields[4] = new MyJTextField(150, 280, 130, 30);
		
		this.add(new MyJLabel(55, 342, 92, 23, "装运日期", 18, true));
		fields[5] = new MyJTextField(150, 340, 130, 30);
		fields[5].setForDate();
		fields[5].setText(GetDate.getDate());
		
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
