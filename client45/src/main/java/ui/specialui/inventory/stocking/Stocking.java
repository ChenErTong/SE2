package ui.specialui.inventory.stocking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;
import ui.specialui.inventory.import_.CargoImport;

public class Stocking extends MyJPanel {
	private static final long serialVersionUID = 1L;

	//前一截止点
	private MyJLabel formerPoint;
	private MyJTable inventoryCondition;
	
	public Stocking(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(576, 30, 128, 32, "库存盘点", 30, true));
		
		this.add(new MyJLabel(415, 128, 105, 19, "前一截止点:", 18, true));
		formerPoint = new MyJLabel(525, 128, 110, 19, this.getFormerPoint(), 18, true);
		this.add(formerPoint);
		inventoryCondition = new MyJTable(new String[]{"订单编号", "入库日期", "目的地", "仓库存放位置"}, false);
		this.add(new MyJScrollPane(415, 150, 450, 410, inventoryCondition));
	
		MyJButton refresh = new MyJButton(765, 126, 100, 20, "刷新状态", 18);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stocking.this.refreshCondition();
				new MyNotification(frame, "刷新成功", Color.GREEN);
			}
		});
		this.add(refresh);
		
		MyJButton stocking = new MyJButton(580, 600, 120, 30, "盘点", 20);
		stocking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Stocking.this.snapshot()){
					new MyNotification(frame, "盘点成功", Color.GREEN);
				}else{
					MyNotification notification = new MyNotification(frame, "仓库库存高于预警值\n点击提示板进行库存分区调整", Color.RED);
					notification.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e){
							frame.toAdjustZone();
							notification.dispose();
						}		
					});;
				}
			}
		});
		this.add(stocking);
	}
	
	/**
	 * 进行库存快照，若成功返回true，若库存高于预警值则返回false
	 * 需要导出到excel表
	 * @return
	 */
	private boolean snapshot() {
		
		return false;
	}

	/**
	 * TODO 刷新前一截止点与仓库信息
	 */
	private void refreshCondition() {
		formerPoint.setText(this.getFormerPoint());
		//TODO 刷新仓库信息
	}
	
	//TODO 得到前一截止点，若无则返回无
	private String getFormerPoint() {	
		String point = "20151125011";
		return point;
	}
}
