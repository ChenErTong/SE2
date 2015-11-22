package ui.specialui.courier.receiveInput;

import ui.GetDate;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.specialui.courier.Frame_Courier;
/**
 * 收件信息输入界面
 * @author czw
 * @time 2015年11月19日下午7:32:41
 */
public class ReceiveInput extends MyJPanel{
	private static final long serialVersionUID = 1L;

	private OrderInfo orderInfo;
	private MyJTextField receiveName;
	private MyJTextField receiveDate;
	private MyJTextField checkBoard;
	
	public ReceiveInput(Frame_Courier frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(550, 30, 200, 45, "收件信息输入", 30, true));	
		this.add(new MyJLabel(155, 110, 100, 40, "订单号", 20, true));
		this.add(new MyJLabel(780, 210, 100, 30, "收件人姓名", 18, true));
		this.add(new MyJLabel(800, 270, 80, 30, "收件时间", 18, true));
		
		MyJButton checkOrderID = new MyJButton(490, 115, 60, 30, "查询", 20);
		this.add(checkOrderID);
		
		MyJButton confirm = new MyJButton(900, 330, 110, 40, "生成收件单", 18);
		confirm.setActionCommand("produceReceiveList");
		confirm.addActionListener(frame);
		this.add(confirm);
		
		orderInfo = new OrderInfo();
		this.add(orderInfo);
		
		checkBoard = new MyJTextField(230, 115, 250, 30);
		checkBoard.setOnlyInteger(10);
		this.add(checkBoard);
		
		receiveName = new MyJTextField(900, 210, 150, 30);
		this.add(receiveName);
		
		receiveDate = new MyJTextField(900, 270, 150, 30);
		receiveDate.setForTime();
		receiveDate.setText(GetDate.getTime());
		this.add(receiveDate);
		
		this.refresh();
	}
	
	public int produceReceiveList(){
		String name = receiveName.getText();
		String time = receiveDate.getText();
		if((name.equals(""))||(time.equals(""))){
			return 1;
		}
		return 0;
	}
	
	public void refresh(){
		checkBoard.setText(null);
		receiveName.setText(null);
		receiveDate.setText(GetDate.getTime());
		//TODO
		orderInfo.refresh();
	}
}