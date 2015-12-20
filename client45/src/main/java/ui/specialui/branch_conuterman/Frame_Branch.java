package ui.specialui.branch_conuterman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.image.BranchImage;
import ui.image.CommonImage;
import ui.myui.MyButton;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.debitNoteBuild.DebitNoteBuild;
import ui.specialui.branch_conuterman.driverInfoManage.DriverInfoManage;
import ui.specialui.branch_conuterman.facilityInfoManage.FacilityInfoManage;
import ui.specialui.branch_conuterman.receiveAndSendCommodity.ArrivalCommodityInfoCheck;
import ui.specialui.branch_conuterman.receiveAndSendCommodity.SendCommodity;
import ui.specialui.branch_conuterman.vehicleloading.LoadingListUI;
import ui.specialui.branch_conuterman.vehicleloading.VehicleLoading;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;

public class Frame_Branch extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Panel_Branch_Total totalPanel;
	private MyJPanel subPanel;
	// 导航栏
	private MyButton vehicleloading;
	private MyButton facilityInfoManage;
	private MyButton driverInfoManage;
	private MyButton receiveAndSend;
	private MyButton debitNote;
		
	public Frame_Branch(String userID) {
		super(userID);
		this.totalPanel = new Panel_Branch_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		
		vehicleloading = new MyButton(650, 690, 120, 20, BranchImage.getBUTTON_ZHUANGCHE_GUIDE());
		vehicleloading.setActionCommand("Vehicleloading");
		vehicleloading.addActionListener(this);
		facilityInfoManage = new MyButton(780, 690, 120, 20, BranchImage.getBUTTON_CHELIANG_GUIDE());
		facilityInfoManage.setActionCommand("FacilityInfoManage");
		facilityInfoManage.addActionListener(this);
		driverInfoManage = new MyButton(910, 690, 120, 20, BranchImage.getBUTTON_SIJI_GUIDE());
		driverInfoManage.setActionCommand("DriverInfoManage");
		driverInfoManage.addActionListener(this);
		receiveAndSend = new MyButton(1040, 690, 120, 20, BranchImage.getBUTTON_JIESHOUPAIJIAN_GUIDE());
		receiveAndSend.setActionCommand("ReceiveAndSendCommodity");
		receiveAndSend.addActionListener(this);
		debitNote = new MyButton(1170, 690, 100, 20, BranchImage.getBUTTON_SHOUKUANDAN_GUIDE());
		debitNote.setActionCommand("DebitNoteBuild");
		debitNote.addActionListener(this);
		this.add(vehicleloading);
		this.add(facilityInfoManage);
		this.add(driverInfoManage);
		this.add(receiveAndSend);
		this.add(debitNote);
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
		}else if(e.getActionCommand().equals("Vehicleloading")){
			//进入车辆装车管理界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new VehicleLoading(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("FacilityInfoManage")){
			//进入车辆信息管理界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new FacilityInfoManage(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("DriverInfoManage")){
			//进入司机信息管理界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new DriverInfoManage(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ReceiveAndSendCommodity")){
			//进入接收派件货物界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new ArrivalCommodityInfoCheck(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("DebitNoteBuild")){
			//进入收款单建立界面
			totalPanel.setVisible(false);
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
			}
			subPanel = new DebitNoteBuild(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("produceLoadingList")){
			//从车辆装车管理界面进入装车单界面
			LoadingListVO loadingList = ((VehicleLoading) subPanel).produceLoadingList();
			if(loadingList != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = new LoadingListUI(loadingList);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			}
		}else if(e.getActionCommand().equals("produceArrivalList")){
			//从接收派件货物界面进入到达单界面
			if(this.produceArrivalList()){
				BranchArrivalListVO arrivalList = ((ArrivalCommodityInfoCheck) subPanel).getArrivalList();
				subPanel.setVisible(false);
				this.getLayeredPane().remove(subPanel);
				subPanel = new SendCommodity(this, arrivalList);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));			}
		}else if(e.getActionCommand().equals("produceDeliveryList")){
			//从到达单界面进入接收派件货物界面
			if(this.produceDeliveryList()){
				subPanel.setVisible(false);
				this.getLayeredPane().remove(subPanel);
				subPanel = new ArrivalCommodityInfoCheck(this);
				this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));			}
		}else if(e.getActionCommand().equals("produceDebitNote")){
			//建立收款单
			if(this.produceDebitNote()){
				((DebitNoteBuild) subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("addFacility")){
			//添加车辆
			if(this.addFacility()){
				((FacilityInfoManage) subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("modifyFacility")){
			//修改车辆
			if(this.modifyFacility()){
				((FacilityInfoManage) subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("deleteFacility")){
			//删除车辆
			if(this.deleteFacility()){
				((FacilityInfoManage) subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("addDriver")){
			//添加司机
			if(this.addDriver()){
				((DriverInfoManage) subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("modifyDriver")){
			//修改司机
			if(this.modifyDriver()){
				((DriverInfoManage) subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("deleteDriver")){
			//删除司机
			if(this.deleteDriver()){
				((DriverInfoManage) subPanel).refresh();
			}
		}
	}

	/**
	 * 增加车辆
	 * @return
	 */
	private boolean addFacility() {
		switch(((FacilityInfoManage) subPanel).addFacility()){
		case 0: new MyNotification(this, "添加成功", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成车辆信息填写", Color.RED); break;
		case 2: new MyNotification(this, "车辆编号不符合规范", Color.RED); break;
		}	
		return false;
	}

	/**
	 * 修改车辆
	 * @return
	 */
	private boolean modifyFacility() {
		switch(((FacilityInfoManage) subPanel).modifyFacility()){
		case 0: new MyNotification(this, "修改成功", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成车辆信息填写", Color.RED); break;
		case 2: new MyNotification(this, "请先输入正确的车辆代号进行查询", Color.RED); break;
		}	
		return false;
	}
	
	/**
	 * 删除车辆
	 * @return
	 */
	private boolean deleteFacility() {
		switch(((FacilityInfoManage) subPanel).deleteFacility()){
		case 0: new MyNotification(this, "删除成功", Color.GREEN); return true;
		case 2: new MyNotification(this, "请先输入正确的车辆代号进行查询", Color.RED); break;
		}	
		return false;
	}
	
	/**
	 * 增加司机
	 * @return
	 */
	private boolean addDriver() {
		switch(((DriverInfoManage) subPanel).addDriver()){
		case 0: new MyNotification(this, "添加成功", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成司机信息填写", Color.RED); break;
		case 2: new MyNotification(this, "编号不符合规范", Color.RED); break;
		}	
		return false;
	}
	
	/**
	 * 修改司机
	 * @return
	 */
	private boolean modifyDriver() {
		switch(((DriverInfoManage) subPanel).modifyDriver()){
		case 0: new MyNotification(this, "修改成功", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成司机信息填写", Color.RED); break;
		case 2: new MyNotification(this, "请先输入正确的司机编号进行查询", Color.RED); break;
		}	
		return false;
	}
	
	/**
	 * 删除司机
	 * @return
	 */
	private boolean deleteDriver() {
		switch(((DriverInfoManage) subPanel).deleteDriver()){
		case 0: new MyNotification(this, "删除成功", Color.GREEN); return true;
		case 2: new MyNotification(this, "请先输入正确的司机编号进行查询", Color.RED); break;
		}	
		return false;
	}

	/**
	 * 生成到达单
	 * @return
	 */
	private boolean produceArrivalList() {
		switch(((ArrivalCommodityInfoCheck) subPanel).produceArrivalList()){
		case 0: new MyNotification(this, "成功生成到达单", Color.GREEN); return true;
		case 1: new MyNotification(this, "请选择一个订单", Color.RED); break;
		}	
		return false;
	}
	/**
	 * 生成派件单
	 * @return
	 */
	private boolean produceDeliveryList() {
		switch(((SendCommodity) subPanel).produceDeliveryList()){
		case 0: new MyNotification(this, "成功生成派件单", Color.GREEN); return true;
		case 1: new MyNotification(this, "请选择一个快递员", Color.RED); break;
		}	
		return false;
	}
	
	/**
	 * 建立收款单
	 * @return
	 */
	private boolean produceDebitNote() {
		switch(((DebitNoteBuild) subPanel).produceDebitNote()){
		case 0: new MyNotification(this, "成功建立收款单", Color.GREEN); return true;
		case 1: new MyNotification(this, "请输入一个快递员", Color.RED); break;
		case 2: new MyNotification(this, "请输入银行卡号", Color.RED); break;
		}	
		return false;
	}
	
	// 设置导航栏是否隐藏
	private void setNavigation(boolean isVisible) {
		vehicleloading.setVisible(isVisible);
		facilityInfoManage.setVisible(isVisible);
		driverInfoManage.setVisible(isVisible);
		receiveAndSend.setVisible(isVisible);
		debitNote.setVisible(isVisible);
		subscript.setVisible(isVisible);
	}
}