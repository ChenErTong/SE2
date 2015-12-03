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
	public ArrayList<AccountPO> find() throws RemoteException;
}
