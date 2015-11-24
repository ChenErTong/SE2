package dataservice.basedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.BasePO;
import state.FindTypeBase;

/**
 * 提供公司基本运营数据的集体载入、保存和增删改查服务
 * @author zsq
 * @version Oct 22,2015
 */
public interface BaseDataService  extends ManageDataService<BasePO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BaseData";
	/**
	 * type是查找的类型，另一个参数是ACCOUNT对象
	 * @param baseType
	 * @return 账户持久化对象
	 */
	public ArrayList<BasePO> find(FindTypeBase baseType) throws RemoteException;
	
	public String getID(FindTypeBase baseType)throws RemoteException;
}
