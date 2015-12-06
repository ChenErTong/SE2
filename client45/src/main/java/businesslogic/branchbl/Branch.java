package businesslogic.branchbl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.orderbl.OrderInfo;
import businesslogic.organizationbl.OrderInfo_Branch_Transfer;
import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.branchdataservice.BranchDataService;
import state.CommodityState;
import state.ConfirmState;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:06
 */
public class Branch{
	private OrderInfo_Branch_Transfer orderInfo;
	private ReceiptInfo_Branch receiptInfo;
	public Branch() {
		orderInfo = new OrderInfo();
		receiptInfo = new ReceiptInfo();
	}
	
	public BranchDataService getData(){
		try {
			return (BranchDataService)Naming.lookup(RMIConfig.PREFIX+BranchDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}
	/**
	 * 得到所有的VO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		return orderInfo.getAllCommodities();
	}
	/**
	 * 获取所有的订单号
	 * @return
	 * @throws RemoteException
	 */
	/**
	 * @author Ann
	 * TODO 要重写
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<String> getAllOrderNumber() throws RemoteException {
		ArrayList<OrderVO> orderVOs = getAllOrders();
		ArrayList<String> orderNumbers = new ArrayList<>();
		for (OrderVO orderVO : orderVOs) {
			orderNumbers.add(orderVO.ID);
		}
		return orderNumbers;
	}

	public BranchArrivalListVO getBranchArrivalList(String departure,CommodityState orderState,
			OrderVO order) throws RemoteException {
		 CommodityState state = CommodityState.Complete;
		 String transferListID=receiptInfo.getID();
		 String orderID = order.ID;
		BranchArrivalListVO vo = new BranchArrivalListVO(transferListID, ReceiptType.BRANCH_ARRIVAL, transferListID, departure, state, orderID);
		//更改VO状态
		orderInfo.changeOrderState(orderID,  "货物已到达" + departure + "营业厅",orderState);
		receiptInfo.add(vo);
		return vo;
	}

	public DeliveryListVO getDeliveryList(String orders, String courierName) throws RemoteException {
		String ID = receiptInfo.getID();
		DeliveryListVO vo = new DeliveryListVO(ID, ReceiptType.BRANCH_DELIVER, orders, courierName);
		return vo;
	}

	public ResultMessage submit(ReceiptVO receipt) throws RemoteException {
		receipt.receiptState=ReceiptState.APPROVALING;
		return receiptInfo.modify(receipt);
	}

	public ResultMessage save(ReceiptVO receipt) throws RemoteException {
		receipt.receiptState=ReceiptState.DRAFT;
		return  receiptInfo.add(receipt);
	}

	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders, double money) throws RemoteException {
		String ID = receiptInfo.getBranchTruckID();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateInID = df.format(new Date());
		ID=branchID+dateInID+ID;
		LoadingListVO vo = new LoadingListVO(ID, ReceiptType.BRANCH_TRUCK, branchID, destination, branchID,facilityID, courierName,courierName, orders, money);
		//更改VO状态 TODO
		orderInfo.changeOrderState(orders, "货物已离开"+destination+"营业厅");
		receiptInfo.add(vo);
		return vo;
	}

	/**
	 * 获得所有的订单
	 * @author Ann
	 * @return
	 * @throws RemoteException
	 */
	private ArrayList<OrderVO> getAllOrders() throws RemoteException {
		return orderInfo.getAllOrders();
	}

}
