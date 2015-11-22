package ui.specialui.branch_conuterman.receiveAndSendCommodity;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.branch_conuterman.Frame_Branch;
/**
 * 派发货物界面
 * @author czw
 * @time 2015年11月22日下午2:20:58
 */
public class SendCommodity extends MyJPanel{
	private static final long serialVersionUID = 1L;
	
	private MyJComboBox courier;
	
	public SendCommodity(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
	
		this.add(new MyJLabel(550, 30, 210, 45, "接收派件货物", 30, true));
		this.add(new MyJLabel(620, 100, 69, 23, "到达单", 18, true));
		
		MyEmptyTextArea arrivalList = new MyEmptyTextArea(390, 100, 500, 450);
		this.add(arrivalList);
		this.add(new MyJLabel(520, 580, 115, 23, "可选快递员", 18, true));
		//快递员
		String[] couriers = new String[]{"刘钦"};
		courier = new MyJComboBox(650, 575, 115, 30, couriers);	
		this.add(courier);
		
		MyJButton produceDeliveryList = new MyJButton(583, 630, 115, 23,
				"生成派件单", 18);
		produceDeliveryList.setActionCommand("produceDeliveryList");
		produceDeliveryList.addActionListener(frame);
		this.add(produceDeliveryList);
	}

	/**
	 * 生成派件单，若未选择快递员则返回1
	 * @return
	 */
	public int produceDeliveryList() {
		String courierName = (String) courier.getSelectedItem();
		if(courierName == null){
			return 1;
		}
		return 0;
	}
}