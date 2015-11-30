package businesslogic.receiptbl;

import java.util.ArrayList;

import businesslogicservice.receiptblservice.ReceiptShowService;
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
public class ReceiptShowController implements ReceiptShowService {

	@Override
	public ArrayList<ReceiptVO> show() {
		return null;
	}

	@Override
	public ArrayList<BranchArrivalListVO> showBranchArrivalList() {
		return null;
	}

	@Override
	public ArrayList<DeliveryListVO> showDeliveryList() {
		return null;
	}

	@Override
	public ArrayList<LoadingListVO> showLoadingList() {
		return null;
	}

	@Override
	public ArrayList<TransferArrivalListVO> showTransferArrivalList() {
		return null;
	}

	@Override
	public ArrayList<TransferOrderVO> showTransferOrder() {
		return null;
	}

	@Override
	public ArrayList<AdjustReceiptVO> showAdjustReceipt() {
		return null;
	}

	@Override
	public ArrayList<DebitBillVO> showDebitBill() {
		return null;
	}

	@Override
	public ArrayList<InventoryExportReceiptVO> showInventoryExportReceipt() {
		return null;
	}

	@Override
	public ArrayList<InventoryImportReceiptVO> showInventoryImportReceipt() {
		return null;
	}

	@Override
	public ArrayList<PaymentBillVO> showPaymentBill() {
		return null;
	}

}
