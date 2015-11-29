package businesslogic.branchbl;

import java.rmi.RemoteException;

import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public interface ReceiptInfo_Branch_Transfer {
	public ResultMessage add(ReceiptVO vo) throws RemoteException;
	public ResultMessage modify(ReceiptVO vo)throws RemoteException;
	public String getID()throws RemoteException;
}
