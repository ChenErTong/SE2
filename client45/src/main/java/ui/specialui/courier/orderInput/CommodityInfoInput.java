package ui.specialui.courier.orderInput;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import ui.NumberLenghtLimited;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJList;
import ui.myui.MyJRadioButton;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class CommodityInfoInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField commodityNumField;
	private MyJTextField commodityVolumnField;
	private MyJTextField commodityWeightField;
	private MyJComboBox packKindField;
	private MyJComboBox deliveryKindField;
	private MyJRadioButton choseCompareWeight;
	private DefaultListModel<String> commodities;
	
	public CommodityInfoInput() {
		super(620, 100, 550, 510);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(215, 30, 140, 40, "托运货物信息", 22, true));
		this.add(new MyJLabel(50, 104, 80, 20, "原件数/件", 15, true));
		this.add(new MyJLabel(190, 104, 120, 20, "实际体积/m^3", 15, true));
		this.add(new MyJLabel(360, 104, 120, 20, "实际重量/kg", 15, true));
		this.add(new MyJLabel(50, 150, 80, 20, "包装类型", 15, true));
		this.add(new MyJLabel(300, 150, 80, 20, "快递类型", 15, true));
		this.add(new MyJLabel(50, 250, 80, 20, "货物名", 15, true));
		this.add(new MyJLabel(290, 250, 80, 20, "货物种类", 15, true));
		
		commodityNumField = new MyJTextField(130, 100, 50, 30);
		commodityNumField.setDocument(new NumberLenghtLimited(3));
		this.add(commodityNumField);
		
		commodityVolumnField = new MyJTextField(300, 100, 50, 30);
		commodityVolumnField.setDocument(new NumberLenghtLimited(3));
		this.add(commodityVolumnField);
		
		commodityWeightField = new MyJTextField(460, 100, 50, 30);
		commodityWeightField.setDocument(new NumberLenghtLimited(4));
		this.add(commodityWeightField);
		
		String[] packs = {"纸盒", "塑料", "泡沫", "金属"};
		packKindField = new MyJComboBox(130, 150, 130, 30, packs);
		this.add(packKindField);
		
		String[] deliveries = {"顺丰", "EMS", "圆通", "中通", "申通", "圆通", "韵达", "京东"};
		deliveryKindField = new MyJComboBox(380, 150, 130, 30, deliveries);
		this.add(deliveryKindField);
		
		choseCompareWeight = new MyJRadioButton(50, 200, 180, 20, "是否进行重量矫正");
		this.add(choseCompareWeight);
		
		MyJTextField commodityNameField = new MyJTextField(110, 250, 150, 30);
		this.add(commodityNameField);
		
		MyJTextField commodityKindField = new MyJTextField(360, 250, 150, 30);
		this.add(commodityKindField);
				
		commodities = new DefaultListModel<String>();
		MyJList commodityList = new MyJList(50, 345, 460, 130);
		this.add(new JScrollPane(commodityList), BorderLayout.CENTER);
		this.add(commodityList);
		
		MyJButton addCommodity = new MyJButton(50, 300, 110, 20, "添加货物", 15);
		addCommodity.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String commodityName = commodityNameField.getText();
				String commodityKind = commodityKindField.getText();
				if((!commodityName.equals(""))&&(!commodityKind.equals(""))){
					String commodity = commodityName + "/" + commodityKind;
					commodities.addElement(commodity);
					commodityList.setModel(commodities);
					commodityNameField.setText(null);
					commodityKindField.setText(null);
				}else{		
					
				}
			}
		});
		this.add(addCommodity);
		
		MyJButton deleteCommodity = new MyJButton(180, 300, 110, 20, "删除选中货物", 15);
		deleteCommodity.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				int[] listNum = commodityList.getSelectedIndices();
				int j = 0;
				for (int i : listNum) {
					commodities.remove(i - j);
					j ++;
				}
				commodityList.setModel(commodities);
			}
		});
		this.add(deleteCommodity);
		
		MyJButton clearCommodity = new MyJButton(310, 300, 110, 20, "清空货物", 15);
		clearCommodity.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				commodities.clear();
				commodityList.setModel(commodities);
			}
		});
		this.add(clearCommodity);
	}

	public String[] getCommodityInfo() {
		String[] info = new String[5];
		info[0] = commodityNumField.getText();
		info[1] = commodityVolumnField.getText();
		info[2] = commodityWeightField.getText();
		info[3] = (String) packKindField.getSelectedItem();
		info[4] = (String) deliveryKindField.getSelectedItem();
		for (String string : info) {
			if(string.equals("")) return null;
		}
		return info;
	}

	/**
	 * @return 是否比较实际重量与计算重量
	 */
	public boolean isCompareWight() {
		return choseCompareWeight.isSelected();
	}

	public String[] getCommodityList() {
		if(commodities.isEmpty()){
			return null;
		}else{
			int size = commodities.size();
			String[] commodityList = new String[size];
			for(int i = 0; i < size; i++){
				commodityList[i] = commodities.getElementAt(i);
			}
			return commodityList;
		}
	}
}