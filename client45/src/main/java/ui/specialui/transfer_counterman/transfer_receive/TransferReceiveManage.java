package ui.specialui.transfer_counterman.transfer_receive;

import state.CommodityState;
import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.transfer_counterman.Frame_Transfer;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
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

	public boolean produceArrivalList(Frame_Transfer frame) {
		String[] data = arrivalCommodity.getData();
		if(data == null) return false;
		//TODO
		//到达单生成步骤
		TransferBLService transferController = ControllerFactory.getTransferController();
		/*ArrayList<String> order = new ArrayList<String>();
		order.add(data[0]);*/
		/**
		 * 我把这里的接口改成单个commodity了
		 * @author Ann
		 */
		TransferArrivalListVO arrivalList = transferController.receiptList(frame.getID().substring(0, 4), data[1], data[2], CommodityState.getType(data[6]), data[0]);
		transferController.save(arrivalList);
		transferController.submit(arrivalList);
		return true;
	}

	public void refresh() {
		arrivalCommodity.refresh();
	}
}