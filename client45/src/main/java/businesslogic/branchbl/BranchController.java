package businesslogic.branchbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.branchblservice.BranchBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
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
	/**
	 * 根据数据生成到达单保存到数据库并返回（我不知道到达单编号有什么用所以删掉了，如果别的用例需要编号你们可以补上）
	 * @param transferListID 到达单编号
	 * @param departure 营业厅离开点
	 * @param order 到达的订单对象
	 * @return
	 */
	public BranchArrivalListVO getBranchArrivalList(String departure, ArrayList<OrderVO> orders) {
		try {
			return BranchBL.getBranchArrivalList(departure, orders);
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
			ArrayList<String> orders, double money) {
		try {
			return BranchBL.truckDeliver(branchID, destination, facilityID, courierName, orders, money);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
