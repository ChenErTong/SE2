package ui.specialui.courier.orderInput;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;

import ui.NumberLenghtLimited;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJList;
import ui.myui.MyJRadioButton;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
import ui.specialui.courier.Frame_Courier;

public class CommodityInfoInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	public CommodityInfoInput(Frame_Courier frame) {
		super(620, 100, 550, 510);
		this.initComponent(frame);
	}

	private void initComponent(Frame_Courier frame) {
		MyJLabel Info = new MyJLabel(215, 30, 140, 40, "托运货物信息", 22, true);
		this.add(Info);
		
		MyJLabel commodityNum = new MyJLabel(50, 104, 80, 20, "原件数/件", 15, true);
		this.add(commodityNum);
		MyJTextField commodityNumField = new MyJTextField(130, 100, 50, 30);
		commodityNumField.setDocument(new NumberLenghtLimited(3));
		this.add(commodityNumField);
		
		MyJLabel commodityVolumn = new MyJLabel(190, 104, 120, 20, "实际体积/m^3", 15, true);
		this.add(commodityVolumn);
		MyJTextField commodityVolumnField = new MyJTextField(300, 100, 50, 30);
		commodityVolumnField.setDocument(new NumberLenghtLimited(3));
		this.add(commodityVolumnField);
		
		MyJLabel commodityWeight = new MyJLabel(360, 104, 120, 20, "实际重量/kg", 15, true);
		this.add(commodityWeight);
		MyJTextField commodityWeightField = new MyJTextField(460, 100, 50, 30);
		commodityWeightField.setDocument(new NumberLenghtLimited(4));
		this.add(commodityWeightField);
		
		MyJLabel packKind = new MyJLabel(50, 150, 80, 20, "包装类型", 15, true);
		this.add(packKind);
		String[] packs = {"纸盒", "塑料", "泡沫", "金属"};
		MyJComboBox packKindField = new MyJComboBox(130, 150, 130, 30, packs);
		this.add(packKindField);
		
		MyJLabel deliveryKind = new MyJLabel(300, 150, 80, 20, "快递类型", 15, true);
		this.add(deliveryKind);
		String[] deliveries = {"顺丰", "EMS", "圆通", "中通", "申通", "圆通", "韵达", "京东"};
		MyJComboBox deliveryKindField = new MyJComboBox(380, 150, 130, 30, deliveries);
		this.add(deliveryKindField);
		
		MyJRadioButton choseCompareWeight = new MyJRadioButton(50, 200, 180, 20, "是否进行重量矫正");
		this.add(choseCompareWeight);
		
		MyJLabel commodityName = new MyJLabel(50, 250, 80, 20, "货物名", 15, true);
		this.add(commodityName);
		MyJTextField commodityNameField = new MyJTextField(110, 250, 150, 30);
		this.add(commodityNameField);
		
		MyJLabel commodityKind = new MyJLabel(290, 250, 80, 20, "货物种类", 15, true);
		this.add(commodityKind);
		MyJTextField commodityKindField = new MyJTextField(360, 250, 150, 30);
		this.add(commodityKindField);
		
		MyJButton addCommodity = new MyJButton(50, 300, 100, 20, "添加到条目", 15);
		this.add(addCommodity);
		
		Vector<String> commodities = new Vector<String>();
		commodities.add("sd");
		MyJList commodityList = new MyJList(50, 345, 460, 130, commodities);
		this.add(new JScrollPane(commodityList), BorderLayout.CENTER);
		this.add(commodityList);
	}
}