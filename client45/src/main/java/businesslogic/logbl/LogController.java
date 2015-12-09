package businesslogic.logbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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

	public LogController() throws MalformedURLException, RemoteException, NotBoundException {
		logBL = new Log();
	}

	public static LogController getInstance() {
		if (controller == null) {
			try {
				controller = new LogController();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
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
	public ArrayList<LogMessage> show() throws RemoteException {
		return logBL.show();
	}

	/**
	 * @see LogBLService#showInDate(String)
	 */
	public ArrayList<LogMessage> showInDate(String date) throws RemoteException {
		try {
			return logBL.show(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
