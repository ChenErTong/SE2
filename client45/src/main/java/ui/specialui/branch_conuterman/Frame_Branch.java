package ui.specialui.branch_conuterman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.debitNoteBuild.DebitNoteBuild;
import ui.specialui.branch_conuterman.driverInfoManage.DriverInfoManage;
import ui.specialui.branch_conuterman.facilityInfoManage.FacilityInfoManage;
import ui.specialui.branch_conuterman.receiveAndSendCommodity.ArrivalCommodityInfoCheck;
import ui.specialui.branch_conuterman.receiveAndSendCommodity.SendCommodity;
import ui.specialui.branch_conuterman.vehicleloading.VehicleLoading;

public class Frame_Branch extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Panel_Branch_Total totalPanel;
	private MyJPanel subPanel;
	
	public Frame_Branch() {
		this.totalPanel = new Panel_Branch_Total(this);
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
		}else if(e.getActionCommand().equals("Vehicleloading")){
			//进入车辆装车管理界面
			totalPanel.setVisible(false);
			subPanel = new VehicleLoading(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("FacilityInfoManage")){
			//进入车辆信息管理界面
			totalPanel.setVisible(false);
			subPanel = new FacilityInfoManage(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("DriverInfoManage")){
			//进入司机信息管理界面
			totalPanel.setVisible(false);
			subPanel = new DriverInfoManage(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ReceiveAndSendCommodity")){
			//进入接收派件货物界面
			totalPanel.setVisible(false);
			subPanel = new ArrivalCommodityInfoCheck(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("DebitNoteBuild")){
			//进入收款单建立界面
			totalPanel.setVisible(false);
			subPanel = new DebitNoteBuild(this);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("produceLoadingList")){
			//从车辆装车管理界面进入装车单界面
			if(this.produceLoadingList()){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				// TODO 跳转至装车单界面
			}
		}else if(e.getActionCommand().equals("produceArrivalList")){
			//从接收派件货物界面进入到达单界面
			if(this.produceArrivalList()){
				subPanel.setVisible(false);
				this.getLayeredPane().remove(subPanel);
				subPanel = new SendCommodity(this);
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
	 * 生成装车单
	 * @return
	 */
	private boolean produceLoadingList(){
		switch(((VehicleLoading) subPanel).produceLoadingList()){
		case 0: new MyNotification(this, "成功生成装车单", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成装车信息填写", Color.RED); break;
		case 2: new MyNotification(this, "运费应大于0元", Color.RED); break;
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
		}	
		return false;
	}
}