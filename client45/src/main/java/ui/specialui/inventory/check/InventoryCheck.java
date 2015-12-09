package ui.specialui.inventory.check;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import businesslogic.ControllerFactory;
import businesslogicservice.inventoryblservice.InventoryBLService;
import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;
import util.GetDate;
import vo.InventoryPositionVO;
import vo.InventoryViewVO;

public class InventoryCheck extends MyJPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField formerDate;
	private MyJTextField latterDate;
	private MyJTable inventoryInfo;
	private MyJTable commodityInfo;
	public InventoryCheck(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(576, 30, 128, 32, "库存查看", 30, true));
		
		this.add(new MyJLabel(430, 105, 57, 19, "时间段", 18, true));
		formerDate = new MyJTextField(500, 100, 130, 30);
		formerDate.setForDate();
		formerDate.setText(GetDate.getDate());
		this.add(formerDate);
		this.add(new MyJLabel(635, 112, 19, 19, "~", 18, true));
		latterDate = new MyJTextField(650, 100, 130, 30);
		latterDate.setForDate();
		latterDate.setText(GetDate.getDate());
		this.add(latterDate);
		
		inventoryInfo = new MyJTable(new String[]{"入库总数", "出库总数", "库存数量"}, false);
		this.add(new MyJScrollPane(415, 170, 450, 45, inventoryInfo));
		commodityInfo = new MyJTable(new String[]{"订单编号", "货物种类", "仓库存放位置"}, false);
		this.add(new MyJScrollPane(415, 215, 450, 450, commodityInfo));
		
		MyButton search = new MyButton(795, 96, 35, 35, LoginImage.getBUTTON_LOGISTIC());
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!InventoryCheck.this.searchWithinGap(frame)){
					new MyNotification(frame, "请正确输入时间", Color.RED);
				}
			}
		});
		this.add(search);
	}

	/**
	 * 搜索时间范围内的库存信息，时间输入正确返回true，错误返回false
	 * @return
	 */
	private boolean searchWithinGap(Frame_Inventory frame) {
		InventoryBLService inventoryController = ControllerFactory.getInventoryController();
		if((formerDate.getText().equals(""))||(latterDate.getText().equals(""))) return false;
		
		InventoryViewVO inventoryView = null;
		try {
			System.out.println(inventoryController == null);
			inventoryView = inventoryController.viewInventory(frame.getID().substring(0, 4), formerDate.getText(), latterDate.getText());
		} catch (RemoteException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);
			return true;
		}
		if(inventoryView == null) return false;
		
		String importNum = "";
		if(inventoryView.importReceipts != null){
			importNum = Integer.toString(inventoryView.importReceipts.size());
		}
		
		String exportNum = "";
		if(inventoryView.exportReceipts != null){
			exportNum = Integer.toString(inventoryView.exportReceipts.size());
		}
		
		String commodityNum = "";
		if(inventoryView.commodityInInventory != null){
			commodityNum = Integer.toString(inventoryView.commodityInInventory.size());
			for (InventoryPositionVO commodity : inventoryView.commodityInInventory) {
				String position = Integer.toString(commodity.area) + "区" + Integer.toString(commodity.row) + "排" + Integer.toString(commodity.frame) + "架" + Integer.toString(commodity.position) + "位";
				commodityInfo.addRow(new String[]{commodity.commodity.ID, commodity.commodity.commodityType, position});
			}
		}
		inventoryInfo.addRow(new String[]{importNum, exportNum, commodityNum});

		return true;		
	}
}