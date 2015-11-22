package dataservice.funddataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.BankAccountPO;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

/**
 * 提供银行账户数据的集体载入、保存和增删改查服务
 * @author zsq
 * @version Oct 22,2015
 */
	public interface BankAccountDataService extends ManageDataService<BankAccountPO>{
		/** 接口的名称，RMI绑定时候的名称 */
		public static final String NAME = "BankAccountData";
	
	
	
	/**
	 * 以keywords查看账户信息，type是查找的方式，为NULL则表示进行模糊查询
	 * @param keywords
	 * @return 账户持久化对象
	 */
	public ArrayList<BankAccountPO> find(String keywords,FindTypeAccount bankAccoutType) throws RemoteException;
	/**
	 * 提出创建/新增银行账户时返回账户ID
	 *
	 */
	public String getID();
	
	public ArrayList<BankAccountVO> show();
		
	
	
	
	
	
	
	
	
	}