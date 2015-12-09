package receipt;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.receiptbl.Receipt;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class MockReceipt extends Receipt{
	public MockReceipt() throws MalformedURLException, RemoteException, NotBoundException {
		super();
	}

	@Override
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs) {
		System.out.println("These receipts have passed!");
		return null;
	}
}
