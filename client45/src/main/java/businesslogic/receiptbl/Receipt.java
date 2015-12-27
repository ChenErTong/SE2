package businesslogic.receiptbl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.fundbl.BankAccountInfo;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.logbl.LogController;
import businesslogic.orderbl.OrderInfo;
import businesslogic.orderbl.OrderTrans;
import config.RMIConfig;
import dataservice.receiptdataservice.ReceiptDataService;
import po.CommodityPO;
import po.receiptpo.DebitBillPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.PaymentBillPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.orderreceiptpo.BranchArrivalListPO;
import po.receiptpo.orderreceiptpo.DeliveryListPO;
import po.receiptpo.orderreceiptpo.LoadingListPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import po.receiptpo.orderreceiptpo.TransferOrderPO;
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
	private BankAccountInfo_Receipt bankAccountInfo;

	public Receipt() throws MalformedURLException, RemoteException, NotBoundException {
		receiptData = getData();
		inventoryInfo = new InventoryInfo();
		orderInfo = new OrderInfo();
		bankAccountInfo = new BankAccountInfo();
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
		case INSTOCK: 						approveInventoryImport(po); break;
		case OUTSTOCK:						approveInventoryExport(po);break;
		case BRANCH_ARRIVAL:			approveBranchArrial(po);break;
		case BRANCH_DELIVER:			approveBranchDelivery(po);break;
		case BRANCH_TRUCK:				approveBranchLoading(po);break;
		case TRANS_PLANE:
		case TRANS_TRAIN:
		case TRANS_TRUCK:				approveTransferOrder(po);break;
		case TRANS_ARRIVAL:			approveTransferArrival(po);break;
		case DEBIT:								approveDebit(po);break;
		case PAY:									approvePay(po);break;
		default:									break;
		}
	}

	private void approvePay(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过付款单");
		PaymentBillPO payBill = (PaymentBillPO) po;
		String accountID = payBill.getBankAccountID();
		BigDecimal money = payBill.getMoney();
		bankAccountInfo.subtractMoneyInBankAccount(accountID, money);
	}

	private void approveDebit(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过收款单");
		DebitBillPO debitBill = (DebitBillPO) po;
		String accountID = debitBill.getBankAccountID();
		BigDecimal money = debitBill.getMoney();
		bankAccountInfo.addMoneyInBankAccount(accountID, money);
	}

	private void approveTransferArrival(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过中转中心到达单");
		TransferArrivalListPO transferArrivalReceipt = (TransferArrivalListPO) po;
		String order = transferArrivalReceipt.getOrders();
		String destination = transferArrivalReceipt.getDestination();
		CommodityState state = transferArrivalReceipt.getState();
		orderInfo.changeOrderStateToTBE(order, "货物已到达" + destination + "中转中心",state);
	}

	private void approveTransferOrder(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过中转中心转运单");
		TransferOrderPO transferOrderReceipt = (TransferOrderPO) po;
		ArrayList<String> orders = transferOrderReceipt.getOrders();
		String departure = transferOrderReceipt.getDeparture();
		String destination = transferOrderReceipt.getDestination();
		orderInfo.changeOrderStateToExporting(orders, "货物已离开" + departure + "中转中心" + "送往" + destination + "中转中心");
	}

	private void approveBranchLoading(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过营业厅转运单");
		LoadingListPO loadingReceipt = (LoadingListPO) po;
		ArrayList<String> orders = loadingReceipt.getOrders();
		String destination = loadingReceipt.getDistination();
		orderInfo.changeOrderStateToExporting(orders, "货物已离开" + destination + "营业厅");
	}

	private void approveBranchDelivery(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过快递员派件单");
		DeliveryListPO deliveryReceipt = (DeliveryListPO) po;
		String order = deliveryReceipt.getOrders();
		String message = "订单正在被派件，派件员是"+deliveryReceipt.getCourierName();
		orderInfo.changeOrderStateToExporting(order, message);
	}

	private void approveBranchArrial(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过营业厅到达单");
		BranchArrivalListPO branchArrialReceipt = (BranchArrivalListPO) po;
		String orderID = branchArrialReceipt.getOrders();
		String departure = branchArrialReceipt.getDeparture();
		CommodityState state = branchArrialReceipt.getState();
		orderInfo.changeOrderStateToTBE(orderID, "货物已到达" + departure + "营业厅", state);
	}

	private void approveInventoryExport(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过仓库出库单");		
		InventoryExportReceiptPO exportReceipt = (InventoryExportReceiptPO) po;
		String transferID = exportReceipt.getTransferID();
		int area = exportReceipt.getArea();
		int row = exportReceipt.getRow();
		int frame = exportReceipt.getFrame();
		int position = exportReceipt.getPosition();
		inventoryInfo.inventoryExport(transferID, area, row, frame, position);
	}

	private void approveInventoryImport(ReceiptPO po) throws RemoteException {
		LogController.getInstance().addLog("审批通过仓库入库单");
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
//		System.out.println("---------------------------------------------");
		for (ReceiptPO receiptPO : pos) {
//			 System.out.println(receiptPO.getID());
//			 System.out.println(receiptPO.getReceiptState());
			boolean isCorrectType = receiptPO.getReceiptType().equals(type);
			boolean isCorrectState = receiptPO.getReceiptState().equals(state);
			if (isCorrectType && isCorrectState) {
				@SuppressWarnings("unchecked")
				T vo = (T) ReceiptTrans.convertPOtoVO(receiptPO);
				vos.add(vo);
			}
		}
//		System.out.println(vos.size());
//		System.out.println("---------------------------------------------");
		return vos;
	}
}
