package dataservice.accountdataservice;



import dataservice.DataService;

public interface AccountDataService extends DataService {
	
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "AccountData";
	
	public void init();
	
}
