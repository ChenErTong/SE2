package ui.specialui.inventory.zone_adjust;

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
/**
 * 仓库库存调整界面
 * @author czw
 * @time 2015年11月25日下午6:54:32
 */
public class InventoryZoneAdjust extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJComboBox[] position;
	private MyJTable importList;
	
	public InventoryZoneAdjust(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(544, 30, 192, 32, "库存分区调整", 30, true));
		
		importList = new MyJTable(new String[]{"入库单编号", "订单编号", "入库日期", "目的地", "仓库存放位置"}, false);
		importList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new MyJScrollPane(390, 150, 480, 370, importList));
		this.add(new MyJLabel(590, 110, 100, 19, "入库单列表", 18, true));
		
		this.add(new MyJLabel(480, 550, 19, 19, "区", 18, true));	
		this.add(new MyJLabel(559, 550, 19, 19, "排", 18, true));
		this.add(new MyJLabel(638, 550, 19, 19, "架", 18, true));
		this.add(new MyJLabel(717, 550, 19, 19, "位", 18, true));
		
		position = new MyJComboBox[4];
		String[][] blankPos = this.getBlankPos();
		for(int i = 0; i < 4; i ++){
			position[i] = new MyJComboBox(501 + i * 79, 550, 42, 18, blankPos[i]);
			this.add(position[i]);
		}
		
		MyJButton modifyImportList = new MyJButton(575, 600, 120, 30, "确认调整", 20);
		modifyImportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(InventoryZoneAdjust.this.modifyImportList()){
					//TODO
				}else{
					new MyNotification(frame, "请选择一件订单", Color.RED);
				}		
			}
		});
		this.add(modifyImportList);
	}
	
	private boolean modifyImportList() {
		int row = importList.getSelectedRow();
		if(row == -1) return false;
		//TODO 根据选中的订单修改后存入入库单
		
		importList.removeRow();
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