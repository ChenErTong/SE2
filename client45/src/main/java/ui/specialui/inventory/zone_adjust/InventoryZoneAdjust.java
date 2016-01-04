package ui.specialui.inventory.zone_adjust;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

import ui.image.InventoryImage;
import ui.myui.MyButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.inventory.Frame_Inventory;
import vo.InventoryPositionVO;
import businesslogic.ControllerFactory;
import businesslogicservice.inventoryblservice.InventoryBLService;
/**
 * 仓库库存调整界面
 * @author czw
 * @time 2015年11月25日下午6:54:32
 */
public class InventoryZoneAdjust extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJComboBox position;
	private MyJTable importList;
	
	private InventoryBLService inventoryController;
	//仓库空余位置
	private ArrayList<InventoryPositionVO> posVOs;
	
	public InventoryZoneAdjust(Frame_Inventory frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		try {
			inventoryController  = ControllerFactory.getInventoryController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		this.add(new MyJLabel(544, 30, 192, 32, "库存分区调整", 30, true));
		
		importList = new MyJTable(new String[]{"订单编号", "货物种类", "货物状态", "仓库存放位置"}, false, this);
		importList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new MyJScrollPane(390, 150, 480, 370, importList));
		this.add(new MyJLabel(590, 110, 100, 19, "入库单列表", 18, true));
		this.setImportList(frame);
		
		this.add(new MyJLabel(515, 550, 76, 19, "可用位置", 18, true));	
		
		position = new MyJComboBox(605, 547, 142, 25, null);
		this.add(position);
		this.setBlankPos(frame);
		
		MyButton modifyImportList = new MyButton(584, 600, 111, 33, InventoryImage.getBUTTON_TIAOZHENG());
		modifyImportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = InventoryZoneAdjust.this.modifyImportList(frame);
				if(result == 0){
					new MyNotification(frame, "订单分区调整成功", Color.GREEN);
				}else if(result == 1){
					new MyNotification(frame, "请选择一件订单", Color.RED);
				}
			}
		});
		this.add(modifyImportList);
	}
	
	/**
	 * 得到仓库空余位置
	 * @param frame
	 */
	private void setBlankPos(Frame_Inventory frame) {
	//	if(inventoryController == null) return;
		
		try {
			inventoryController = ControllerFactory.getInventoryController();
			posVOs = inventoryController.getEmptyPositionsInList(frame.getID().substring(0, 6));
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		if(posVOs != null){
			String posInfo = null;
			for (InventoryPositionVO posVO : posVOs) {
				posInfo = Integer.toString(posVO.area + 1) + "区" + Integer.toString(posVO.row + 1) + "排" + Integer.toString(posVO.frame + 1) + "架" + Integer.toString(posVO.position + 1) + "位";
				position.addItem(posInfo);	
			}
		}
	}

	/**
	 * 设置仓库中货物列表
	 */
	private void setImportList(Frame_Inventory frame){
		ArrayList<InventoryPositionVO> commoditiesExisted;
		try {
			inventoryController = ControllerFactory.getInventoryController();
			commoditiesExisted = inventoryController.getCommoditiesInInventory(frame.getID().substring(0, 6));
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		if(commoditiesExisted != null){
			String pos = null;
			for (InventoryPositionVO inventoryPositionVO : commoditiesExisted) {
				pos = Integer.toString(inventoryPositionVO.area + 1) + "区" + Integer.toString(inventoryPositionVO.row + 1) + "排" + Integer.toString(inventoryPositionVO.frame + 1) + "架" + Integer.toString(inventoryPositionVO.position + 1) + "位";
				importList.addRow(new String[]{inventoryPositionVO.commodity.orderID, inventoryPositionVO.commodity.commodityType, inventoryPositionVO.commodity.commodityState.value, pos});
			}
		}
	}
	
	/**
	 * 调整分区
	 * @param frame
	 * @return
	 */
	private int modifyImportList(Frame_Inventory frame) {
		int rowOfImport = importList.getSelectedRow();
		if(rowOfImport == -1) return 1;
		String[] commodity = importList.getData(rowOfImport);
		String expos = commodity[3];
		//得到货物当前位置
		int posBefore[] = new int[4];
		for (int i = 0; i < 4; i++) {
			posBefore[i] = expos.charAt(i * 2) - '0';
		}
		//得到货物将要移动的位置
		int rowOfPos = position.getSelectedIndex();
		InventoryPositionVO afpos = posVOs.get(rowOfPos);
		String afpos_string = position.getItemAt(rowOfPos);
		try {
			inventoryController.adjust(frame.getID().substring(0, 6), posBefore[0], posBefore[1], posBefore[2], posBefore[3], afpos.area, afpos.row, afpos.frame, afpos.position);
		} catch (RemoteException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return 2;
		}
		
		//调整位置下拉框中选项
		position.removeItemAt(rowOfPos);
		position.addItem(commodity[3]);
		
		//将新位置从货物空位中删除
		posVOs.remove(rowOfPos);
		//将旧位置加入货物空位
		afpos.area = posBefore[0];
		afpos.row = posBefore[1];
		afpos.frame = posBefore[2];
		afpos.position = posBefore[3];
		posVOs.add(afpos);
		//调整货物列表中的项
		importList.removeRow();
		importList.addRow(new String[]{commodity[0], commodity[1], commodity[2], afpos_string});
		this.repaint();
		return 0;
	}
}