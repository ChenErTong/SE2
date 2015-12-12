package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.inventorybl.InventoryInfo;
import businesslogic.orderbl.OrderTrans;
import config.RMIConfig;
import dataservice.receiptdataservice.ReceiptDataService;
import po.CommodityPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.orderreceiptpo.BranchArrivalListPO;
import po.receiptpo.orderreceiptpo.DeliveryListPO;
import po.receiptpo.orderreceiptpo.LoadingListPO;
import state.CommodityState;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.ReceiptVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:50
 */
public class Receipt {
	private ReceiptDataService receiptData;
	private InventoryInfo_Receipt inventoryInfo;
	private OrderInfo_Receipt orderInfo;

	public Receipt() throws MalformedURLException, RemoteException, NotBoundException {
		receiptData = getData();
		inventoryInfo = new InventoryInfo();
	}

	public ReceiptDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (ReceiptDataService) Naming.lookup(RMIConfig.PREFIX + ReceiptDataService.NAME);
	}

	public ResultMessage updateReceipt(ReceiptVO receiptVO) throws RemoteException {
		ReceiptPO po = ReceiptTrans.convertVOtoPO(receiptVO);
		return receiptData.modify(po)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
	}

	/**
	 * 通过单据
	 * 
	 * @param VOs
	 *            ArrayList<ReceiptVO>型，单据列表
	 * @return ResultMessage型，通过是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException {
		ResultMessage message = ResultMessage.SUCCESS;
		for (ReceiptVO vo : VOs) {
			ReceiptPO po = ReceiptTrans.convertVOtoPO(vo);
			po.setReceiptState(ReceiptState.SUCCESS);
			ResultMessage messagePass = receiptData.modify(po)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
			if (messagePass == ResultMessage.FAIL){
				message = ResultMessage.FAIL;
			}else{
				this.approve(po);
			}
				
		}
		return message;
	}

	private void approve(ReceiptPO po) throws RemoteException {
		ReceiptType type = po.getReceiptType();
		switch(type){
		case INSTOCK: 						approveInventoryImport(po);
		case OUTSTOCK:						approveInventoryExport(po);
		case BRANCH_ARRIVAL:			approveBranchArrial(po);
		case BRANCH_DELIVER:			approveBranchDelivery(po);
		case BRANCH_TRUCK:				approveBranchLoading(po);
		default:									break;
		}
	}

	private void approveBranchLoading(ReceiptPO po) throws RemoteException {
		LoadingListPO loadingReceipt = (LoadingListPO) po;
		ArrayList<String> orders = loadingReceipt.getOrders();
		String destination = loadingReceipt.getDistination();
		orderInfo.changeOrderState(orders, "货物已离开" + destination + "营业厅");
	}

	private void approveBranchDelivery(ReceiptPO po) throws RemoteException {
		DeliveryListPO deliveryReceipt = (DeliveryListPO) po;
		String order = deliveryReceipt.getOrders();
		String message = "订单正在被派件，派件员是"+deliveryReceipt.getCourierName();
		orderInfo.changeOrderState(order, message);
	}

	private void approveBranchArrial(ReceiptPO po) throws RemoteException {
		BranchArrivalListPO branchArrialReceipt = (BranchArrivalListPO) po;
		String orderID = branchArrialReceipt.getOrders();
		String departure = branchArrialReceipt.getDeparture();
		//TODO 应该是orderState
		CommodityState state = branchArrialReceipt.getState();
		orderInfo.changeOrderState(orderID, "货物已到达" + departure + "营业厅", state);
	}

	private void approveInventoryExport(ReceiptPO po) throws RemoteException {
		InventoryExportReceiptPO exportReceipt = (InventoryExportReceiptPO) po;
		String transferID = exportReceipt.getTransferID();
		int area = exportReceipt.getArea();
		int row = exportReceipt.getRow();
		int frame = exportReceipt.getFrame();
		int position = exportReceipt.getPosition();
		inventoryInfo.inventoryExport(transferID, area, row, frame, position);
	}

	private void approveInventoryImport(ReceiptPO po) throws RemoteException {
		InventoryImportReceiptPO importReceipt = (InventoryImportReceiptPO) po;
		String transferID = importReceipt.getTransferID();
		CommodityPO commodityPO = importReceipt.getCommodityPO();
		CommodityVO commodity = OrderTrans.convertPOtoVO(commodityPO);
		int area = importReceipt.getArea();
		int row = importReceipt.getRow();
		int frame = importReceipt.getFrame();
		int position = importReceipt.getPosition();
		inventoryInfo.inventoryImport(transferID, commodity, area, row, frame, position);
	}

	/**
	 * 不通过单据
	 * 
	 * @param VOs
	 *            ArrayList<ReceiptVO>型，单据列表
	 * @return ResultMessage型，不通过是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException {
		ResultMessage message = ResultMessage.SUCCESS;
		for (ReceiptVO vo : VOs) {
			ReceiptPO po = ReceiptTrans.convertVOtoPO(vo);
			po.setReceiptState(ReceiptState.FAILURE);
			ResultMessage messagePass = receiptData.modify(po)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
			if (messagePass == ResultMessage.FAIL)
				message = ResultMessage.FAIL;
		}
		return message;
	}

	/**
	 * 根据type的类型返回特定类型的单据ArrayList
	 * 
	 * @author Ann
	 * @param type
	 *            单据类型
	 * @param state
	 *            单据状态
	 * @return 特定类型的单据ArrayList
	 * @throws RemoteException
	 */
	public <T extends ReceiptVO> ArrayList<T> show(ReceiptType type, ReceiptState state) throws RemoteException {
		ArrayList<ReceiptPO> pos = receiptData.find();
		ArrayList<T> vos = new ArrayList<>();
		for (ReceiptPO receiptPO : pos) {
			// System.out.println(receiptPO.getID());
			// System.out.println(receiptPO.getReceiptState());
			boolean isCorrectType = receiptPO.getReceiptType().equals(type);
			boolean isCorrectState = receiptPO.getReceiptState().equals(state);
			if (isCorrectType)
				System.out.println("state " + isCorrectState + " " + state);
			if (isCorrectType && isCorrectState) {
				@SuppressWarnings("unchecked")
				T vo = (T) ReceiptTrans.convertPOtoVO(receiptPO);
				System.out.println(vo.toString());
				vos.add(vo);
			}
		}
		return vos;
	}
}
