package data.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.logdataservice.LogDataService;
import po.LogMessage;
import util.SerSaveAndLoad;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月6日 下午7:59:08 
*/
public class LogData extends Data implements LogDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SerSaveAndLoad<LogMessage> log;
	public LogData() throws RemoteException {
		initialFile();
	}

	@Override
	public void add(LogMessage message) throws RemoteException {
		log.add(message);
	}

	@Override
	public ArrayList<LogMessage> find() throws RemoteException {
		return log.getInList();
	}

	@Override
	public void initialFile() throws RemoteException {
		log = new SerSaveAndLoad<>("data/"+NAME+".ser");
	}

}
