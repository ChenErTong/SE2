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
import ui.specialui.branch_conuterman.receiveAndSendCommodity.ReceiveAndSendCommodity;
import ui.specialui.branch_conuterman.vehicleloading.VehicleLoading;
import ui.specialui.courier.receiveInput.ReceiveInput;

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
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
			}
		}else if(e.getActionCommand().equals("Vehicleloading")){
			totalPanel.setVisible(false);
			subPanel = new VehicleLoading(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("FacilityInfoManage")){
			totalPanel.setVisible(false);
			subPanel = new FacilityInfoManage(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("DriverInfoManage")){
			totalPanel.setVisible(false);
			subPanel = new DriverInfoManage(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ReceiveAndSendCommodity")){
			totalPanel.setVisible(false);
			subPanel = new ReceiveAndSendCommodity(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("DebitNoteBuild")){
			totalPanel.setVisible(false);
			subPanel = new DebitNoteBuild(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("produceLoadingList")){
			if(this.produceLoadingList()){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				// TODO 跳转至装车单界面
			}
		}else if(e.getActionCommand().equals("searchFacility")){
			if(!((FacilityInfoManage) subPanel).searchFacility()){
				new MyNotification(this, "不存在该车辆代号", Color.RED);
			}
		}else if(e.getActionCommand().equals("addFacility")){
			if(this.addFacility()){
				((FacilityInfoManage) subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("modifyFacility")){
			if(this.modifyFacility()){
				((FacilityInfoManage) subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("deleteFacility")){
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
}