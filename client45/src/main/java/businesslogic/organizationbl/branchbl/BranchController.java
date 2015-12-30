package businesslogic.organizationbl.branchbl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.branchblservice.BranchBLService;
import state.CommodityState;
import state.ConfirmState;
import vo.CommodityVO;
import vo.OrderVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:10
 */
public class BranchController implements BranchBLService {
	Branch BranchBL;
	
	public BranchController() throws MalformedURLException, RemoteException, NotBoundException {
		BranchBL = new Branch();
		
	}

	@Override
	public ConfirmState confirmOperation() {
		return BranchBL.confirmOperation();
	}

	/**
	 * @see BranchBLService#getAllCommodities()
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		return BranchBL.getAllCommodities();
	}

	/**
	 * @see BranchBLService#getAllOrderNumber()
	 */
	public ArrayList<String> getAllOrderNumber() throws RemoteException {
		return BranchBL.getAllOrderNumber();
	}

	// /**
	// * 根据数据生成到达单保存到数据库并返回（我不知道到达单编号有什么用所以删掉了，如果别的用例需要编号你们可以补上）
	// * @param transferListID 到达单编号
	// * @param departure 营业厅离开点
	// * @param order 到达的订单对象
	// * @return
	// */
	/*
	 * public BranchArrivalListVO getBranchArrivalList(String departure,
	 * CommodityState state, OrderVO orders) { try { return
	 * BranchBL.getBranchArrivalList(departure,state, orders); } catch
	 * (RemoteException e) { e.printStackTrace(); } return null; }
	 */

	/**
	 * @see BranchBLService#getDeliveryList(String, String)
	 */
	public DeliveryListVO getDeliveryList(String orders, String courierName) throws RemoteException {
		LogController.getInstance().addLog("生成快递员派件单");
		return BranchBL.getDeliveryList(orders, courierName);
	}

//	/**
//	 * @see BranchBLService#submit(ReceiptVO)
//	 */
//	public ResultMessage submit(ReceiptVO receipt) throws RemoteException {
//		return BranchBL.submit(receipt);
//	}
//
//	/**
//	 * @see BranchBLService#save(ReceiptVO)
//	 */
//	public ResultMessage save(ReceiptVO receipt) throws RemoteException {
//		return BranchBL.save(receipt);
//	}

	/**
	 * @see BranchBLService#truckDeliver(String, String, String, String,
	 *      ArrayList, BigDecimal)
	 */
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String facilityNumber, String courierName,
			ArrayList<String> orders, BigDecimal money) throws RemoteException {
		LogController.getInstance().addLog("生成营业厅装车单");
		return BranchBL.truckDeliver(branchID, destination, facilityID, facilityNumber, courierName, orders, money);
	}

	/**
	 * @see BranchBLService#getBranchArrivalList(String, CommodityState,
	 *      OrderVO)
	 */
	public BranchArrivalListVO getBranchArrivalList(String departure, CommodityState state, OrderVO orders)
			throws RemoteException {
		LogController.getInstance().addLog("生成营业厅到达单");
		return BranchBL.getBranchArrivalList(departure, state, orders);
	}

	@Override
	public ArrayList<String> getAllExportingOrders() throws RemoteException {
		return BranchBL.getAllExportingOrders();
	}

	@Override
	public ArrayList<String> getAllToBeExportedOrders() throws RemoteException {
		return BranchBL.getAllToBeExportedOrders();
	}
}
