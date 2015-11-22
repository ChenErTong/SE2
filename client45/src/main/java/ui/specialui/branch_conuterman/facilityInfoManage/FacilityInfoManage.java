package ui.specialui.branch_conuterman.facilityInfoManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businesslogic.ControllerFactory;
import businesslogic.facility.FacilityController;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.FacilityVO;

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
		searchFacility.setActionCommand("searchFacility");
		searchFacility.addActionListener(frame);
		
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
	 * TODO 从bl层获取数据
	 * 查找车辆
	 */
	public boolean searchFacility() {		
		facility = facilityController.findFacility(facilityId.getText());
		if(facility == null){
			return false;
		}		
		String[] data = new String[5];
		data[0] = facility.getFacilityIdString();
		
	
		id = facilityId.getText();
		facilityInfo.setData(data);
		return true;
	}

	public int addFacility() {
		String[] data = facilityInfo.getData();
		if(data == null) return 1;
		
//		facility = new FacilityVO();
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
		
//		facility.
//		facilityController.modifyFacility(facility);
//		facilityController.confirmOperation();
		return 0;
	}
	
	public int deleteFacility() {
		if(id == null){
			return 2;
		}
		facilityController.deleteFacility(facility);
		return 0;
	}
	
	public void refresh() {
		facilityInfo.refresh();
		facilityId.setText(null);
	}
}