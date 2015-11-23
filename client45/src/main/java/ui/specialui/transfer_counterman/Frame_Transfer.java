package ui.specialui.transfer_counterman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.specialui.inventory.Frame_Inventory;
import ui.specialui.transfer_counterman.car_loading.CarLoading;
import ui.specialui.transfer_counterman.plane_loading.PlaneLoading;
import ui.specialui.transfer_counterman.train_loading.TrainLoading;
import ui.specialui.transfer_counterman.transfer_receive.TransferReceiveManage;
/**
 * 中转中心业务员界面
 * @author czw
 * @time 2015年11月23日上午10:08:48
 */
public class Frame_Transfer extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Panel_Transfer_Total totalPanel;
	private MyJPanel subPanel;
	
	public Frame_Transfer() {
		this.totalPanel = new Panel_Transfer_Total(this);
		this.add(totalPanel);
		
		this.returnButton.addActionListener(this);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}
	
	public Frame_Transfer(boolean isGradualSetup) {
		super(false);
		
		this.totalPanel = new Panel_Transfer_Total(this);
		this.add(totalPanel);
		
		this.returnButton.addActionListener(this);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			//回退到主界面
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
			}
		}else if(e.getActionCommand().equals("CarLoading")){
			//进入汽车装运管理界面
			totalPanel.setVisible(false);
			subPanel = new CarLoading(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("TrainLoading")){
			//进入火车装运管理界面
			totalPanel.setVisible(false);
			subPanel = new TrainLoading(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("PlaneLoading")){
			//进入飞机装运管理界面
			totalPanel.setVisible(false);
			subPanel = new PlaneLoading(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("TransferReceiveManage")){
			//进入中转接收管理界面
			totalPanel.setVisible(false);
			subPanel = new TransferReceiveManage(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("InventoryManage")){
			//进入仓库管理界面
			new Frame_Inventory();
			this.removeAll();
			this.dispose();
		}
	}
}