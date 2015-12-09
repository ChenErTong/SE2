package ui.specialui.courier.receiveInput;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.courier.Frame_Courier;
import util.GetDate;
import vo.CommodityVO;
import vo.OrderVO;
import vo.accountvo.AccountVO;
import businesslogic.ControllerFactory;
import businesslogicservice.accountblservice.AccountBLService;
import businesslogicservice.orderblservice.OrderBLService;
/**
 * 收件信息输入界面
 * @author czw
 * @time 2015年11月19日下午7:32:41
 */
public class ReceiveInput extends MyJPanel{
	private static final long serialVersionUID = 1L;

	private MyEmptyTextArea orderInfo;
	private MyJTextField receiveName;
	private MyJTextField receiveDate;
	private MyJTextField checkBoard;
	//逻辑接口
	private OrderBLService controller;
	private OrderVO order;
	
	public ReceiveInput(Frame_Courier frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		controller = ControllerFactory.getOrderController();
		order = null;
		
		this.add(new MyJLabel(550, 30, 200, 45, "收件信息输入", 30, true));	
		this.add(new MyJLabel(155, 110, 100, 40, "订单号", 20, true));
		this.add(new MyJLabel(780, 210, 100, 30, "收件人姓名", 18, true));
		this.add(new MyJLabel(800, 270, 80, 30, "收件时间", 18, true));
		this.add(new MyJLabel(310, 165, 114, 19, "单据详细信息", 18, true));
		
		orderInfo = new MyEmptyTextArea(110, 190, 500, 480);
		this.add(orderInfo);
		
		checkBoard = new MyJTextField(230, 115, 250, 30);
		checkBoard.setOnlyInteger(10);
		checkBoard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==checkBoard){
					receiveName.requestFocus();
				}
				
			}
			
		});
		this.add(checkBoard);
		
		receiveName = new MyJTextField(900, 210, 150, 30);
		receiveName.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				receiveDate.requestFocus();
			}
			
		});
		this.add(receiveName);
		
		receiveDate = new MyJTextField(900, 270, 150, 30);
		receiveDate.setForTime();
		receiveDate.setText(GetDate.getTime());
		this.add(receiveDate);
		
		MyJButton checkOrderID = new MyJButton(490, 115, 60, 30, "查询", 20);
		checkOrderID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ReceiveInput.this.searchOrder(checkBoard.getText())){
					new MyNotification(ReceiveInput.this, "不存在该订单号", Color.RED);
				}else{
					checkBoard.setText(null);
				}
			}
		});
		this.add(checkOrderID);
		
		MyJButton confirm = new MyJButton(900, 330, 110, 40, "生成收件单", 18);
		confirm.setActionCommand("produceReceiveList");
		confirm.addActionListener(frame);
		this.add(confirm);
		
		this.refresh();
	}
	
	/**
	 * 查询订单
	 * @param 订单号
	 * @return 是否查询到订单
	 */
	private boolean searchOrder(String orderID) {
		OrderBLService orderController = ControllerFactory.getOrderController();
		order = orderController.inquireOrder(orderID);
		
		if(order == null) return false;
		
		this.setOrderInfo();
		return true;
	}

	/**
	 * 向订单信息界面生成订单信息
	 * @param order
	 */
	private void setOrderInfo() {
		orderInfo.setText("订单编号" + order.ID + "\n");
		orderInfo.append("寄件人信息：\n");
		orderInfo.append("姓名：" + order.senderName + "\t");
		orderInfo.append("电话：" + order.senderTel + "\n");
		orderInfo.append("住址：" + order.senderAddress + "\n");
		orderInfo.append("单位：" + order.senderCo + "\n");
		orderInfo.append("收件人信息：\n");
		orderInfo.append("姓名：" + order.recipientName + "\t");
		orderInfo.append("电话：" + order.recipientTel + "\n");
		orderInfo.append("住址：" + order.recipientAddress + "\n");
		orderInfo.append("单位：" + order.recipientCo + "\n");
		orderInfo.append("货物信息：\n");	
		for(CommodityVO commodity: order.commodities){
			orderInfo.append(commodity.commodityType + "\t" + commodity.volumn + "m³\t" + commodity.weight + "kg\n");	
		}
		orderInfo.append("快递类型：" + order.express.value + "\t包装方式：" + order.packType.value + "\n");
		orderInfo.append("寄件日期：" + order.sendTime + "\t运费：" + order.money);
	}
	
	public int produceReceiveList(Frame_Courier frame_Courier){
		String name = receiveName.getText();
		String time = receiveDate.getText();
		if((name.equals(""))||(time.equals(""))){
			return 1;
		}
		if(orderInfo.getText().equals("")){
			return 2;
		}
		AccountBLService accountController = ControllerFactory.getAccountController();

		AccountVO account = accountController.find(frame_Courier.getID());
		account.ordersID.add(order.ID);
		accountController.updateAccount(account);
		order.recipientTime = time;
		order.recipientName = name;
		//更新订单信息
		controller.updateOrder(order);
		return 0;
	}
	
	public void refresh(){
		checkBoard.setText(null);
		receiveName.setText(null);
		orderInfo.setText(null);
		receiveDate.setText(GetDate.getTime());
		order = null;
	}
}