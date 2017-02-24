package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransferPO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:23
 */
public interface TransferInfo_OpeningStock {
	/**
	 * 查找当前所有中转中心
	 * 
	 * @return ArrayList<TransferPO>型，中转中心列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<TransferPO> find() throws RemoteException;
}
