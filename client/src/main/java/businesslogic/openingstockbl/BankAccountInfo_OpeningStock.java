package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月8日 下午10:54:17
 */
public interface BankAccountInfo_OpeningStock {
	/**
	 * 查找当前所有银行账户
	 * 
	 * @return ArrayList<BankAccountPO>型，银行账户列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<BankAccountPO> find() throws RemoteException;
}
