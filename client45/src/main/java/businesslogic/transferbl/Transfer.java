package businesslogic.transferbl;

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
import dataservice.transferdataservice.TransferDataService;
import state.CommodityState;
import state.ConfirmState;
import state.ReceiptState;
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

	public TransferDataService getData() {
		try {
			return (TransferDataService) Naming.lookup(RMIConfig.PREFIX + TransferDataService.NAME);
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
	 * 获得所有的商品
	 * 
	 * @return ArrayList<CommodityVO>型，商品列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		return orderInfo.getAllCommodities();
	}

	/**
	 * 生成飞机转运单
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param facilityID
	 *            String型，航班号
	 * @param departure
	 *            String型，出发地
	 * @param destination
	 *            String型，到达地
	 * @param courierName
	 *            String型，监装员姓名
	 * @param orders
	 *            ArrayList<String>型，订单列表
	 * @param date
	 *            String型，日期
	 * @param id
	 *            String型，编号
	 * @return TransferOrderVO型，飞机转运单
	 * @throws RemoteException
	 *             远程异常
	 */
	public TransferOrderVO planeTransfer(String transferID, String facilityID, String departure, String destination,
			String courierName, ArrayList<String> orders, String date, String id) throws RemoteException {
		String ID = receiptInfo.getTransferDeliverID();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateInID = df.format(new Date());
		ID = transferID + dateInID + ID;
		TransferOrderVO vo = new TransferOrderVO(ID, facilityID, ReceiptType.TRANS_PLANE, departure, destination,
				courierName, orders);
		vo.date = date;
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心" + "送往" + destination + "中转中心");
		receiptInfo.add(vo);
		return vo;
	}

	/**
	 * 生成汽车转运单
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param facilityID
	 *            String型，汽车编号
	 * @param departure
	 *            String型，出发地
	 * @param destination
	 *            String型，到达地
	 * @param courierName
	 *            String型，监装员姓名
	 * @param orders
	 *            ArrayList<String>型，订单列表
	 * @param date
	 *            String型，日期
	 * @param id
	 *            String型，编号
	 * @return TransferOrderVO型，汽车转运单
	 * @throws RemoteException
	 *             远程异常
	 */
	public TransferOrderVO truckTransfer(String transferID, String facilityID, String departure, String destination,
			String courierName, ArrayList<String> orders, String date, String id) throws RemoteException {
		String ID = receiptInfo.getTransferDeliverID();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateInID = df.format(new Date());
		ID = transferID + dateInID + ID;
		TransferOrderVO vo = new TransferOrderVO(ID, facilityID, ReceiptType.TRANS_TRUCK, departure, destination,
				courierName, orders);
		vo.date = date;
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心" + "送往" + destination + "中转中心");
		receiptInfo.add(vo);
		return vo;
	}

	/**
	 * 生成火车转运单
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param facilityID
	 *            String型，车次号
	 * @param departure
	 *            String型，出发地
	 * @param destination
	 *            String型，到达地
	 * @param courierName
	 *            String型，监装员姓名
	 * @param orders
	 *            ArrayList<String>型，订单列表
	 * @param date
	 *            String型，日期
	 * @param id
	 *            String型，编号
	 * @return TransferOrderVO型，火车转运单
	 * @throws RemoteException
	 *             远程异常
	 */
	public TransferOrderVO trainTransfer(String transferID, String facilityID, String departure, String destination,
			String courierName, ArrayList<String> orders, String date, String id) throws RemoteException {
		String ID = receiptInfo.getTransferDeliverID();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateInID = df.format(new Date());
		ID = transferID + dateInID + ID;
		TransferOrderVO vo = new TransferOrderVO(ID, facilityID, ReceiptType.TRANS_TRAIN, departure, destination,
				courierName, orders);
		vo.date = date;
		// 更改VO状态
		orderInfo.changeOrderState(orders, "货物已离开" + departure + "中转中心" + "送往" + destination + "中转中心");
		receiptInfo.add(vo);
		return vo;
	}

	/**
	 * 提交单据
	 * 
	 * @param receipt
	 *            ReceiptVO型，单据
	 * @return ResultMessage型，是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage submit(ReceiptVO receipt) throws RemoteException {
		receipt.receiptState = ReceiptState.APPROVALING;
		return receiptInfo.modify(receipt);
	}

	/**
	 * 保存草稿状态
	 * 
	 * @param receiptReceiptVO型，单据
	 * @return ResultMessage型，是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage save(ReceiptVO receipt) throws RemoteException {
		receipt.receiptState = ReceiptState.DRAFT;
		return receiptInfo.add(receipt);
	}

	/**
	 * 生成中转中心到达单
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @param departure
	 *            String型，出发地
	 * @param destination
	 *            String型，到达地
	 * @param state
	 *            CommodityState型，商品状态
	 * @param order
	 *            String型，订单编号
	 * @return TransferArrivalListVO型，中转中心到达单
	 * @throws RemoteException
	 *             远程异常
	 */
	public TransferArrivalListVO receiptList(String transferID, String departure, String destination,
			CommodityState state, String order) throws RemoteException {
		String ID = receiptInfo.getTransferArrialID();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateInID = df.format(new Date());
		ID = transferID + dateInID + ID;
		TransferArrivalListVO vo = new TransferArrivalListVO(transferID, ReceiptType.TRANS_ARRIVAL, departure,
				destination, destination, state, order);
		// 更改VO状态 TODO 一堆
		if (!orderInfo.changeOrderState(order, "货物已到达" + destination + "中转中心"))
			return null;
		receiptInfo.add(vo);
		return vo;
	}

}
