package ui.commonui.receipt_constructor;

import state.ReceiptType;
import vo.OrderVO;
import vo.ValueObject;
import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.BranchArrivalListVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DeliveryListVO;
import vo.receiptvo.ExpenseVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.LoadingListVO;
import vo.receiptvo.TransferArrivalListVO;
import vo.receiptvo.TransferOrderVO;

public class ReceiptConductor {
	public String writeReceipt(ReceiptType receiptType,ValueObject receipt){
		
		if(receiptType.equals(ReceiptType.ORDER)){
			return writeOrder((OrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.CONFIRM)){
			return writeConfirm(receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_TRUCK)){
			return writeBranch_Truck((LoadingListVO)receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_ARRIVAL)){
			return writeBranch_Arrival((BranchArrivalListVO)receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_DELIVER)){
			return writeBranch_Deliver((DeliveryListVO)(receipt));
		}else if(receiptType.equals(ReceiptType.TRANS_ARRIVAL)){
			return writeTrans_Arrival((TransferArrivalListVO)receipt);
		}else if(receiptType.equals(ReceiptType.TRANS_PLANE)){
			return writeTrans_Plane((TransferOrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.TRANS_TRAIN)){
			return writeTrans_Train((TransferOrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.TRANS_TRUCK)){
			return writeTrans_Truck((TransferOrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.INSTOCK)){
			return writeInstock((InventoryImportReceiptVO)receipt);
		}else if(receiptType.equals(ReceiptType.OUTSTOCK)){
			return writeOutStock((InventoryExportReceiptVO)receipt);
		}else if(receiptType.equals(ReceiptType.TAKINGSTOCK)){
			return writeTakingStock((AdjustReceiptVO)receipt);
		}else if(receiptType.equals(ReceiptType.PAY)){
			return writePay((DebitAndPayBillVO)receipt);
		}else if(receiptType.equals(ReceiptType.EXPENSE)){
			return writeExpense((ExpenseVO)receipt);
		}
		return null;
		
	}

	private String writeExpense(ExpenseVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writePay(DebitAndPayBillVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeTakingStock(AdjustReceiptVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeOutStock(InventoryExportReceiptVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeInstock(InventoryImportReceiptVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeTrans_Truck(TransferOrderVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeTrans_Train(TransferOrderVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeTrans_Plane(TransferOrderVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeTrans_Arrival(TransferArrivalListVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeBranch_Deliver(DeliveryListVO deliveryListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeBranch_Arrival(BranchArrivalListVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeBranch_Truck(LoadingListVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeConfirm(ValueObject receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	private String writeOrder(OrderVO receipt) {
		// TODO Auto-generated method stub
		return null;
	}
}
