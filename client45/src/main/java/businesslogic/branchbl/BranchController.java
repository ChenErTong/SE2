package businesslogic.branchbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.branchblservice.BranchBLService;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.BranchArrivalListVO;
import vo.receiptvo.DeliveryListVO;
import vo.receiptvo.LoadingListVO;

public class BranchController implements BranchBLService {
     Branch BranchBL;
	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return BranchBL.confirmOperation();
	}

	@Override
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		// TODO Auto-generated method stub
		return BranchBL.getAllCommodities();
	}

	@Override
	public ArrayList<String> getAllOrderNumber() throws RemoteException {
		// TODO Auto-generated method stub
		return BranchBL.getAllOrderNumber();
	}

	@Override
	public BranchArrivalListVO getBranchArrivalList(String transferListID, String departure, CommodityState state,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return BranchBL.getBranchArrivalList(transferListID, departure, state, orders);
	}

	@Override
	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName) {
		// TODO Auto-generated method stub
		return BranchBL.getDeliveryList(orders, courierName);
	}

	@Override
	public ResultMessage submit(ReceiptPO receipt) throws RemoteException {
		// TODO Auto-generated method stub
		return BranchBL.submit(receipt);
	}

	@Override
	public ResultMessage save(ReceiptPO receipt) throws RemoteException {
		// TODO Auto-generated method stub
		return BranchBL.save(receipt);
	}

	@Override
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return BranchBL.truckDeliver(branchID, destination, facilityID, courierName, orders);
	}

}
