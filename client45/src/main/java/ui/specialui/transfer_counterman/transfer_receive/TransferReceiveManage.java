package ui.specialui.transfer_counterman.transfer_receive;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.transfer_counterman.Frame_Transfer;
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
		
		MyJButton produceArrivalList = new MyJButton(565, 600, 150, 30, "生成到达单", 20);
		produceArrivalList.setActionCommand("produceArrivalList");
		produceArrivalList.addActionListener(frame);
		this.add(produceArrivalList);
	}

	public boolean produceArrivalList() {
		String[] data = arrivalCommodity.getData();
		if(data == null) return false;
		//TODO
		//到达单生成步骤
		
		return true;
	}
}