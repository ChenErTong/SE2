package businesslogicservice.logblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogMessage;

/**
 * 程序的简单说明
 * 
 * @author Ann
 * @version 创建时间：2015年12月6日 下午8:28:14
 */
public interface LogBLService {
	public ArrayList<LogMessage> show() throws RemoteException;

	public ArrayList<LogMessage> showInDate(String date) throws RemoteException;
}
