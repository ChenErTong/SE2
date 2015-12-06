package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.LogMessage;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月6日 下午7:43:51 
*/
public interface LogDataService extends DataService {
	public static String NAME = "LogData";
	public void add(LogMessage message) throws RemoteException;
	public ArrayList<LogMessage> find() throws RemoteException;
}