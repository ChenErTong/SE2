package ui.specialui.branch_conuterman.facilityInfoManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businesslogic.ControllerFactory;
import businesslogic.facilitybl.FacilityController;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.FacilityVO;
/**
 * 车辆信息管理界面
 * @author czw
 * @time 2015年11月22日下午2:19:50
 */
public class FacilityInfoManage extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private FacilityInfo facilityInfo;
	private MyJButton commonButton;
	private MyJTextField facilityId;
	private MyJButton searchFacility;
	private String id;
	private FacilityController facilityController;
	private FacilityVO facility;
	
	
	public FacilityInfoManage(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		facilityController = ControllerFactory.getFacilityController();
		
		facilityId = new MyJTextField(510, 115, 250, 30);
		facilityId.setOnlyInteger(9);
		searchFacility = new MyJButton(770, 115, 60, 30, "查询", 20);
		searchFacility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!FacilityInfoManage.this.searchFacility(facilityId.getText())){
					new MyNotification(frame, "不存在该车辆代号", Color.RED);
				}	
			}
		});
		
		this.insertPanel(frame);
	}

	private void insertPanel(Frame_Branch frame) {
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "车辆信息管理", 30, true));
		this.initButton(frame);
		id = null;
		
		facilityInfo = new FacilityInfo();
		this.add(facilityInfo);
		
		commonButton = new MyJButton(580, 600, 120, 30, "添加车辆", 20);
		commonButton.setActionCommand("addFacility");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void modifyPanel(Frame_Branch frame) {
		id = null;
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "车辆信息管理", 30, true));
		this.initButton(frame);
		
		facilityInfo = new FacilityInfo();
		this.add(facilityInfo);
		
		this.add(new MyJLabel(415, 110, 100, 40, "车辆代号", 20, true));
		this.add(facilityId);
		this.add(searchFacility);
		
		commonButton = new MyJButton(580, 600, 120, 30, "修改车辆", 20);
		commonButton.setActionCommand("modifyFacility");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void searchPanel(Frame_Branch frame) {
		id = null;
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "车辆信息管理", 30, true));
		this.initButton(frame);
		
		facilityInfo = new FacilityInfo();
		facilityInfo.setUneditable();
		this.add(facilityInfo);
		
		this.add(new MyJLabel(415, 110, 100, 40, "车辆代号", 20, true));
		this.add(facilityId);
		this.add(searchFacility);
		
		this.repaint();
	}

	private void deletePanel(Frame_Branch frame) {
		id = null;
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "车辆信息管理", 30, true));
		this.initButton(frame);
		
		facilityInfo = new FacilityInfo();
		facilityInfo.setUneditable();
		this.add(facilityInfo);
		
		this.add(new MyJLabel(415, 110, 100, 40, "车辆代号", 20, true));
		this.add(facilityId);
		this.add(searchFacility);
		
		commonButton = new MyJButton(580, 600, 120, 30, "删除车辆", 20);
		commonButton.setActionCommand("deleteFacility");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void initButton(Frame_Branch frame) {
		MyJButton insertButton = new MyJButton(0, 150, 40, 110,
				"<html>添<br/>加<br/>车<br/>辆<br/></html>", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacilityInfoManage.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

		MyJButton modifyButton = new MyJButton(0, 260, 40, 110,
				"<html>修<br/>改<br/>车<br/>辆<br/></html>", 18);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacilityInfoManage.this.modifyPanel(frame);
				
			}
		});
		this.add(modifyButton);

		MyJButton searchButton = new MyJButton(0, 370, 40, 110,
				"<html>查<br/>看<br/>车<br/>辆<br/></html>", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacilityInfoManage.this.searchPanel(frame);
				
			}
		});
		this.add(searchButton);

		MyJButton deleteButton = new MyJButton(0, 480, 40, 110,
				"<html>删<br/>除<br/>车<br/>辆<br/></html>", 18);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacilityInfoManage.this.deletePanel(frame);
				
			}
		});
		this.add(deleteButton);
	}
	/**
	 * 从bl层获取数据
	 * 查找车辆
	 * @param facilityId 
	 */
	private boolean searchFacility(String facilityId) {
		facility = facilityController.findFacility(facilityId);
		if(facility == null){
			return false;
		}		
		String[] data = new String[5];
		data[0] = facility.vehicleIdentificationNumber;
		data[1] = facility.bottomCode;
		data[2] = facility.facilityIdString;
		data[3] = facility.engineCode;
		data[4] = facility.dateString;
	
		id = facilityId;
		facilityInfo.setData(data);
		return true;
	}

	public int addFacility() {
		String[] data = facilityInfo.getData();
		if(data == null) return 1;
		//TODO 此处要添加branchID  branchID可以在organizationbl里拿到（getAllBranchNumbers）
		facility = new FacilityVO(null, null, data[2], data[4], data[1], data[3], data[0], id.substring(0, 6));
		facilityController.addFacility(facility);
		facilityController.confirmOperation();
		return 0;
	}

	public int modifyFacility() {
		if(id == null){
			return 2;
		}
		String[] data = facilityInfo.getData();
		if(data == null) return 1;
		
		facility.vehicleIdentificationNumber=data[0];
		facility.bottomCode=data[1];
		facility.facilityIdString=data[2];
		facility.engineCode=data[3];
		facility.dateString=data[4];
		facilityController.modifyFacility(facility);
		facilityController.confirmOperation();
		return 0;
	}
	
	public int deleteFacility() {
		if(id == null){
			return 2;
		}
		facilityController.deleteFacility(facility);
		facilityController.confirmOperation();
		return 0;
	}
	
	public void refresh() {
		facilityInfo.refresh();
		facilityId.setText(null);
	}
}