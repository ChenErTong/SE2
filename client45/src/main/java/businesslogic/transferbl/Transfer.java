package businesslogic.transferbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.OrderInfo;
import businesslogic.orderbl.OrderTrans;
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
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

public class Transfer {
	//TODO 依赖倒置
	private ReceiptDataService receiptData;
	private OrderDataService orderDataService;
	private OrderInfo orderInfo;
	public Transfer() {
		orderInfo = new OrderInfo();
		try {
			receiptData = (ReceiptDataService) Naming.lookup(RMIConfig.PREFIX + ReceiptDataService.NAME);
			orderDataService = (OrderDataService) Naming.lookup(RMIConfig.PREFIX + OrderDataService.NAME);
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

	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		ArrayList<OrderPO> orders = orderDataService.find();
		ArrayList<CommodityVO> vos=new ArrayList<>();
		for (OrderPO orderPO : orders) {
			ArrayList<CommodityPO> posForSingleOrder = orderPO.getCommodityPO();
			ArrayList<CommodityVO> vosForSingleOrder = OrderTrans.convertCommodityPOstoVOs(posForSingleOrder);
			for (CommodityVO commodityVO : vosForSingleOrder) {
				vos.add(commodityVO);
			}
		}
		return vos;
	}

	public TransferOrderVO planeTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) throws RemoteException {
		String ID = receiptData.getID();
		TransferOrderVO vo = new TransferOrderVO(ID,facilityID, ReceiptType.TRANS_PLANE, departure, destination,
				courierName, orders);
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心"+"送往"+ destination + "中转中心");
		return vo;
	}

	public TransferOrderVO truckTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) throws RemoteException {
		String ID = receiptData.getID();
		TransferOrderVO vo = new TransferOrderVO(ID,facilityID, ReceiptType.TRANS_TRUCK, departure, destination,
				courierName, orders);
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心"+"送往"+ destination + "中转中心");
		return vo;
	}

	public TransferOrderVO trainTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) throws RemoteException {
		String ID = receiptData.getID();
		TransferOrderVO vo = new TransferOrderVO(ID,facilityID, ReceiptType.TRANS_TRAIN, departure, destination,
				courierName, orders);
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心"+"送往"+ destination + "中转中心");
		return vo;
	}

	public ResultMessage submit(ReceiptPO receipt) throws RemoteException {
		receipt.setReceiptCondition(ReceiptCondition.SUBITTED);
		return receiptData.modify(receipt);
	}

	public ResultMessage save(ReceiptPO receipt) throws RemoteException {
		receiptData.add(receipt);
		return receiptData.add(receipt);
	}

	public TransferArrivalListVO receiptList(String transferID, String departure, String destination,
			CommodityState state, ArrayList<String> orders) throws RemoteException {
		TransferArrivalListVO vo = new TransferArrivalListVO(transferID, ReceiptType.TRANS_ARRIVAL, departure,
				destination, destination, state, orders);
		//更改VO状态
		orderInfo.changeOrderState(orders, "货物已到达"+destination+"中转中心");
		return vo;
	}

}
