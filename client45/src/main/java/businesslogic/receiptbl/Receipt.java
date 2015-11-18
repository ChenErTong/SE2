package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.receiptblservice.ReceiptBLService;
import dataservice.organizationdataservice.OrganizationDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import po.receiptpo.ReceiptPO;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class Receipt implements ReceiptBLService {
	private ReceiptDataService<ReceiptPO> receiptData;

	@SuppressWarnings("unchecked")
	public Receipt() {
		try {
			receiptData = (ReceiptDataService<ReceiptPO>) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + ReceiptDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultMessage updateReceipt(ReceiptVO receiptVO, ReceiptType receiptType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> showReceipt(ReceiptState receiptStates) {
		// TODO Auto-generated method stub
		return null;
	}

}
