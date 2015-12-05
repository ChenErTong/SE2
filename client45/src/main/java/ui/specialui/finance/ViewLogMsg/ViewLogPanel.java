package ui.specialui.finance.ViewLogMsg;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ViewLogPanel extends MyJPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private LogPanel log;
	private MyEmptyTextArea logText;
	
	public ViewLogPanel() {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent();
		}

	private void initComponent() {
		this.add(new MyJLabel(560, 20, 210, 90, "系统操作日志查看", 24, true));
		 log = new LogPanel(this);
		this.add(log);
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
				//	ArrayList<LogMessage> logs = LogMsgController.getLogsByDate(date);
					//logText.setText("");
					//logText.append(logs);
					//logText.setTitle(date);
				}
			}else if(e.getActionCommand().equals("ShowAll")){
				logText.setText("");
				//	for(int i = LogMsgController.logFilesName.length - 1; i >= 0; i--) {
				///	ArrayList<LogMessage> logs = LogMsgController.getLogsByDate(LogMsgController.logFilesName[i]);
				//	logText.append(logs);
				//}
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
