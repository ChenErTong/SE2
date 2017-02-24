package ui.specialui.branch_conuterman.facilityInfoManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.ControllerFactory;
import businesslogicservice.facilityblservice.FacilityBLService;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.myui.MyTranslucentPanel;
import ui.specialui.branch_conuterman.Frame_Branch;

public class FacilityInfo extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	
	public FacilityInfo(Frame_Branch frame) {
		super(470, 190, 340, 355);
		this.initComponent(frame);
	}
	
	private void initComponent(Frame_Branch frame){
		fields = new MyJTextField[5];
		this.add(new MyJLabel(78, 42, 60, 25, "车牌号", 18, true));
		fields[0] = new MyJTextField(150, 40, 130, 30);
		fields[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[0]){
					fields[1].requestFocus();
				}
			}
			
		});
		
		this.add(new MyJLabel(78, 102, 60, 25, "底盘号", 18, true));
		fields[1] = new MyJTextField(150, 100, 130, 30);
		fields[1].setOnlyInteger(9);
		fields[1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[1]){
					fields[3].requestFocus();
				}
			}
			
		});
		
		this.add(new MyJLabel(60, 162, 100, 25, "车辆代号", 18, true));
		fields[2] = new MyJTextField(150, 160, 130, 30);
		fields[2].setOnlyInteger(9);
		
		FacilityBLService facilityController = null;
		try {
			facilityController = ControllerFactory.getFacilityController();
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		if(facilityController != null){
			try {
				fields[2].setText(facilityController.getID(frame.getID().substring(0, 6)));
			} catch (RemoteException e1) {
				new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);
			}
		}
		
		this.add(new MyJLabel(60, 222, 100, 25, "发动机号", 18, true));
		fields[3] = new MyJTextField(150, 220, 130, 30);
		fields[3].setOnlyInteger(9);
		fields[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[3]){
					fields[4].requestFocus();
				}
			}
		});
		
		this.add(new MyJLabel(60, 282, 80, 25, "购买时间", 18, true));
		fields[4] = new MyJTextField(150, 280, 130, 30);
		fields[4].setForDate();
		
		for (MyJTextField myJTextField : fields) {
			this.add(myJTextField);
		}
	}
	
	/**
	 * 文本框不可修改
	 */
	public void setUneditable(){
		for (MyJTextField myJTextField : fields) {
			myJTextField.setEnabled(false);
		}
	}

	public void setData(String[] data) {
		for(int i = 0; i < 5; i++){
			fields[i].setText(data[i]);
		}
	}

	public String[] getData() {
		String[] data = new String[5];
		for (int i = 0; i < 5; i++) {			
			if((data[i] = fields[i].getText()).equals("")) return null;
		}
		return data;
	}

	public void refresh() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
	}
}