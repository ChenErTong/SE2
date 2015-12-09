package ui.specialui.finance.ViewLogMsg;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private LogController logController = ControllerFactory.getLogController();

	public ViewLogPanel() {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent();
		}

	private void initComponent() {
		this.add(new MyJLabel(560, 20, 210, 90, "系统操作日志查看", 24, true));
		 log = new LogPanel(this);
		this.add(log);
		
		messagePool = new ArrayList<LogMessage>();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Search")){
			
			if(e.getActionCommand().equals("Search")){
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
				
					ArrayList<LogMessage> logs = logController.showInDate(date);
					logText.setText("");
					for(int i=0;i<logs.size();i++){
						logText.append(logs.get(i).userName+" "+logs.get(i).time+" "+logs.get(i).message);
						logText.append("\n");
					}
				
				}
			}else if(e.getActionCommand().equals("ShowAll")){
				logText.setText("");
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
