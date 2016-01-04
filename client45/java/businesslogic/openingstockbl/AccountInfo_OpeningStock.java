package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.accountpo.AccountPO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:50
 */
public interface AccountInfo_OpeningStock {
	/**
	 * 查找当前所有用户
	 * 
	 * @return ArrayList<AccountPO>型，用户列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<AccountPO> find() throws RemoteException;
}
