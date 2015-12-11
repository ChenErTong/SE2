package ui.specialui.manager.ViewLogMsg;

import ui.image.ManagerImage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.logbl.LogController;
import po.LogMessage;

/**
 * 负责查看记录日志界面panel的相互跳转
 * @author zsq
 * @version 2015/12/05 15:01
 */
public class ViewLogPanel extends MyJPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private LogPanel log;
	private MyEmptyTextArea logText;
	
	private MyJTable table;
	static ArrayList<LogMessage> messagePool;

	public ViewLogPanel(FrameManager frameManager) {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent();
		this.leadline(frameManager);
		}

	private void initComponent() {
		this.add(new MyJLabel(530, 20, 300, 40, "系统操作日志查看", 30, true));
		log = new LogPanel(this);
		this.add(log);
		messagePool = new ArrayList<LogMessage>();
		
	}
	public void leadline(FrameManager frameManager){
		
		MyButton HandleReceipt = new MyButton(300-105, 690,95,20,ManagerImage.getBUTTON_APPROVE_());
		HandleReceipt.setActionCommand("HandleReceipt");
		HandleReceipt.addActionListener(frameManager);
		this.add(HandleReceipt);
		HandleReceipt.setVisible(true);
		
		MyButton HandleOrganization = new MyButton(300, 690,120,20,ManagerImage.getBUTTON_ORGANIZATION_());
		HandleOrganization.setActionCommand("HandleOrganization");
		HandleOrganization.addActionListener(frameManager);
		this.add(HandleOrganization);
		HandleOrganization.setVisible(true);
		
		MyButton AdjustBase = new MyButton(300+120+10, 690,120,20,ManagerImage.getBUTTON_BASE_());
		AdjustBase.setActionCommand("AdjustBase");
		AdjustBase.addActionListener(frameManager);
		this.add(AdjustBase);
		AdjustBase.setVisible(true);
		
		MyButton AdjustSalaryPolicy = new MyButton(300+120+10+130,690,120,20,ManagerImage.getBUTTON_POLICY_());
		AdjustSalaryPolicy.setActionCommand("AdjustSalaryPolicy");
		AdjustSalaryPolicy.addActionListener(frameManager);
		this.add(AdjustSalaryPolicy);
		AdjustSalaryPolicy.setVisible(true);
		
		MyButton ViewUser = new MyButton(300+120+10+130+130,  690,120,20,ManagerImage.getBUTTON_ACCOUNT_());
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(frameManager);
		this.add(ViewUser);
		ViewUser.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(300+120+10+130+130+130,690,120,20,FinanceImage.getButton_JINGYING_());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frameManager);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(300+130*5,690,120,20,FinanceImage.getButton_CHENGBEN_());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frameManager);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(300+130*6,690,120,20,FinanceImage.getButton_LOG_());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frameManager);
		this.add(viewLog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Search")){
				logText = log.getText();
				String[] data = new String[3];
				data = log.getData();
				if(data==null){
					new MyNotification(this,"请输入查询日期",Color.RED);
				}else{
					Date current = new Date();
					String year = data[0];
					SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
					year = (isDigit(year))?year:sdfYear.format(current);//默认为当年
					String month = data[1];
					month = (isDigit(month)) ? ("-" + month) : "";
					String day = data[2];
					day = (isDigit(day) && month.length() != 0) ? ("-" + day) : "";
					String date = year + month + day;
					
					
					try {
						LogController logController = ControllerFactory.getLogController();
						ArrayList<LogMessage> logs = logController.showInDate(date);
						logText.setText("");
						for(int i=0;i<logs.size();i++){
							logText.append(logs.get(i).userName+" "+logs.get(i).time+" "+logs.get(i).message);
							logText.append("\n");
						}
					} catch (MalformedURLException | RemoteException
							| NotBoundException e1) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
						e1.printStackTrace();
					}
				
				}
			}else if(e.getActionCommand().equals("ShowAll")){
				logText = log.getText();
				logText.setText("");
				
				ArrayList<LogMessage> logs;
				try {
					LogController logController = ControllerFactory.getLogController();
					logs = logController.show();
					table = log.getTable();
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					
					int rowCount = table.getRowCount();
					
					for(int i = 0; i < rowCount; i++){
						tableModel.removeRow(0);
					}
					
					messagePool.clear();
			
					for(int i=0;i<logs.size();i++){
						String [] rowData = {logs.get(i).userName,logs.get(i).time,logs.get(i).message};
						tableModel.addRow(rowData);
						messagePool.add(logs.get(i));
					}
				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					e1.printStackTrace();
				}
				
 			}
		
	}
		
	/**
	 * 判断一个字符串是否为数字
	 * @param num
	 * @return 是否是数字
	 */
	private boolean isDigit(String num) {
		if (num.length() == 0) {
			return false;
		}
		for(int i = 0; i < num.length(); i++) {
			if (!Character.isDigit(num.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
