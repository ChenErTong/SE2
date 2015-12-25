package ui.specialui.branch_conuterman.driverInfoManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.myui.MyTranslucentPanel;
import ui.specialui.branch_conuterman.Frame_Branch;
import businesslogic.ControllerFactory;
import businesslogicservice.facilityblservice.DriverBLService;

public class DriverInfo extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	
	public DriverInfo(Frame_Branch frame) {
		super(300, 190, 680, 355);
		this.initComponent(frame);
	}

	private void initComponent(Frame_Branch frame) {
		fields = new MyJTextField[7];
		
		this.add(new MyJLabel(78, 42, 42, 21, "姓名", 18, true));
		fields[0] = new MyJTextField(130, 40, 100, 30);
		fields[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[0]){
					fields[1].requestFocus();
				}
			}
			
		});
		
		this.add(new MyJLabel(36, 122, 82, 21, "出生日期", 18, true));
		fields[1] = new MyJTextField(130, 120, 150, 30);
		fields[1].setForDate();
		fields[1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[1]){
					fields[2].requestFocus();
				}
			}
			
		});
		this.add(new MyJLabel(57, 202, 63, 21, "手机号", 18, true));
		fields[2] = new MyJTextField(130, 200, 150, 30);
		fields[2].setOnlyInteger(11);
		fields[2].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[2]){
					fields[3].requestFocus();
				}
			}
			
		});
		
		this.add(new MyJLabel(36, 282, 82, 21, "车辆单位", 18, true));
		fields[3] = new MyJTextField(130, 280, 190, 30);
		fields[3].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[3]){
					fields[4].requestFocus();
				}
			}
			
		});
		
		this.add(new MyJLabel(376, 122, 82, 21, "身份证号", 18, true));
		fields[4] = new MyJTextField(470, 120, 150, 30);
		fields[4].setOnlyInteger(17);
		
		this.add(new MyJLabel(418, 202, 63, 21, "编号", 18, true));
		fields[5] = new MyJTextField(470, 200, 150, 30);
		fields[5].setOnlyInteger(9);
		
		DriverBLService dirverController = null;
		
		try {
			dirverController = ControllerFactory.getDriverController();
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		if(dirverController != null){
			try {
				fields[5].setText(dirverController.getID(frame.getID().substring(0, 6)));
			} catch (RemoteException e1) {
				new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			}
		}
		
		this.add(new MyJLabel(355, 282, 103, 21, "行驶证期限", 18, true));
		fields[6] = new MyJTextField(470, 280, 150, 30);
		fields[6].setForDate();
		
		for (MyJTextField myJTextField : fields) {
			this.add(myJTextField);
		}
	}

	/**
	 * 将信息置为不可修改状态
	 */
	public void setUneditable() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setEnabled(false);
		}
	}

	/**
	 * 根据查询到的数据设置面板内容
	 * @param data
	 */
	public void setData(String[] data) {
		for(int i = 0; i < 7; i++){
			fields[i].setText(data[i]);
		}
	}

	/**
	 * 返回面板数据
	 * @return
	 */
	public String[] getData() {
		String[] data = new String[7];
		for (int i = 0; i < 7; i++) {
			if((data[i] = fields[i].getText()).equals("")) return null;
		}	
		return data;
	}
	
	/**
	 * 将面板数据置为空
	 */
	public void refresh() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
	}
}