package ui.specialui.finance.ViewLogMsg;

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
						if(logs==null){
							return;
						}
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
					} catch (MalformedURLException | RemoteException
							| NotBoundException e1) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
						return;
					}
				
				}
			}else if(e.getActionCommand().equals("ShowAll")){
				logText = log.getText();
				logText.setText("");
				try {
					LogController logController = ControllerFactory.getLogController();
					ArrayList<LogMessage> logs = logController.show();
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
