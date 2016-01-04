package ui.specialui.branch_conuterman.receiveAndSendCommodity;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ui.image.BranchImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.CommodityVO;
import vo.OrderVO;
import vo.accountvo.AccountVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import businesslogic.ControllerFactory;
import businesslogicservice.branchblservice.BranchBLService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.organizationblservice.OrganizationBLService;
/**
 * 派发货物界面
 * @author czw
 * @time 2015年11月22日下午2:20:58
 */
public class SendCommodity extends MyJPanel{
	private static final long serialVersionUID = 1L;
	
	private MyJComboBox courier;
	private BranchBLService branchController;
	private MyEmptyTextArea arrivalList;
	private BranchArrivalListVO arrivalListVO;
	
	public SendCommodity(Frame_Branch frame, BranchArrivalListVO arrivalListVO){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.arrivalListVO = arrivalListVO;
		
		try {
			branchController = ControllerFactory.getBranchController();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
				
		this.add(new MyJLabel(550, 30, 210, 45, "接收派件货物", 30, true));
		this.add(new MyJLabel(620, 100, 69, 23, "到达单", 18, true));
		
		arrivalList = new MyEmptyTextArea(390, 100, 500, 450);
		this.add(arrivalList);
		this.add(new MyJLabel(520, 580, 115, 23, "可选快递员", 18, true));
		
		this.setCourier(frame);
		
		MyButton produceDeliveryList = new MyButton(584, 630, 111, 33,
				BranchImage.getBUTTON_PAIJIANDAN());
		produceDeliveryList.setActionCommand("produceDeliveryList");
		produceDeliveryList.addActionListener(frame);
		this.add(produceDeliveryList);
	}

	private void setCourier(Frame_Branch frame){
		//快递员
		OrganizationBLService organizationController;
		try {
			organizationController = ControllerFactory.getOrganizationController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return;
		}
		ArrayList<AccountVO> couriers = null;;
		try {
			couriers = organizationController.getAccountByOrganizationID(frame.getID().substring(0, 6));
		} catch (RemoteException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return;
		}
		
		if(couriers.size() == 0){
			new MyNotification(frame, "没有空闲快递员", Color.RED);
		}
		
		String[] courierInfo = null;
		if(couriers.size() > 0){
			courierInfo = new String[couriers.size()];
			for(int i = 0; i < courierInfo.length; ++i){
				courierInfo[i] = couriers.get(i).ID + " " + couriers.get(i).Name;
			}
		}		
		courier = new MyJComboBox(650, 575, 141, 30, courierInfo);	
		this.add(courier);
		
		this.showOrderInfo();
	}
	
	private void showOrderInfo(){
		OrderBLService orderController = null;
		try {
			orderController = ControllerFactory.getOrderController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return;
		}
		OrderVO order = null;
		try {
			order = orderController.inquireOrder(arrivalListVO.orderID);
		} catch (RemoteException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
			return;
		}
		arrivalList.setText("\n\n");
		arrivalList.append("中转单编号：" + arrivalListVO.transferListID + "\n");
		arrivalList.append("订单编号：" + order.ID + "\n");
		arrivalList.append("寄件人信息：\n");
		arrivalList.append("姓名：" + order.senderName + "\t");
		arrivalList.append("电话：" + order.senderTel + "\n");
		arrivalList.append("住址：" + order.senderAddress + "\n");
		arrivalList.append("单位：" + order.senderCo + "\n");
		arrivalList.append("收件人信息：\n");
		arrivalList.append("姓名：" + order.recipientName + "\t");
		arrivalList.append("电话：" + order.recipientTel + "\n");
		arrivalList.append("住址：" + order.recipientAddress + "\n");
		arrivalList.append("单位：" + order.recipientCo + "\n");
		arrivalList.append("货物信息：\n");	
		for(CommodityVO commodity: order.commodities){
			arrivalList.append(commodity.commodityType + "\t" + commodity.volumn + "m³\t" + commodity.weight + "kg\n");	
		}
		arrivalList.append("快递类型：" + order.express.value + "\t包装方式：" + order.packType.value + "\n");
		arrivalList.append("寄件日期：" + order.sendTime + "\t运费：" + order.money + "\n");
		arrivalList.append("派件地：" + arrivalListVO.departure);
		this.repaint();
	}
	
	/**
	 * 生成派件单，若未选择快递员则返回1
	 * @return
	 */
	public int produceDeliveryList() {
		String courierInfo = (String) courier.getSelectedItem();
		if(courierInfo == null){
			return 1;
		}
		String courierName = courierInfo.split(" ")[1];
		try {
			branchController = ControllerFactory.getBranchController();
			branchController.getDeliveryList(arrivalListVO.orderID, courierName);
			return 0;
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -1;
		}
	}
}