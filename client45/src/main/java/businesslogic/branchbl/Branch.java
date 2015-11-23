package businesslogic.branchbl;
/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.OrderTrans;
import config.RMIConfig;
import dataservice.orderdataservice.OrderDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import po.OrderPO;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ConfirmState;
import state.ReceiptCondition;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
import vo.receiptvo.BranchArrivalListVO;
import vo.receiptvo.DeliveryListVO;
import vo.receiptvo.LoadingListVO;

public class Branch{
	private OrderDataService orderData;
	private ReceiptDataService  receiptData;
	public Branch() {
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
			ArrayList<CommodityVO> commos = orderPO.getCommodityVO();
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
		ArrayList<OrderVO> orderVOs = OrderTrans.convertPOstoVOs(orderPOs);
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
			orderNumbers.add(orderVO.getOrderIdString());
		}
		return orderNumbers;
	}

	public BranchArrivalListVO getBranchArrivalList(String transferListID, String departure, CommodityState state,
			ArrayList<String> orders) {
		BranchArrivalListVO vo = new BranchArrivalListVO(transferListID, transferListID, departure, state, orders);
		return vo;
	}

	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName) {
		//TODO getID
		String ID = receiptData.getID();
		DeliveryListVO vo = new DeliveryListVO(ID, orders, courierName);
		return vo;
	}

	public ResultMessage submit(ReceiptPO receipt) throws RemoteException {
	    receipt.setReceiptCondition(ReceiptCondition.SUBITTED);
		return receiptData.modify(receipt);
	}

	public ResultMessage save(ReceiptPO receipt) throws RemoteException {
		receiptData.add(receipt);
		return  receiptData.add(receipt);
	}

	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
		String ID = receiptData.getID();
		LoadingListVO vo = new LoadingListVO(ID, branchID, destination, facilityID, courierName, orders);
		return vo;
	}
	
	

}
