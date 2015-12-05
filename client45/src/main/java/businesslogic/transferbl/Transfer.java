package businesslogic.transferbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.ldap.Rdn;

import businesslogic.orderbl.OrderInfo;
import businesslogic.organizationbl.OrderInfo_Branch_Transfer;
import businesslogic.organizationbl.ReceiptInfo_Branch_Transfer;
import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.transferdataservice.TransferDataService;
import state.CommodityState;
import state.ConfirmState;
import state.ReceiptCondition;
import state.ReceiptType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:36
 */
public class Transfer {
	private OrderInfo_Branch_Transfer orderInfo;
	private ReceiptInfo_Transfer receiptInfo;
	public Transfer() {
		orderInfo = new OrderInfo();
		receiptInfo = new ReceiptInfo();
	}
	
	public TransferDataService getData(){
		try {
			return (TransferDataService) Naming
					.lookup(RMIConfig.PREFIX + TransferDataService.NAME);
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

	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		return orderInfo.getAllCommodities();
	}

	public TransferOrderVO planeTransfer(String transferID,String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) throws RemoteException {
		String ID = receiptInfo.getTransferDeliverID();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateInID = df.format(new Date());
		ID=transferID+dateInID+ID;
		TransferOrderVO vo = new TransferOrderVO(ID,facilityID, ReceiptType.TRANS_PLANE, departure, destination,
				courierName, orders);
		vo.date = date;
		vo.ID = id;
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心"+"送往"+ destination + "中转中心");
		receiptInfo.add(vo);
		return vo;
	}

	public TransferOrderVO truckTransfer(String transferID,String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) throws RemoteException {
		String ID = receiptInfo.getTransferDeliverID();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateInID = df.format(new Date());
		ID=transferID+dateInID+ID;
		TransferOrderVO vo = new TransferOrderVO(ID,facilityID, ReceiptType.TRANS_TRUCK, departure, destination,
				courierName, orders);
		vo.date = date;
		vo.ID = id;
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心"+"送往"+ destination + "中转中心");
		receiptInfo.add(vo);
		return vo;
	}

	public TransferOrderVO trainTransfer(String transferID,String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) throws RemoteException {
		String ID = receiptInfo.getTransferDeliverID();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateInID = df.format(new Date());
		ID=transferID+dateInID+ID;
		TransferOrderVO vo = new TransferOrderVO(ID,facilityID, ReceiptType.TRANS_TRAIN, departure, destination,
				courierName, orders);
		vo.date = date;
		vo.ID = id;
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心"+"送往"+ destination + "中转中心");
		receiptInfo.add(vo);
		return vo;
	}

	public ResultMessage submit(ReceiptVO receipt) throws RemoteException {
		receipt.receiptCondition=ReceiptCondition.SUBITTED;
		return receiptInfo.modify(receipt);
	}

	public ResultMessage save(ReceiptVO receipt) throws RemoteException {
		return receiptInfo.add(receipt);
	}

	public TransferArrivalListVO receiptList(String transferID, String departure, String destination,
			CommodityState state, String orders) throws RemoteException {
		String ID = receiptInfo.getTransferArrialID();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateInID = df.format(new Date());
		ID=transferID+dateInID+ID;
		TransferArrivalListVO vo = new TransferArrivalListVO(transferID, ReceiptType.TRANS_ARRIVAL, departure,
				destination, destination, state, orders);
		//更改VO状态
		orderInfo.changeOrderState(orders, "货物已到达"+destination+"中转中心");
		receiptInfo.add(vo);
		return vo;
	}

}
