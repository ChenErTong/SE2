package transfer;

import java.util.ArrayList;

import businesslogic.transferbl.Transfer;
import state.CommodityState;
import vo.receiptvo.TransferArrivalListVO;
import vo.receiptvo.TransferOrderVO;

public class MockTransfer extends Transfer {
	private TransferOrderVO transferOrderVO;
	private TransferArrivalListVO transferArrivalListVO;

	public MockTransfer() {
	}

	public void planeDepart(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		transferOrderVO = new TransferOrderVO(facilityID, departure, destination, courierName, orders);
		System.out.println("You have added a plane transfer");
	}

	public void receiptArrive(String transferID, String departure, CommodityState state, ArrayList<String> orders) {
		transferArrivalListVO = new TransferArrivalListVO(transferID, transferID,departure, state, orders);
		System.out.println("You have fielded a receipt");
	}

	public TransferOrderVO getTransferOrderVO() {
		return transferOrderVO;
	}

	public TransferArrivalListVO getTransferArrivalListVO() {
		return transferArrivalListVO;
	}

}
