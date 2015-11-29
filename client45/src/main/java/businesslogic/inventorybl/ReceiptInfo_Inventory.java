package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ReceiptType;
import vo.receiptvo.ReceiptVO;

public interface ReceiptInfo_Inventory {
	@Deprecated
	public <T extends ReceiptVO> ArrayList<T> showInDateByType(String begin,String end,ReceiptType type) throws RemoteException;
}
