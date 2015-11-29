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

import config.RMIConfig;
import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

public class BankAccount {
	private BankAccountDataService bankAccountData;

	public BankAccount() {
		try {
			bankAccountData = (BankAccountDataService) Naming.lookup(RMIConfig.PREFIX + BankAccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
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

	public ResultMessage add(BankAccountVO vo) throws RemoteException {
		return bankAccountData.add(FundTrans.convertVOtoPO(vo));
	}

	public ResultMessage delete(String ID) throws RemoteException {
		return bankAccountData.delete(ID);
	}

	public ResultMessage update(BankAccountVO vo) throws RemoteException {
		return bankAccountData.modify(FundTrans.convertVOtoPO(vo));
	}

	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) throws RemoteException {
		ArrayList<BankAccountPO> pos =this.findByType(keywords, type);
		ArrayList<BankAccountVO> vos = FundTrans.convertBankAccountPOstoVOs(pos);
		return vos;
	}
	/**
	 * 按照选择的类型查找关键字
	 * @author Ann
	 * @see FindTypeAccount#toMethodName(FindTypeAccount)
	 * @see BankAccountPO#toString()
	 * @see BankAccountPO#getID()
	 * @see BankAccountPO#getName()
	 * @see BankAccountPO#getMoneyString()
	 * @param keywords 关键字
	 * @param type 查找类型，包括ID，帐户名，余额
	 * 						type为NULL时进行模糊查询
	 * @return 符合条件的BankAccountPO数组
	 * @throws RemoteException
	 */
	private ArrayList<BankAccountPO> findByType(String keywords, FindTypeAccount type) throws RemoteException {
		ArrayList<BankAccountPO> pos = bankAccountData.find();
		ArrayList<BankAccountPO> returnpos = new ArrayList<>();
		try {
			for (BankAccountPO bankAccountPO : pos) {
				//获得每个bankAccountPO的类
				Class<?> bankAccountPOClass = bankAccountPO.getClass();
				//根据type类型获得方法
				String methodName = FindTypeAccount.toMethodName(type);
				Method method = bankAccountPOClass.getDeclaredMethod(methodName);
				//调用bankAccountPO的方法获得要查找的字段
				String message = (String) method.invoke(bankAccountPO);
				//统一小写进行查询
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
