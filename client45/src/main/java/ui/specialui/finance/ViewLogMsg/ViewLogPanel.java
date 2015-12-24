package ui.specialui.finance.ViewLogMsg;

import ui.image.ManagerImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.finance.Frame_Finance;

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
 * 负责监听和panel转换的总Panel
 * @author zsq
 * @version 2015/12/5 12:00
 */
public class ViewLogPanel extends MyJPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private MyJTable table;
	
	private LogPanel log;
	private MyEmptyTextArea logText;
	private MyButton view;
	static ArrayList<LogMessage> messagePool;

	public ViewLogPanel(Frame_Finance frame_Finance) {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
		}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 300, 40, "系统操作日志查看", 30, true));
		 log = new LogPanel(this);
		this.add(log);
		
		view = new MyButton(510,630,120,40,ManagerImage.getBUTTON_VIEWMSG());
		view.setActionCommand("ViewMessage");
		view.addActionListener(this);
		this.add(view);
		messagePool = new ArrayList<LogMessage>();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Search")){
			logText = log.getText();
			String[] data = new String[3];
			data = log.getData();
			if(data==null){
				new MyNotification(this,"请输入查询日期",Color.RED);
				return;
			}else if(!this.isLegal(data)){
				new MyNotification(this,"输入的查询日期不符合日期规则！",Color.RED);
				return;
			}else{
				String year = data[0];
				year = (isDigit(year))?year:"";
				String month = data[1];
				month = (isDigit(month)) ? ("-" + month) : "";
				String day = data[2];
				day = (isDigit(day) && month.length() != 0) ? ("-" + day) : "";
				String date = year + month + day;
				

				try {
					LogController logController = ControllerFactory.getLogController();
					ArrayList<LogMessage> logs = logController.showInDate(date);
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
					logText.setText("");
					for(int i=0;i<logs.size();i++){
						logText.append(logs.get(i).userName+" "+logs.get(i).time+" "+logs.get(i).message);
						logText.append("\n");
					}
					new MyNotification(this,"共有"+table.getRowCount()+"条记录满足条件！",Color.GREEN);
				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
							new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();ControllerFactory.init();
					return;
				}
			
			}
		}else if(e.getActionCommand().equals("ViewMessage")){
			logText = log.getText();
			logText.setText("");
			table = log.getTable();
			
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要查看的记录！",Color.RED);
			}else{
				logText.append(messagePool.get(table.getSelectedRow()).userName+" "+messagePool.get(table.getSelectedRow()
					).time+" "+messagePool.get(table.getSelectedRow()).message);
				logText.append("\n");
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
		/**
		 * 判断输入的日期是否合法
		 */
		private boolean isLegal(String []input){
			for(int i=0;i<input.length;i++){
				if(!this.isDigit(input[i])){
					return false;
				}
			}	
			
			Date current = new Date();
			SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
			
			int standard = Integer.parseInt(sdfYear.format(current));
			int year = Integer.parseInt(input[0]);
			int month = Integer.parseInt(input[1]);
			int day = Integer.parseInt(input[2]);
			if(year<0||year>standard){
				return false;
			}else if((month<0||month>12)){
				return false;
			}else if((day<0||day>31)){
				return false;
			}
			if((month==2&&day>28)){
				return false;
			}
			return true;
		}
}
