package ui.specialui.transfer_counterman.transfer_receive;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import state.CommodityState;
import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.transfer_counterman.Frame_Transfer;
import businesslogic.ControllerFactory;
import businesslogicservice.transferblservice.TransferBLService;
/**
 * 中转接收管理界面
 * @author czw
 * @time 2015年11月24日下午8:35:51
 */
public class TransferReceiveManage extends MyJPanel{
	private static final long serialVersionUID = 1L;

	private ArrivalCommodityInfo arrivalCommodity;
	
	public TransferReceiveManage(Frame_Transfer frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(544, 30, 192, 32, "中转接收管理", 30, true));
		
		arrivalCommodity = new ArrivalCommodityInfo();
		this.add(arrivalCommodity);
		
		MyButton produceArrivalList = new MyButton(584, 600, 111, 33, TransferImage.getBUTTON_DAODADAN());
		produceArrivalList.setActionCommand("produceArrivalList");
		produceArrivalList.addActionListener(frame);
		this.add(produceArrivalList);
	}

	public int produceArrivalList(Frame_Transfer frame) {
		String[] data = arrivalCommodity.getData();
		if(data == null) return 1;

		TransferBLService transferController;
		try {
			transferController = ControllerFactory.getTransferController();
			transferController.receiptList(frame.getID().substring(0, 4), data[1], data[2], CommodityState.getType(data[6]), data[0]);
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return -1;
		}

		return 0;
	}

	public void refresh() {
		arrivalCommodity.refresh();
	}
}