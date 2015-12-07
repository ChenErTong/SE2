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
* @author Ann
* @version 创建时间：2015年12月5日 下午3:02:26 
*/
public class Log {
	private LogDataService logData;
	private LogDataService getData(){
		try {
			return   (LogDataService) Naming.lookup(RMIConfig.PREFIX + LogDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Log() {
		logData=getData();
	}
	
	public void addLog(LogMessage message) throws RemoteException{
		logData.add(message);
	}
	
	public ArrayList<LogMessage> show() throws RemoteException{
		return logData.find();
	}
	
	public ArrayList<LogMessage> show(String date) throws RemoteException{
		ArrayList<LogMessage> message = this.show();
		ArrayList<LogMessage> messageInDate = new ArrayList<>();
		for (LogMessage logMessage : message) {
			if(logMessage.time.startsWith(date)){
				messageInDate.add(logMessage);
			}
		}
		return messageInDate;
	}
}
