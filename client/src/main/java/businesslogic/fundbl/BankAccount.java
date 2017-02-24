package businesslogic.fundbl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.CommonBusinessLogic;
import config.RMIConfig;
import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:01
 */
public class BankAccount implements CommonBusinessLogic<BankAccountPO>{
	public  final static String BLNAME="BankAccount";
	private BankAccountDataService bankAccountData;
	
	public BankAccount() throws MalformedURLException, RemoteException, NotBoundException {
		bankAccountData = getData();
	}

	public BankAccountDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (BankAccountDataService) Naming.lookup(RMIConfig.PREFIX + BankAccountDataService.NAME);
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public String getID() throws RemoteException {
		return bankAccountData.getID();
	}

	public ArrayList<BankAccountVO> show() throws RemoteException {
		ArrayList<BankAccountPO> bankaccounts = bankAccountData.find();
		return FundTrans.convertBankAccountPOstoVOs(bankaccounts);
	}


	public ResultMessage add(BankAccountPO po) throws RemoteException {
		return bankAccountData.add(po);
	}

	public BankAccountPO delete(String ID) throws RemoteException {
		return  bankAccountData.delete(ID);
		
	}

	public BankAccountPO modify(BankAccountPO po) throws RemoteException {
		return bankAccountData.modify(po);
	}

	

	

	/**
	 * 模糊查找账户
	 * 
	 * @param keywords
	 *            String型，关键字
	 * @param type
	 *            FindTypeAccount型，查找类型
	 * @return ArrayList<BankAccountVO>型，符合条件的账户
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) throws RemoteException {
		ArrayList<BankAccountPO> pos = this.findByType(keywords, type);
		ArrayList<BankAccountVO> vos = FundTrans.convertBankAccountPOstoVOs(pos);
		return vos;
	}

	/**
	 * 按照选择的类型查找关键字
	 * 
	 * @author Ann
	 * @see FindTypeAccount#toMethodName(FindTypeAccount)
	 * @see BankAccountPO#toString()
	 * @see BankAccountPO#getID()
	 * @see BankAccountPO#getName()
	 * @see BankAccountPO#getMoneyString()
	 * @param keywords
	 *            关键字
	 * @param type
	 *            查找类型，包括ID，帐户名，余额 type为NULL时进行模糊查询
	 * @return 符合条件的BankAccountPO数组
	 * @throws RemoteException
	 */
	private ArrayList<BankAccountPO> findByType(String keywords, FindTypeAccount type) throws RemoteException {
		ArrayList<BankAccountPO> pos = bankAccountData.find();
		ArrayList<BankAccountPO> returnpos = new ArrayList<>();
		try {
			for (BankAccountPO bankAccountPO : pos) {
				// 获得每个bankAccountPO的类
				Class<?> bankAccountPOClass = bankAccountPO.getClass();
				// 根据type类型获得方法
				String methodName = FindTypeAccount.toMethodName(type);
				Method method = bankAccountPOClass.getDeclaredMethod(methodName);
				// 调用bankAccountPO的方法获得要查找的字段
				String message = (String) method.invoke(bankAccountPO);
				// 统一小写进行查询
				if (message.toLowerCase().contains(keywords.toLowerCase()))
					returnpos.add(bankAccountPO);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return returnpos;
	}

}
