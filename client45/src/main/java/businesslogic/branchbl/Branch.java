package businesslogic.branchbl;
/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.OrderInfo;
import businesslogic.orderbl.OrderTrans;
import businesslogic.receiptbl.ReceiptTrans;
import config.RMIConfig;
import dataservice.orderdataservice.OrderDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import po.CommodityPO;
import po.OrderPO;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ConfirmState;
import state.ReceiptCondition;
import state.ReceiptType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;

public class Branch{
	private OrderDataService orderData;
	private ReceiptDataService  receiptData;
	private OrderInfo orderInfo;
	public Branch() {
		orderInfo = new OrderInfo();
		try {
			orderData = (OrderDataService) Naming.lookup(RMIConfig.PREFIX + OrderDataService.NAME);
			receiptData = (ReceiptDataService ) Naming.lookup(RMIConfig.PREFIX + ReceiptDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
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
		//获取所有的订单
		ArrayList<OrderPO> orderPOs = orderData.find();
		ArrayList<CommodityVO> commodityVOs = new ArrayList<>();
		//获取单个订单
		for (OrderPO orderPO : orderPOs) {
			//单个订单中所有的商品
			ArrayList<CommodityPO> pos  =orderPO.getCommodityPO();
			ArrayList<CommodityVO> commos = OrderTrans.convertCommodityPOstoVOs(pos);
			//将每个商品加入商品列表
			for (CommodityVO commodityVO : commos) {
				commodityVOs.add(commodityVO);
			}
		}
		return null;
	}
	/**
	 * 获得所有的订单
	 * @author Ann
	 * @return
	 * @throws RemoteException
	 */
	private ArrayList<OrderVO> getAllOrders() throws RemoteException {
		ArrayList<OrderPO> orderPOs = orderData.find();
		ArrayList<OrderVO> orderVOs = OrderTrans.convertOrderPOstoVOs(orderPOs);
		return orderVOs;
	}
	/**
	 * 获取所有的订单号
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

	public BranchArrivalListVO getBranchArrivalList(String transferListID, String departure, CommodityState state,
			ArrayList<String> orders) throws RemoteException {
		BranchArrivalListVO vo = new BranchArrivalListVO(transferListID, ReceiptType.BRANCH_ARRIVAL, transferListID, departure, state, orders);
		//更改VO状态
		orderInfo.changeOrderState(orders,   "货物已离开" + departure + "营业厅");
		return vo;
	}

	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName) throws RemoteException {
		//TODO
		String ID = receiptData.getID();
		DeliveryListVO vo = new DeliveryListVO(ID, ReceiptType.BRANCH_DELIVER, orders, courierName);
		return vo;
	}

	public ResultMessage submit(ReceiptVO receipt) throws RemoteException {
		ReceiptPO po = ReceiptTrans.convertVOtoPO(receipt);
		po.setReceiptCondition(ReceiptCondition.SUBITTED);
		return receiptData.modify(po);
	}

	public ResultMessage save(ReceiptVO receipt) throws RemoteException {
		ReceiptPO po = ReceiptTrans.convertVOtoPO(receipt);
		return  receiptData.add(po);
	}

	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders, double money) throws RemoteException {
		String ID = receiptData.getID();
		LoadingListVO vo = new LoadingListVO(ID, ReceiptType.BRANCH_TRUCK, branchID, destination, branchID,facilityID, courierName,courierName, orders, money);
		//更改VO状态
		orderInfo.changeOrderState(orders, "货物已到达"+destination+"营业厅");
		return vo;
	}

}
