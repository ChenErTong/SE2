package businesslogic.logbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.logdataservice.LogDataService;
import po.LogMessage;

/**
 * 程序的简单说明
 * 
 * @author Ann
 * @version 创建时间：2015年12月5日 下午3:02:26
 */
public class Log {
	private LogDataService logData;

	private LogDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (LogDataService) Naming.lookup(RMIConfig.PREFIX + LogDataService.NAME);
	}

	public Log() throws MalformedURLException, RemoteException, NotBoundException {
		logData = getData();
	}

	/**
	 * 向服务器添加一条日志
	 * 
	 * @param message
	 *            LogMessage型，日志信息
	 * @throws RemoteException
	 *             远程异常
	 */
	public void addLog(LogMessage message) throws RemoteException {
		logData.add(message);
	}

	/**
	 * 返回所有日志
	 * 
	 * @return ArrayList<LogMessage>型，所有日志
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<LogMessage> show() throws RemoteException {
		return logData.find();
	}

	/**
	 * 按日期返回日志
	 * 
	 * @param date
	 *            String型，日期
	 * @return ArrayList<LogMessage>型，符合日期条件的日志
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<LogMessage> show(String date) throws RemoteException {
		ArrayList<LogMessage> message = this.show();
		ArrayList<LogMessage> messageInDate = new ArrayList<>();
		for (LogMessage logMessage : message) {
			if (logMessage.time.startsWith(date)) {
				messageInDate.add(logMessage);
			}
		}
		return messageInDate;
	}
}
