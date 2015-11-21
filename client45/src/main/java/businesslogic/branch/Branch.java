package businesslogic.branch;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.OrderTrans;
import businesslogicservice.branchblservice.BranchBLService;
import dataservice.basedataservice.BaseDataService;
import dataservice.branchdataservice.BranchDataService;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
import vo.receiptvo.BranchArrivalListVO;
import vo.receiptvo.DeliveryListVO;
import vo.receiptvo.LoadingListVO;

public class Branch{
	private OrderDataService orderData;
	public Branch() {
		try {
			orderData = (OrderDataService) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + OrderDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CommodityVO> getAllCommodities() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage submit(ReceiptPO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage save(ReceiptPO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

}
