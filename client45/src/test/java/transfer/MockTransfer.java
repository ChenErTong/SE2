package transfer;

import java.util.ArrayList;

import businesslogic.transferbl.Transfer;
import state.CommodityState;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

public class MockTransfer extends Transfer {
	private TransferOrderVO transferOrderVO;
	private TransferArrivalListVO transferArrivalListVO;

	public MockTransfer() {
	}

	public void planeDepart(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		transferOrderVO = new TransferOrderVO(facilityID, null, departure, destination, courierName, orders);
		System.out.println("You have added a plane transfer");
	}

	public void receiptArrive(String transferID, String departure, String destination,CommodityState state, ArrayList<String> orders) {
		transferArrivalListVO = new TransferArrivalListVO(transferID, null, transferID, departure, destination,state, orders);
		System.out.println("You have fielded a receipt");
	}

	public TransferOrderVO getTransferOrderVO() {
		return transferOrderVO;
	}

	public TransferArrivalListVO getTransferArrivalListVO() {
		return transferArrivalListVO;
	}

}
