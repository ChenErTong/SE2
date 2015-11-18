package dataservice.funddataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;
import state.FindTypeAccount;
import state.ResultMessage;

/**
 * 提供银行账户数据的集体载入、保存和增删改查服务
 * @author zsq
 * @version Oct 22,2015
 */
	public interface BankAccountDataService {
		/** 接口的名称，RMI绑定时候的名称 */
		public static final String NAME = "BankAccountData";
	/**
	 * 向序列化文件中增加一个BankAccoutPO
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(BankAccountPO po) throws RemoteException;
	/**
	 * 根据ID删除序列化文件中的一个BankAccoutPO
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID) throws RemoteException;
	/**
	 * 更新BankPO
	 * @param PO
	 * @return 处理结果
	 */
	public ResultMessage update(BankAccountPO PO) throws RemoteException;
	
	
	/**
	 * 以keywords查看账户信息，type是查找的方式，为NULL则表示进行模糊查询
	 * @param keywords
	 * @return 账户持久化对象
	 */
	public ArrayList<BankAccountPO> find(String keywords,FindTypeAccount bankAccoutType) throws RemoteException;
}