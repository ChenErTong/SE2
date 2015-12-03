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
	public ArrayList<TransferPO> find() throws RemoteException;
}
