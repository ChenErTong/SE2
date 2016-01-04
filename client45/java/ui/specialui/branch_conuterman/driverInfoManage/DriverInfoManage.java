package ui.specialui.branch_conuterman.driverInfoManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ui.image.BranchImage;
import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.accountvo.DriverVO;
import businesslogic.ControllerFactory;
import businesslogic.facilitybl.DriverController;
/**
 * 车辆信息管理界面
 * @author czw
 * @time 2015年11月22日下午2:19:50
 */
public class DriverInfoManage extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private DriverInfo driverInfo;
	private MyButton commonButton;
	private MyButton searchDriver;
	private MyJTextField driverId;
	private String id;
	private DriverController driverController;
	private DriverVO driver;
	
	
	public DriverInfoManage(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		try {
			driverController = ControllerFactory.getDriverController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		driverId = new MyJTextField(510, 115, 250, 30);
		driverId.setOnlyInteger(9);
		searchDriver = new MyButton(770, 110, 35, 35, LoginImage.getBUTTON_LOGISTIC());
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
		
		driverInfo = new DriverInfo(frame);
		this.add(driverInfo);
		
		commonButton = new MyButton(584, 600, 111, 33, BranchImage.getBUTTON_TIANJIASIJI_HORIZONTAL());
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
		
		driverInfo = new DriverInfo(frame);
		this.add(driverInfo);
		
		this.add(new MyJLabel(415, 110, 100, 40, "司机编号", 20, true));
		this.add(driverId);
		this.add(searchDriver);
		
		commonButton = new MyButton(584, 600, 111, 33, BranchImage.getBUTTON_XIUGAISIJI_HORIZONTAL());
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
		
		driverInfo = new DriverInfo(frame);
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
		
		driverInfo = new DriverInfo(frame);
		driverInfo.setUneditable();
		this.add(driverInfo);
		
		this.add(new MyJLabel(415, 110, 100, 40, "司机编号", 20, true));
		this.add(driverId);
		this.add(searchDriver);
		
		commonButton = new MyButton(584, 600, 111, 33, BranchImage.getBUTTON_SHANCHUSIJI_HORIZONTAL());
		commonButton.setActionCommand("deleteDriver");
		commonButton.addActionListener(frame);
		this.add(commonButton);
		
		this.repaint();
	}

	private void initButton(Frame_Branch frame) {
		MyButton insertButton = new MyButton(0, 150, 33, 111,
				BranchImage.getBUTTON_TIANJIASIJI_VERTICAL());
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverInfoManage.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

		MyButton modifyButton = new MyButton(0, 261, 33, 111,
				BranchImage.getBUTTON_XIUGAISIJI_VERTICAL());
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverInfoManage.this.modifyPanel(frame);
				
			}
		});
		this.add(modifyButton);

		MyButton searchButton = new MyButton(0, 372, 33, 111,
				BranchImage.getBUTTON_CHAXUNSIJI_VERTICAL());
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverInfoManage.this.searchPanel(frame);
				
			}
		});
		this.add(searchButton);

		MyButton deleteButton = new MyButton(0, 483, 33, 111,
				BranchImage.getBUTTON_SHANCHUSIJI_VERTICAL());
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
		try {
			driverController = ControllerFactory.getDriverController();
			driver = driverController.findDriver(driverId);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return true;
		}
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
		if(data[5].length() != 9) return 2;
		driver = new DriverVO(data[5], "营业厅司机", data[0], data[1], data[4], data[2], new BigDecimal(0), data[6], data[3], data[5].substring(0, 6));
		try {
			driverController = ControllerFactory.getDriverController();
			driverController.addDriver(driver);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -1;
		}
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
		
		try {
			driverController = ControllerFactory.getDriverController();
			driverController.modifyDriver(driver);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -1;
		}
		driverController.confirmOperation();
		return 0;
	}
	
	public int deleteDriver() {
		if(id == null){
			return 2;
		}
		try {
			driverController = ControllerFactory.getDriverController();
			driverController.deleteDriver(driver);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -1;
		}
		driverController.confirmOperation();
		return 0;
	}
	
	public void refresh() {
		driverInfo.refresh();
		driverId.setText(null);
	}
}