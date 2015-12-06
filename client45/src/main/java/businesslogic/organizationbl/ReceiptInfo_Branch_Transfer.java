package businesslogic.organizationbl;

import java.rmi.RemoteException;

import state.ResultMessage;
import vo.receiptvo.ReceiptVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:40
 */
public interface ReceiptInfo_Branch_Transfer {
	public String getID()throws RemoteException;
	public ResultMessage add(ReceiptVO vo) throws RemoteException;
	public ResultMessage modify(ReceiptVO vo)throws RemoteException;
}
