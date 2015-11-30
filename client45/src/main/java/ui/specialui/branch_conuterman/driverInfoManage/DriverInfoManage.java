package ui.specialui.branch_conuterman.driverInfoManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import businesslogic.ControllerFactory;
import businesslogic.facilitybl.DriverController;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.accountvo.DriverVO;
/**
 * 车辆信息管理界面
 * @author czw
 * @time 2015年11月22日下午2:19:50
 */
public class DriverInfoManage extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private DriverInfo driverInfo;
	private MyJButton commonButton;
	private MyJTextField driverId;
	private MyJButton searchDriver;
	private String id;
	private DriverController driverController;
	private DriverVO driver;
	
	
	public DriverInfoManage(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		driverController = ControllerFactory.getDriverController();
		
		driverId = new MyJTextField(510, 115, 250, 30);
		driverId.setOnlyInteger(9);
		searchDriver = new MyJButton(770, 115, 60, 30, "查询", 20);
		searchDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!DriverInfoManage.this.searchDriver(driverId.getText())){
					new MyNotification(frame, "不存在该司机编号", Color.RED);
				}	
			}
		});
		
		this.insertPanel(frame);
	}

	private void insertPanel(Frame_Branch frame) {
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "司机信息管理", 30, true));
		this.initButton(frame);
		id = null;
		
		driverInfo = new DriverInfo();
		this.add(driverInfo);
		
		commonButton = new MyJButton(580, 600, 120, 30, "添加司机", 20);
		commonButton.setActionCommand("addDriver");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void modifyPanel(Frame_Branch frame) {
		id = null;
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "司机信息管理", 30, true));
		this.initButton(frame);
		
		driverInfo = new DriverInfo();
		this.add(driverInfo);
		
		this.add(new MyJLabel(415, 110, 100, 40, "司机编号", 20, true));
		this.add(driverId);
		this.add(searchDriver);
		
		commonButton = new MyJButton(580, 600, 120, 30, "修改司机", 20);
		commonButton.setActionCommand("modifyDriver");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void searchPanel(Frame_Branch frame) {
		id = null;
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "司机信息管理", 30, true));
		this.initButton(frame);
		
		driverInfo = new DriverInfo();
		driverInfo.setUneditable();
		this.add(driverInfo);
		
		this.add(new MyJLabel(415, 110, 100, 40, "司机编号", 20, true));
		this.add(driverId);
		this.add(searchDriver);
		
		this.repaint();
	}

	private void deletePanel(Frame_Branch frame) {
		id = null;
		this.removeAll();
		this.add(new MyJLabel(550, 30, 210, 45, "司机信息管理", 30, true));
		this.initButton(frame);
		
		driverInfo = new DriverInfo();
		driverInfo.setUneditable();
		this.add(driverInfo);
		
		this.add(new MyJLabel(415, 110, 100, 40, "司机编号", 20, true));
		this.add(driverId);
		this.add(searchDriver);
		
		commonButton = new MyJButton(580, 600, 120, 30, "删除司机", 20);
		commonButton.setActionCommand("deleteDriver");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void initButton(Frame_Branch frame) {
		MyJButton insertButton = new MyJButton(0, 150, 40, 110,
				"<html>添<br/>加<br/>司<br/>机<br/></html>", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverInfoManage.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

		MyJButton modifyButton = new MyJButton(0, 260, 40, 110,
				"<html>修<br/>改<br/>司<br/>机<br/></html>", 18);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverInfoManage.this.modifyPanel(frame);
				
			}
		});
		this.add(modifyButton);

		MyJButton searchButton = new MyJButton(0, 370, 40, 110,
				"<html>查<br/>看<br/>司<br/>机<br/></html>", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverInfoManage.this.searchPanel(frame);
				
			}
		});
		this.add(searchButton);

		MyJButton deleteButton = new MyJButton(0, 480, 40, 110,
				"<html>删<br/>除<br/>司<br/>机<br/></html>", 18);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverInfoManage.this.deletePanel(frame);
				
			}
		});
		this.add(deleteButton);
	}
	/**
	 * 从bl层获取数据
	 * 查找车辆
	 * @param facilityId 
	 */
	private boolean searchDriver(String driverId) {	
		driver = driverController.findDriver(driverId);
		if(driver == null){
			return false;
		}		
		String[] data = new String[7];
		data[0] = driver.Name;
		data[1] = driver.BirthDay;
		data[2] = driver.Phone;
		data[3] = driver.carID;
		data[4] = driver.IDCard;
		data[5] = driver.ID;
		data[6] = driver.WorkTime;
		
		id = driverId;
		driverInfo.setData(data);
		return true;
	}

	public int addDriver() {
		String[] data = driverInfo.getData();
		if(data == null) return 1;
		//TODO ui麻烦看一下 branchID可以在organizationbl里拿到（getAllBranchNumbers）
		driver = new DriverVO(data[5], "营业厅司机", data[0], data[1], data[4], data[2], 0.0, data[6], data[3], id.substring(0, 3));
		System.out.println(driver.ID+"--print in ui");
		driverController.addDriver(driver);
		driverController.confirmOperation();
		return 0;
	}

	public int modifyDriver() {
		if(id == null) return 2;
		String[] data = driverInfo.getData();
		if(data == null) return 1;
		
		driver.Name = data[0];
		driver.BirthDay = data[1];
		driver.Phone = data[2];
		driver.carID = data[3];
		driver.IDCard = data[4];
		driver.ID = data[5];
		driver.WorkTime = data[6];
		
		driverController.modifyDriver(driver);
		driverController.confirmOperation();
		return 0;
	}
	
	public int deleteDriver() {
		if(id == null){
			return 2;
		}
		driverController.deleteDriver(driver);
		driverController.confirmOperation();
		return 0;
	}
	
	public void refresh() {
		driverInfo.refresh();
		driverId.setText(null);
	}
}