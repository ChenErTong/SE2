package ui.specialui.inventory.import_;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;

public class CargoImport extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJComboBox[] position;
	private MyJTable commodities;
	private MyJTable importList;
	
	public CargoImport(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(608, 30, 64, 32, "入库", 30, true));
		
		commodities = new MyJTable(new String[]{"中转接收单编号", "订单编号"}, false);
		//设置为只可单选
		commodities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new MyJScrollPane(200, 150, 300, 370, commodities));
		this.add(new MyJLabel(310, 110, 80, 19, "入库货物", 18, true));
		
		importList = new MyJTable(new String[]{"入库单编号", "订单编号", "入库日期", "目的地", "仓库存放位置"}, false);
		this.add(new MyJScrollPane(600, 150, 480, 370, importList));
		this.add(new MyJLabel(790, 110, 100, 19, "入库单列表", 18, true));
		
		this.add(new MyJLabel(200, 550, 19, 19, "区", 18, true));	
		this.add(new MyJLabel(279, 550, 19, 19, "排", 18, true));
		this.add(new MyJLabel(358, 550, 19, 19, "架", 18, true));
		this.add(new MyJLabel(437, 550, 19, 19, "位", 18, true));
		
		position = new MyJComboBox[4];
		String[][] blankPos = this.getBlankPos();
		for(int i = 0; i < 4; i ++){
			position[i] = new MyJComboBox(221 + i * 79, 550, 42, 18, blankPos[i]);
			this.add(position[i]);
		}
		
		MyJButton produceImportList = new MyJButton(580, 600, 120, 30, "生成入库单", 20);
		produceImportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CargoImport.this.produceImportList()){
					String[][] blankPos = CargoImport.this.getBlankPos();
					for(int i = 0; i < 4; i ++){
						position[i].reset(blankPos[i]);
					}
				}else{
					new MyNotification(frame, "请选择一件订单", Color.RED);
				}		
			}
		});
		this.add(produceImportList);
	}
	
	private boolean produceImportList(){
		int row = commodities.getSelectedRow();
		if(row == -1) return false;
		//TODO 根据选中的订单信息生成入库单
		
		commodities.removeRow();
		return true;
	}
	
	private String[][] getBlankPos(){
		String[][] blankPos = new String[4][];
		//TODO 根据仓库信息返回仓库空位
		for(int i = 0; i < 4; i ++){
			blankPos[i] = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		}
		return blankPos;
	}
}