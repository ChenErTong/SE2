package branch;

import java.util.ArrayList;

import businesslogic.branchbl.Branch;
import state.CommodityState;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;

public class MockBranch extends Branch {
	private LoadingListVO loadingListVO;
	private DeliveryListVO deliveryListVO;
	private BranchArrivalListVO branchArrivalListVO;
	
	public void mockTruckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
	}
	
	public void mockDeliveryList(ArrayList<String> orders, String courierName) {
		deliveryListVO = new DeliveryListVO("BRANCH008", null, orders, courierName);
	}
	
	public void mockBranchArrivalList(String transferListID, String departure, CommodityState state,
			ArrayList<String> orders) {
		branchArrivalListVO = new BranchArrivalListVO(transferListID, null, transferListID, departure, state, orders);
	}


	public LoadingListVO getLoadingListVO() {
		return loadingListVO;
	}


	public DeliveryListVO getDeliveryListVO() {
		return deliveryListVO;
	}

	public BranchArrivalListVO getBranchArrivalListVO() {
		return branchArrivalListVO;
	}
	
	
}
