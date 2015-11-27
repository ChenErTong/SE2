package businesslogic.branchbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.branchblservice.BranchBLService;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;

public class BranchController implements BranchBLService {
     Branch BranchBL = new Branch();
	@Override
	public ConfirmState confirmOperation() {
		return BranchBL.confirmOperation();
	}

	@Override
	public ArrayList<CommodityVO> getAllCommodities() {
		try {
			return BranchBL.getAllCommodities();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<String> getAllOrderNumber()  {
		try {
			return BranchBL.getAllOrderNumber();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BranchArrivalListVO getBranchArrivalList(String transferListID, String departure, CommodityState state,
			ArrayList<String> orders) {
		try {
			return BranchBL.getBranchArrivalList(transferListID, departure, state, orders);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName) {
		try {
			return BranchBL.getDeliveryList(orders, courierName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submit(ReceiptVO receipt) {
		try {
			return BranchBL.submit(receipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage save(ReceiptVO receipt)  {
		try {
			return BranchBL.save(receipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
		try {
			return BranchBL.truckDeliver(branchID, destination, facilityID, courierName, orders);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
