package businesslogicservice.receiptblservice;

import java.util.ArrayList;

import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;
@Deprecated
public interface ReceiptShowService {
	public ArrayList<ReceiptVO> show();
	public ArrayList<BranchArrivalListVO> showBranchArrivalList();
	public ArrayList<DeliveryListVO> showDeliveryList();
	public ArrayList<LoadingListVO> showLoadingList();
	public ArrayList<TransferArrivalListVO> showTransferArrivalList();
	public ArrayList<TransferOrderVO> showTransferOrder();
	public ArrayList<AdjustReceiptVO> showAdjustReceipt();
	public ArrayList<DebitBillVO> showDebitBill();
	public ArrayList<InventoryExportReceiptVO> showInventoryExportReceipt();
	public ArrayList<InventoryImportReceiptVO> showInventoryImportReceipt();
	public ArrayList<PaymentBillVO> showPaymentBill();
	
}
