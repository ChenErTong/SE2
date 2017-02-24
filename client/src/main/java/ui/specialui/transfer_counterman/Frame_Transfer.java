package ui.specialui.transfer_counterman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import businesslogic.ControllerFactory;
import businesslogicservice.transferblservice.TransferBLService;
import ui.image.CommonImage;
import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.transfer_counterman.car_loading.CarCommodity;
import ui.specialui.transfer_counterman.car_loading.CarLoading;
import ui.specialui.transfer_counterman.plane_loading.PlaneCommodity;
import ui.specialui.transfer_counterman.plane_loading.PlaneLoading;
import ui.specialui.transfer_counterman.train_loading.TrainCommodity;
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
	private String[] loadingInfo;
	private ArrayList<String> orders;
	private TransferBLService transferController;
	// 导航栏
	private MyButton carLoading;
	private MyButton trainLoading;
	private MyButton planeLoading;
	private MyButton transferReceive;
		
	public Frame_Transfer(String userID) {
		super(userID);
		
		try {
			transferController = ControllerFactory.getTransferController();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);
		}
		
		this.totalPanel = new Panel_Transfer_Total(this);
		this.add(totalPanel);
		
		this.returnButton.addActionListener(this);
		
		carLoading = new MyButton(760, 690, 120, 20, TransferImage.getBUTTON_QICHE_GUIDE());
		carLoading.setActionCommand("CarLoading");
		carLoading.addActionListener(this);
		trainLoading = new MyButton(890, 690, 120, 20, TransferImage.getBUTTON_HUOCHE_GUIDE());
		trainLoading.setActionCommand("TrainLoading");
		trainLoading.addActionListener(this);
		planeLoading = new MyButton(1020, 690, 120, 20, TransferImage.getBUTTON_FEIJI_GUIDE());
		planeLoading.setActionCommand("PlaneLoading");
		planeLoading.addActionListener(this);
		transferReceive = new MyButton(1150, 690, 120, 20, TransferImage.getBUTTON_ZHONGZHUAN_GUIDE());
		transferReceive.setActionCommand("TransferReceiveManage");
		transferReceive.addActionListener(this);
		this.add(carLoading);
		this.add(trainLoading);
		this.add(planeLoading);
		this.add(transferReceive);
		this.setNavigation(false);
		
		this.setBackground(CommonImage.BACKGROUND);
		
		this.repaint();
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
				this.setNavigation(false);
			}else{
				this.logout();
			}
		}else if(e.getActionCommand().equals("CarLoading")){
			//进入汽车装运管理界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new CarLoading(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("TrainLoading")){
			//进入火车装运管理界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new TrainLoading(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("PlaneLoading")){
			//进入飞机装运管理界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new PlaneLoading(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("TransferReceiveManage")){
			//进入中转接收管理界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new TransferReceiveManage(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("jumpToCommodityForCar")){
			//进入汽车装运管理货物输入界面
			if(this.jumpToCommodityForCar()){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = new CarCommodity(this);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			}else{
				new MyNotification(this, "请先完成汽车装运信息输入", Color.RED);
			}
		}else if(e.getActionCommand().equals("TransferOrderForCar")){
			//进入汽车装运管理货物输入界面
			if(this.produceTransferOrderForCar()){
				new MyNotification(this, "成功生成中转单", Color.GREEN);
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = new CarLoading(this);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			}else{
				new MyNotification(this, "请至少选择一件订单", Color.RED);
			}
		}else if(e.getActionCommand().equals("jumpToCommodityForPlane")){
			//进入飞机装运管理货物输入界面
			if(this.jumpToCommodityForPlane()){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = new PlaneCommodity(this);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			}else{
				new MyNotification(this, "请先完成飞机装运信息输入", Color.RED);
			}
		}else if(e.getActionCommand().equals("TransferOrderForPlane")){
			//进入飞机装运管理货物输入界面
			if(this.produceTransferOrderForPlane()){
				new MyNotification(this, "成功生成中转单", Color.GREEN);
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = new PlaneLoading(this);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			}else{
				new MyNotification(this, "请至少选择一件订单", Color.RED);
			}
		}else if(e.getActionCommand().equals("jumpToCommodityForTrain")){
			//进入火车装运管理货物输入界面
			if(this.jumpToCommodityForTrain()){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = new TrainCommodity(this);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			}else{
				new MyNotification(this, "请先完成火车装运信息输入", Color.RED);
			}
		}else if(e.getActionCommand().equals("TransferOrderForTrain")){
			//进入火车装运管理货物输入界面
			if(this.produceTransferOrderForTrain()){
				new MyNotification(this, "成功生成中转单", Color.GREEN);
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = new TrainLoading(this);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			}else{
				new MyNotification(this, "请至少选择一件订单", Color.RED);
			}
		}else if(e.getActionCommand().equals("produceArrivalList")){
			//生成到达单
			int result = ((TransferReceiveManage)subPanel).produceArrivalList(this);
			if(result == 0){
				new MyNotification(this, "成功生成到达单", Color.GREEN);
				((TransferReceiveManage)subPanel).refresh();
			}else if(result == 1){
				new MyNotification(this, "请完成中转到达单信息填写", Color.RED);
			}
		}
	}

	/**
	 * 检验汽车装运基本信息是否输入完成，同时把保存数据
	 * @return
	 */
	private boolean jumpToCommodityForCar(){
		loadingInfo = null;
		loadingInfo = ((CarLoading)subPanel).jumpToCommodity();
		if(loadingInfo == null) return false;
		return true;
	}
	
	/**
	 * 检验汽车装运订单信息是否选择完成，同时把保存数据
	 * @return
	 */
	private boolean produceTransferOrderForCar() {
		String[] ordersId = ((CarCommodity)subPanel).produceTransferOrder();
		if(ordersId == null) return false;
		orders = new ArrayList<String>();
		for (String orderId : ordersId) {
			orders.add(orderId);
		}
		try {
			transferController = ControllerFactory.getTransferController();
			transferController.truckTransfer(this.getID().substring(0, 4), loadingInfo[1], loadingInfo[2], loadingInfo[3], loadingInfo[5], orders, loadingInfo[4], loadingInfo[0]);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 检验飞机装运基本信息是否输入完成，同时把保存数据
	 * @return
	 */
	private boolean jumpToCommodityForPlane() {
		loadingInfo = null;
		loadingInfo = ((PlaneLoading)subPanel).jumpToCommodity();
		if(loadingInfo == null) return false;
		return true;
	}
	
	/**
	 * 检验飞机装运订单信息是否输入完成，同时把保存数据
	 * @return
	 */
	private boolean produceTransferOrderForPlane() {
		String[] ordersId = ((PlaneCommodity)subPanel).produceTransferOrder();
		if(ordersId == null) return false;
		orders = new ArrayList<String>();
		for (String orderId : ordersId) {
			orders.add(orderId);
		}
		try {
			transferController = ControllerFactory.getTransferController();
			transferController.planeTransfer(this.getID().substring(0, 4), loadingInfo[1] + loadingInfo[2], loadingInfo[3], loadingInfo[4], loadingInfo[6], orders, loadingInfo[5], loadingInfo[0]);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 检验汽车装运基本信息是否输入完成，同时把保存数据
	 * @return
	 */
	private boolean jumpToCommodityForTrain() {
		loadingInfo = null;
		loadingInfo = ((TrainLoading)subPanel).jumpToCommodity();
		if(loadingInfo == null) return false;
		return true;
	}
	
	/**
	 * 检验火车装运订单信息是否选择完成，同时把保存数据
	 * @return
	 */
	private boolean produceTransferOrderForTrain() {
		String[] ordersId = ((TrainCommodity)subPanel).produceTransferOrder();
		if(ordersId == null) return false;
		orders = new ArrayList<String>();
		for (String orderId : ordersId) {
			orders.add(orderId);
		}

		try {
			transferController = ControllerFactory.getTransferController();
			transferController.trainTransfer(this.getID().substring(0, 4), loadingInfo[1] + loadingInfo[2], loadingInfo[3], loadingInfo[4], loadingInfo[6], orders, loadingInfo[5], loadingInfo[0]);
			}
		catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return false;
		}
		
		return true;
	}
	
	// 设置导航栏是否隐藏
	private void setNavigation(boolean isVisible) {
		carLoading.setVisible(isVisible);
		trainLoading.setVisible(isVisible);
		planeLoading.setVisible(isVisible);
		transferReceive.setVisible(isVisible);
		subscript.setVisible(isVisible);
	}
}