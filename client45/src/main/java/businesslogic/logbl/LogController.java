package businesslogic.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.UserInfomation;
import businesslogicservice.logblservice.LogBLService;
import po.LogMessage;
import po.UserPO;

/**
 * 用于添加日志和查看日志
 * 
 * @author Ann
 * @version 创建时间：2015年12月6日 下午8:24:12
 */
public class LogController implements LogBLService {
	private Log logBL;
	private static LogController controller;

	public LogController() {
		logBL = new Log();
	}

	public static LogController getInstance() {
		if (controller == null) {
			controller = new LogController();
		}
		return controller;
	}

	/**
	 * 获取当前登录的用户并添加一条日志
	 * 
	 * @see UserInfomation#getInstance()
	 * @see UserPO#getUserName()
	 * @param message
	 */
	public void addLog(String message) {
		try {
			logBL.addLog(new LogMessage(UserInfomation.getInstance().getUserName(), message));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see LogBLService#show()
	 */
	public ArrayList<LogMessage> show() {
		try {
			return logBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see LogBLService#showInDate(String)
	 */
	public ArrayList<LogMessage> showInDate(String date) {
		try {
			return logBL.show(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
