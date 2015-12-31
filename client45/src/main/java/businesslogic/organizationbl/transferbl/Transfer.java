package businesslogic.organizationbl.transferbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.CommonBusinessLogic;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.inventorybl.InventoryTrans;
import businesslogic.orderbl.OrderInfo;
import businesslogic.organizationbl.OrderInfo_Branch_Transfer;
import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.transferdataservice.TransferDataService;
import po.InventoryPO;
import po.TransferPO;
import state.CommodityState;
import state.ConfirmState;
import state.ReceiptType;
import state.ResultMessage;
import util.CityTrans;
import vo.CommodityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:36
 */
public class Transfer implements CommonBusinessLogic<TransferPO> {
	public  final static String BLNAME="Transfer";
	private OrderInfo_Branch_Transfer orderInfo;
	private ReceiptInfo_Transfer receiptInfo;
	private TransferDataService transferData;
	
	private InventoryInfo_Transfer inventoryInfo;
	public Transfer() throws MalformedURLException, RemoteException, NotBoundException {
		orderInfo = new OrderInfo();
		receiptInfo = new ReceiptInfo();
		transferData = (TransferDataService) Naming.lookup(RMIConfig.PREFIX + TransferDataService.NAME);
		inventoryInfo = new InventoryInfo();
	}

	public TransferDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (TransferDataService) Naming.lookup(RMIConfig.PREFIX + TransferDataService.NAME);
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
		for (String order : orders) {
			orderInfo.changeOrderStateToAPPROVING(order);
		}
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
		for (String order : orders) {
			orderInfo.changeOrderStateToAPPROVING(order);
		}
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
		for (String order : orders) {
			orderInfo.changeOrderStateToAPPROVING(order);
		}
		receiptInfo.add(vo);
		return vo;
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
		orderInfo.changeOrderStateToAPPROVING(order);
		receiptInfo.add(vo);
		return vo;
	}

	public String getTransferID(String city) throws RemoteException {
		String cityCode = CityTrans.getCodeByCity(city);
		return cityCode + transferData.getID()+"00";
	}

	public ResultMessage add(TransferPO transferPO) throws RemoteException {
		InventoryVO inventoryVO = inventoryInfo.getTransferInitialInventory(transferPO.getOrganizationID());
		ArrayList<InventoryPO> inventories = transferPO.getInventories();
		inventories.add(InventoryTrans.convertVOtoPO(inventoryVO));
		transferPO.setInventories(inventories);
		return transferData.add(transferPO);
	}

	public TransferPO delete(String organizationID) throws RemoteException {
		return  transferData.delete(organizationID);
	}

	public TransferPO modify(TransferPO transferPO) throws RemoteException {
		return transferData.modify(transferPO);
	}

	public ArrayList<TransferVO> showTransfer() throws RemoteException {
		ArrayList<TransferPO> pos = transferData.find();
		return TransferTrans.convertPOstoVOs(pos);
	}
	
	public ArrayList<String> getAllTransferNumbers() throws RemoteException {
		ArrayList<TransferPO> pos = transferData.find();
		ArrayList<String> transferNumbers = new ArrayList<>();
		for (TransferPO transferPO : pos) {
			transferNumbers.add(transferPO.getOrganizationID());
		}
		return transferNumbers;
	}

}
