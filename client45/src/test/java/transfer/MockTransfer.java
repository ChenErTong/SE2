package transfer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.organizationbl.transferbl.Transfer;
import state.CommodityState;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

public class MockTransfer extends Transfer {
	public MockTransfer() throws MalformedURLException, RemoteException, NotBoundException {
		super();
	}

	private TransferOrderVO transferOrderVO;
	private TransferArrivalListVO transferArrivalListVO;


	public void planeDepart(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		transferOrderVO = new TransferOrderVO("000",facilityID, null, departure, destination, courierName, orders);
		System.out.println("You have added a plane transfer");
	}

	public void receiptArrive(String transferID, String departure, String destination,CommodityState state, ArrayList<String> orders) {
		System.out.println("You have fielded a receipt");
	}

	public TransferOrderVO getTransferOrderVO() {
		return transferOrderVO;
	}

	public TransferArrivalListVO getTransferArrivalListVO() {
		return transferArrivalListVO;
	}

}
